package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.hardware.impl.ServoEx;

public class Shooting {
    private DcMotorEx Shootmotor;
    private ServoEx ShootServo;

    public void init(HardwareMap hwMap) {
        Shootmotor = hwMap.get(DcMotorEx.class, "ShootMotor");
        ShootServo = hwMap.get(ServoEx.class, "ShootServo");
    }

   public Command servopower(){
        return new InstantCommand(() -> {
            ShootServo.setPosition(1.0);
        });
   };
   public void power(){
       Shootmotor.setPower(1.0);
}
}