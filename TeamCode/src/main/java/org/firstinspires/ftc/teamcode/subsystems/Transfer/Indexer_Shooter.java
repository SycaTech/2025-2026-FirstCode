package org.firstinspires.ftc.teamcode.subsystems.Transfer;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Indexer_Shooter {
    private Servo IndexerShooterServo;

    public void init(HardwareMap hwMap) {
        IndexerShooterServo = hwMap.get(Servo.class, "IndexerShooterServo");
    }

    public void setServoPos(double angle) {
        IndexerShooterServo.setPosition(angle);
    }
}
