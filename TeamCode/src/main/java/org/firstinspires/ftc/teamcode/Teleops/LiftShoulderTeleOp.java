package org.firstinspires.ftc.teamcode.Teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.bindings.Button;
import dev.nextftc.core.commands.CommandManager;
import dev.nextftc.ftc.NextFTCOpMode;

import static dev.nextftc.bindings.Bindings.button;

import android.transition.Slide;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.LiftShoulder;

@TeleOp(name = "LiftShoulder TeleOp")
public class LiftShoulderTeleOp extends NextFTCOpMode {

    private LiftShoulder liftShoulder = LiftShoulder.INSTANCE;

    @Override
    public void onInit() {
        liftShoulder.init();
    }

    @Override
    public void onUpdate() {
        Button Y = button(() -> gamepad1.y);
        Y.whenBecomesTrue(liftShoulder.toHigh);

        Button B = button(() -> gamepad1.b);
        B.whenBecomesTrue(liftShoulder.toMiddle);

        Button A = button(() -> gamepad1.a);
        A.whenBecomesTrue(liftShoulder.toLow);

        Button X = button(() -> gamepad1.x);
        X.whenBecomesTrue(liftShoulder.toSetPoint(250));

        CommandManager.INSTANCE.scheduleCommand(LiftShoulder.INSTANCE.d());
    }

}

