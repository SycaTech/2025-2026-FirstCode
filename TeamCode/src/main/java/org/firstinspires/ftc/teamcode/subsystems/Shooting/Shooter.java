package org.firstinspires.ftc.teamcode.subsystems.Shooting;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.hardware.impl.MotorEx;

public class Shooter {
    private MotorEx Shooter;

    public void init(HardwareMap hwMap) {
        Shooter = hwMap.get(MotorEx.class, "Shooter");
    }

    public Command Shoot() {
        return new InstantCommand(() -> {
           Shooter.setPower(1);
        });
    }
}
