package org.firstinspires.ftc.teamcode.subsystems;

import android.health.connect.datatypes.units.Power;

import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.hardware.impl.MotorEx;

public class BaseClimb {
    private MotorEx telescope;
    double MaxPower = 1.0;
    double MinimumPower = 0.0;
    public static final int ClosedPos = 0;
    public static final int OpenPos = 180;

    public void init(HardwareMap hwMap) {
        telescope = hwMap.get(MotorEx.class, "Telescope");
    }

    public ControlSystem controlSystem = ControlSystem.builder()
            .posPid(0,0,0)
            .elevatorFF(0)
            .build();

    public Command OpenTelescope() {
        return new InstantCommand(() -> {
            telescope.atPosition(OpenPos);
            power(MaxPower);

        });
    }

    public Command CloseTelescope() {
        return new InstantCommand(() -> {
            telescope.setCurrentPosition(ClosedPos);
            power(MinimumPower);
        });
    }
    public void power(double power){
        telescope.setPower(power);
    }
}
