package org.firstinspires.ftc.teamcode.subsystems.Shooting;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;

public class Shooter {
    private DcMotor Shooter;

    public void init(HardwareMap hwMap) {
        Shooter = hwMap.get(DcMotor.class, "Shooter");
    }

    public Command Shoot() {
        return new InstantCommand(() -> {
           Shooter.setPower(1);
        });
    }
}
