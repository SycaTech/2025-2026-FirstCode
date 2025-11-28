package org.firstinspires.ftc.teamcode.subsystems;

import android.health.connect.datatypes.units.Power;

import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.control.KineticState;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.hardware.impl.MotorEx;

public class BaseClimb {
    public static final BaseClimb INSTANCE = new BaseClimb();
    private BaseClimb() {}
    private MotorEx telescope;
    private ControlSystem controlSystem;

    double targetPosition = 0;


    private final double MaxPower = 1.0;
    private final double MinimumPower = 0.0;

    public static final int ClosedPos = 0;
    public static final int OpenPos = 180;

    //Init

    public void init(HardwareMap hwMap) {
        telescope = hwMap.get(MotorEx.class, "Telescope");

        controlSystem = ControlSystem.builder()
                .posPid(0.5, 0.0, 0.0)
                .build();
    }

    //Loop

    public void update() {
        if (telescope == null || controlSystem == null) return;

        KineticState currentState = new KineticState(
                telescope.getCurrentPosition(),
                telescope.getVelocity(),
                0
        );

        controlSystem.setGoal(new KineticState(targetPosition, 0.0, 0.0));

        double power = controlSystem.calculate(currentState);

        if (power > MaxPower) power = MaxPower;
        if (power < -MaxPower) power = -MaxPower;

        telescope.setPower(power);
    }

    //Command
    public Command OpenTelescope() {
        return new InstantCommand(() -> {
            targetPosition = OpenPos;
        });
    }

    public Command CloseTelescope() {
        return new InstantCommand(() -> {
            targetPosition = ClosedPos;
        });
    }
    public void power(double power){
        telescope.setPower(power);
    }
}
