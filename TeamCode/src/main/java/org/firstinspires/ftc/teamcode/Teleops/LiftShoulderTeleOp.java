package org.firstinspires.ftc.teamcode.Teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.bindings.Button;

import static dev.nextftc.bindings.Bindings.button;

import org.firstinspires.ftc.teamcode.subsystems.LiftShoulder;

@TeleOp(name = "LiftShoulder TeleOp")
public class LiftShoulderTeleOp extends OpMode {
    LiftShoulder liftShoulder = new LiftShoulder();

    @Override
    public void init() {
        liftShoulder.init(hardwareMap);
    }

    @Override
    public void loop() {
        liftShoulder.periodic();

        Button A = button(() -> gamepad1.a);
        A.whenBecomesTrue(() -> liftShoulder.toLow());

        Button B = button(() -> gamepad1.b);
        B.whenBecomesTrue(() -> liftShoulder.toMiddle());

        Button Y = button(() -> gamepad1.y);
        Y.whenBecomesTrue(() -> liftShoulder.toHigh());

        Button X = button(() -> gamepad1.x);
        X.whenBecomesTrue(() -> liftShoulder.toSetPoint(250));
    }
}