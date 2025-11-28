package org.firstinspires.ftc.teamcode.Teleops;

import static dev.nextftc.bindings.Bindings.button;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.BaseClimb;

import dev.nextftc.bindings.Button;

@TeleOp(name = "BaseClimb")
public class BaseClimbTeleOp extends OpMode {
    private BaseClimb baseClimb = BaseClimb.INSTANCE;

    @Override
    public void init() {
        baseClimb.init(hardwareMap);
    }

    @Override
    public void loop() {
        Button rightBumper = button(() -> gamepad1.right_bumper);
        rightBumper.whenBecomesTrue(() -> baseClimb.OpenTelescope());

        Button leftBumper = button(() -> gamepad1.left_bumper);
        leftBumper.whenBecomesTrue(() -> baseClimb.CloseTelescope());

        baseClimb.update();
    }
}
