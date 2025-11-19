package org.firstinspires.ftc.teamcode.Teleops;

import static dev.nextftc.bindings.Bindings.button;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.Intake;

import dev.nextftc.bindings.Button;

public class IntakeTeleop extends OpMode {
    Intake intake = new Intake();


    @Override
    public void init() {
        intake.init(hardwareMap);
    }

    @Override
    public void loop() {
        Button rightTrigger = button(() -> gamepad1.right_trigger > 0.1);
        rightTrigger.whenTrue(() -> {
            double power = gamepad1.right_trigger;
            intake.Intake(power);
        });

    }
}
