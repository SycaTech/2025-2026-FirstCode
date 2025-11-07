package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import dev.nextftc.control.ControlSystem;

public class Baseckimb {
    private DcMotorEx basemotor;
    double velocity = basemotor.getVelocity();
    double setpoint = 800;




    public int getTicks() {
        return basemotor.getCurrentPosition();
    }

    public void setTargetPosition(int ticks) {
        setpoint = ticks;
        basemotor.setTargetPosition(ticks);
        basemotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        basemotor.setPower(1.0);
    }

















}
