package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;

public class Intake implements Subsystem {
    private MotorEx Intake;

    public void init(HardwareMap hwMap) {
        Intake = hwMap.get(MotorEx.class, "Intake");
    }

    public Command Intake(double power) {
        return new InstantCommand(() -> {
            Intake.setPower(power);
        });
    }


}
