package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.hardware.impl.MotorEx;

public class Test {
    private DcMotor motorex;
    public Test(HardwareMap hardwareMap) {
        motorex = hardwareMap.get(DcMotor.class, "Lift");
        motorex.setPower(0);
    }

    public void run(double power) {
        motorex.setPower(1.0);
    }

    public void stop() {
        motorex.setPower(0);
    }
}

