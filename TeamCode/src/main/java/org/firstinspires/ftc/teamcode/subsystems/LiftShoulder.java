package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.groups.ParallelGroup;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.hardware.impl.MotorEx;

public class LiftShoulder{
    Telemetry telemetry;

    private MotorEx LiftShoulderL;
    private MotorEx LiftShoulderR;

    public static final int POSE_LOW = 0;
    public static final int POSE_MIDDLE = 500;
    public static final int POSE_HIGH = 1200;

    public void init(HardwareMap hwMap) {
        LiftShoulderL = new MotorEx(hwMap.get(DcMotorEx.class, "Master"));
        LiftShoulderR = new MotorEx(hwMap.get(DcMotorEx.class, "Slave"));
    }
    public ControlSystem controlSystem = ControlSystem.builder()
            .posPid(0.0, 0.0, 0.0)
            .elevatorFF(0.0)
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

    public Command power() {
        return new ParallelGroup(
                new InstantCommand(() -> LiftShoulderL.setPower(0.5)),
                new InstantCommand(() -> LiftShoulderR.setPower(0.5))
        );
    }

    public void periodic() {
        LiftShoulderR.setPower(LiftShoulderL.getPower());
    }
}