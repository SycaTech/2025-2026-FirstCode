package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;

public class Intake implements Subsystem {
    private DcMotorEx intakeMotor;

    public void init(HardwareMap hwMap) {
        intakeMotor =hwMap.get(DcMotorEx.class, "intakeMotor");

    }
    public Command power(){
        return new InstantCommand(() -> {
            intakeMotor.setPower(1.0);
        });
    };
}
