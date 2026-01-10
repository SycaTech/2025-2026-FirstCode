package org.firstinspires.ftc.teamcode.subsystems.Shooting;

import com.qualcomm.robotcore.hardware.HardwareMap;


import dev.nextftc.control.ControlSystem;
import dev.nextftc.control.KineticState;
import dev.nextftc.core.commands.Command;
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
                .build();

        controller.setGoal(new KineticState(0.0));
    }


    public void update() {
        if (shooter == null || controller == null) return;

        shooter.setPower(controller.calculate(
                shooter.getVelocity()
        ));
    }


    public void shoot() {
        targetVelocity = 500;
    }

    public void stop() {
        targetVelocity = 0;
    }
}
