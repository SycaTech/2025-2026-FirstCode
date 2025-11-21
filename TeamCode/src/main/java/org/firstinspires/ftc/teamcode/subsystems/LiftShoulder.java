package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.hardware.impl.MotorEx;

public class LiftShoulder{

    private MotorEx LiftShoulderL;
    private MotorEx LiftShoulderR;

    public static final int POSE_LOW = 0;
    public static final int POSE_MIDDLE = 500;
    public static final int POSE_HIGH = 700;

    public void init(HardwareMap hwMap) {
        LiftShoulderL = hwMap.get(MotorEx.class, "Master");
        LiftShoulderR = hwMap.get(MotorEx.class, "Slave");
    }
    public ControlSystem controlSystem = ControlSystem.builder()
            .posPid(0.005, 0.0001, 0.0)
            .elevatorFF(0.1)
            .build();

    public Command toHigh(){
        return new InstantCommand(() -> LiftShoulderL.atPosition(POSE_HIGH));
    }
    public Command toMiddle(){
        return new InstantCommand(() -> LiftShoulderL.atPosition(POSE_MIDDLE));
    }
    public Command toLow(){
        return new InstantCommand(() -> LiftShoulderL.atPosition(POSE_LOW));
    }

    public Command toSetPoint(int setpoint) {
        return new InstantCommand(()-> LiftShoulderL.atPosition(setpoint));
    }

    public void periodic() {
        LiftShoulderR.setPower(LiftShoulderL.getPower());
    }
}