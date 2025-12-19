package org.firstinspires.ftc.teamcode.subsystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.core.subsystems.Subsystem;

public class LiftShoulder implements Subsystem {

    public static final LiftShoulder INSTANCE = new LiftShoulder();

    public final String MOTOR_LEFT_NAME = "LF";
    public final String MOTOR_RIGHT_NAME = "Slave";

    public DcMotor motorLeft;
    public DcMotor motorRight;

    public static final int POSE_LOW = -200;
    public static final int POSE_MIDDLE = 0;
    public static final int POSE_HIGH = 500;


    private LiftShoulder() {
        motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        motorRight.setPower(0);
    }

    public ControlSystem controlSystem = ControlSystem.builder()
            .posPid(0.005, 0.0001, 0.0)
            .elevatorFF(0.1)
            .build();

//    public Command toMiddle = new RunToPosition(controlSystem, POSE_MIDDLE);
//    public Command toHigh = new RunToPosition(controlSystem, POSE_HIGH);
//
    public Command toHigh(){
        return new InstantCommand(() -> {
            motorLeft.setTargetPosition(POSE_HIGH);
        });
    }
    public Command toMiddle(){
        return new InstantCommand(() -> {
            motorLeft.setTargetPosition(POSE_MIDDLE);
        });
    }
    public Command toLow(){
        return new InstantCommand(() -> {
            motorLeft.setTargetPosition(POSE_LOW);
        });
    }

    public Command toSetPoint(int setpoint) {
        return new InstantCommand(()->{motorLeft.setTargetPosition(setpoint);});
    }

    @Override
    public void periodic() {
        motorRight.setPower(motorLeft.getPower());
    }
}