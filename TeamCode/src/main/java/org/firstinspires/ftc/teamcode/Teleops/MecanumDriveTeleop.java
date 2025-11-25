package org.firstinspires.ftc.teamcode.Teleops;

import static dev.nextftc.bindings.Bindings.button;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;

import dev.nextftc.bindings.Button;

@TeleOp(name = "MecanumDriveTeleop")
public class MecanumDriveTeleop extends OpMode {
    MecanumDrive drive = new MecanumDrive();
    double forward,strafe, rotate;

    @Override
    public void init() {
        drive.init(hardwareMap);
        drive.resetYaw();
    }

    @Override
    public void loop() {
        forward = -gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        drive.drive(forward, strafe, rotate);

        Button B = button(() -> gamepad1.b);
        B.whenBecomesTrue(drive.resetYaw());
    }





}
