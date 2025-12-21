package org.firstinspires.ftc.teamcode.subsystems.Shooting;

import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.control.KineticState;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;

public class Shooter implements Subsystem {
    public static final Shooter INSTANCE = new Shooter();
    private Shooter() {}
    private MotorEx shooter;
    private ControlSystem controller;

    private double targetVelocity = 0;


    public void init(HardwareMap hwMap) {
        shooter = hwMap.get(MotorEx.class, "Shooter");

        controller = ControlSystem.builder()
                .velPid(0.1,0.01,0.05)
                .basicFF(0.02, 0.0, 0.01)
                .build();
    }
    public Command toLow = new RunToPosition(controlSystem, 0).requires(this);
    public Command toHigh = new RunToPosition(controlSystem, 1200).requires(this);

    public void update() {
        if (shooter == null || controller == null) return;

        double currentVel = shooter.getVelocity();

        KineticState state = new KineticState(0.0, currentVel, 0.0);

        controller.setGoal(new KineticState(0.0, targetVelocity, 0.0));

        double power = controller.calculate(state);

        shooter.setPower(power);
    }

    //COMMANDS

    public void shoot() {
        targetVelocity = 500;
    }

    public void stop() {

    }
}
