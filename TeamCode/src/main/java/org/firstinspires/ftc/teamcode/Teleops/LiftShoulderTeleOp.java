package org.firstinspires.ftc.teamcode.Teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.bindings.Button;
import dev.nextftc.core.commands.CommandManager;

import static dev.nextftc.bindings.Bindings.button;

import android.transition.Slide;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.LiftShoulder;

@TeleOp(name = "LiftShoulder TeleOp")
public class LiftShoulderTeleOp extends OpMode {

//    LiftShoulder liftShoulder = new LiftShoulder();

    @Override
    public void init() {
//        liftShoulder.init(hardwareMap);
    }

    @Override
    public void loop() {
    }

//        Button Y = button(() -> gamepad1.y);
//        Y.whenBecomesTrue(() -> liftShoulder.toHigh().schedule());
//        telemetry.addData("button y", gamepad1.y);
//        if (gamepad1.y) {
//            liftShoulder.toHigh();
//        }
//
//        Button B = button(() -> gamepad1.b);
//        B.whenBecomesTrue(() -> liftShoulder.toMiddle().schedule());
//        telemetry.addData("button b", gamepad1.b);
//        if (gamepad1.b) {
//            liftShoulder.toMiddle();
//        }
//
//
//        Button A = button(() -> gamepad1.a);
//        A.whenBecomesTrue(() -> liftShoulder.toLow().schedule());
//        CommandManager.INSTANCE.scheduleCommand(liftShoulder.toHigh());
//        telemetry.addData("button a", gamepad1.a);
//        if (gamepad1.a) {
//            liftShoulder.toLow();
//        }
//
//        Button X = button(() -> gamepad1.x);
//        X.whenBecomesTrue(() -> liftShoulder.toSetPoint(250).schedule());
//        telemetry.addData("button x", gamepad1.x);
//        if (gamepad1.x) {
//            liftShoulder.toSetPoint(250);
//        }
    }

