package org.firstinspires.ftc.teamcode.subsystems.Shooting;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import dev.nextftc.core.commands.Command;

public class AngleChanger {
    private Servo AngleChangeServo;

    public void init(HardwareMap hwMap) {
        AngleChangeServo = hwMap.get(Servo.class, "AngleChangeServo");
    }

    public void setServoPos(double angle) {
        AngleChangeServo.setPosition(angle);
    }

    public Command changeAngle
}
