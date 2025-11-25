package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;

public class Intake implements Subsystem {
    private MotorEx IntakeMotor;

    public void init(HardwareMap hwMap) {
        IntakeMotor = hwMap.get(MotorEx.class, "Intake");
    }

    public Command intake(double power) {
        return new InstantCommand(() -> {
            IntakeMotor.setPower(power);
        });
    }


}
