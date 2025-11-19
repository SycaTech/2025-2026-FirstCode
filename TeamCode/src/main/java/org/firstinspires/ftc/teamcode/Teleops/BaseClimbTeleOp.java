package org.firstinspires.ftc.teamcode.Teleops;

import static dev.nextftc.bindings.Bindings.button;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.BaseClimb;

import dev.nextftc.bindings.Button;

public class BaseClimbTeleOp extends OpMode {
    BaseClimb baseClimb = new BaseClimb();

    @Override
    public void init() {
        baseClimb.init(hardwareMap);
    }

    @Override
    public void loop() {
        Button RightBumper = button(() -> gamepad1.right_bumper);
        RightBumper.whenBecomesTrue(() -> baseClimb.OpenTelescope());

        Button LeftBumper = button(() -> gamepad1.left_bumper);
        LeftBumper.whenBecomesTrue(() -> baseClimb.CloseTelescope());
    }
}
