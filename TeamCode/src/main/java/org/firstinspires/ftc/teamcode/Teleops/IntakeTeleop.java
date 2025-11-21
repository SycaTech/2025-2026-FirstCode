package org.firstinspires.ftc.teamcode.Teleops;

import static dev.nextftc.bindings.Bindings.button;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Intake;

import dev.nextftc.bindings.Button;

@TeleOp(name = "IntakeTeleop")
public class IntakeTeleop extends OpMode {
    Intake Intake = new Intake();


    @Override
    public void init() {
        Intake.init(hardwareMap);
    }

    @Override
    public void loop() {
        Button rightTrigger = button(() -> gamepad1.right_trigger > 0.1);
        rightTrigger.whenTrue(() -> {
            double power = gamepad1.right_trigger;
            Intake.intake(power);
        });

    }
}
