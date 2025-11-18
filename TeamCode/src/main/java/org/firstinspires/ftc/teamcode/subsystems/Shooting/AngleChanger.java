package org.firstinspires.ftc.teamcode.subsystems.Shooting;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class AngleChanger {
    private Servo AngleChangeServo;

    public void init(HardwareMap hwMap) {
        AngleChangeServo = hwMap.get(Servo.class, "AngleChangeServo");
    }
}
