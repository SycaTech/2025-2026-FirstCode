package org.firstinspires.ftc.teamcode.subsystems.Shooting;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.control.KineticState;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.hardware.impl.MotorEx;

public class Shooter {
    private MotorEx Shooter;

    public void init(HardwareMap hwMap) {
        Shooter = hwMap.get(MotorEx.class, "Shooter");

         ControlSystem controller = ControlSystem.builder()
                .posPid(0.005,0,0)
                .elevatorFF(0)
                .build();

         controller.setGoal(new KineticState(0.0));
    }

    public Command Shoot() {
        return new InstantCommand(() -> {
           Shooter.setPower(1);
        });
    }
}
