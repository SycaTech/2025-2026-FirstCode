package org.firstinspires.ftc.teamcode.Teleops;

import static dev.nextftc.bindings.Bindings.button;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.Shooting.AngleChanger;
import org.firstinspires.ftc.teamcode.subsystems.Shooting.Shooter;

import dev.nextftc.bindings.Button;
import dev.nextftc.core.commands.CommandManager;

public class ShootingTeleop extends OpMode {
    AngleChanger angleChanger = new AngleChanger();
    Shooter shooter = new Shooter();

    private double currentAngle = 0.5;
    private final double step = 0.05;

    @Override
    public void init() {
        angleChanger.init(hardwareMap);
        shooter.init(hardwareMap);
        angleChanger.setServoPos(currentAngle);
    }

    @Override
    public void loop() {
        //Angle Change
        Button DpadDown = button(() -> gamepad1.dpad_down);
        DpadDown.whenBecomesTrue(() -> {
            currentAngle -= step;
            if (currentAngle < 0.0) currentAngle = 0.0;
            angleChanger.setServoPos(currentAngle);
        });

        Button DpadUp = button(() -> gamepad1.dpad_up);
        DpadUp.whenBecomesTrue(() -> {
            currentAngle += step;
            if (currentAngle > 1.0) currentAngle = 1.0;
            angleChanger.setServoPos(currentAngle);
        });

        //Shooter
        Button A  = button(() -> gamepad1.a);
        A.whenTrue(() -> shooter.shoot())
         .whenFalse(() -> shooter.stop());

        shooter.update();
    }
}
