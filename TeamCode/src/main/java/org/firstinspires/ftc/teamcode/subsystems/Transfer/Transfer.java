package org.firstinspires.ftc.teamcode.subsystems.Transfer;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.delays.Delay;
import dev.nextftc.core.commands.groups.SequentialGroup;
import dev.nextftc.hardware.impl.ServoEx;
import dev.nextftc.hardware.positionable.SetPosition;

public class Transfer {
    private ServoEx toShootServo;
    private DcMotorEx rotateMotor;

    public void init(HardwareMap hwMap) {
        rotateMotor = hwMap.get(DcMotorEx.class, "Rotate");
        toShootServo = hwMap.get(ServoEx.class, "ToShoot");

    }
   public void power(){
        rotateMotor.setPower(1.0);
    }

    public Command toShoot() {
        return new SequentialGroup(
                new SetPosition(toShootServo, 1),     // shoot
                new Delay(250),                 // wait a bit
                new SetPosition(toShootServo, 0)      // reset
        );
    }


}


