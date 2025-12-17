package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;

public class Intake implements Subsystem {
    public static final Intake INSTANCE = new Intake();
    private Intake() {}

    private MotorEx IntakeMotor;
    double fullSpeed = 1.0;

    public void init(HardwareMap hwMap) {
        IntakeMotor = hwMap.get(MotorEx.class, "Intake");
    }

    public void power(double power) {
        IntakeMotor.setPower(power);
    }

    public Command intake() {
        return new InstantCommand(() -> {
            power(fullSpeed);
        });
    }





}
