package org.firstinspires.ftc.teamcode.Teleops;

import static dev.nextftc.bindings.Bindings.button;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.Transfer.Indexer_Shooter;
import org.firstinspires.ftc.teamcode.subsystems.Transfer.Star_Indexer;

import dev.nextftc.bindings.Button;

@TeleOp(name = "Transfer Teleop", group = "Transfer")
public class TransferTeleop extends OpMode {
    Star_Indexer transfer = new Star_Indexer();
    Indexer_Shooter toShoot = new Indexer_Shooter();

    @Override
    public void init() {
        transfer.init(hardwareMap);
        toShoot.init(hardwareMap);


    }

    @Override
    public void loop() {
        Button BALL1_BTN = button(() -> gamepad1.dpad_up); //rotate to ball 1 pos
        BALL1_BTN.whenBecomesTrue(() -> transfer.Ball1());

        Button BALL2_BTN = button(() -> gamepad1.dpad_left); //rotate to ball 2 pos
        BALL2_BTN.whenBecomesTrue(() -> transfer.Ball2());

        Button BALL3_BTN = button(() -> gamepad1.dpad_right); //rotate to ball 3 pos
        BALL3_BTN.whenBecomesTrue(() -> transfer.Ball3());

        if (gamepad1.a) {
            toShoot.setServoPos(-1.0); // move ball to the shooter
        }
        else {
            toShoot.setServoPos(1.0);
        }
    }
}
