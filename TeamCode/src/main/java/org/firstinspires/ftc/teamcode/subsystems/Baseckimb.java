package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import dev.nextftc.control.ControlSystem;

public class Baseckimb {
    private DcMotorEx basemotor;
    new ResetEncoder(DcMotorEx, this)


    private ControlSystem controlSystem = ControlSystem.builder()
            .posPid(0.000, 0, 0)
            .elevatorFF(0)
            .build();











}
