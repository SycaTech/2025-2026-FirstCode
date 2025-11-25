package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.control.KineticState;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;

public class LiftShoulder implements Subsystem {
    Telemetry telemetry;

    private MotorEx Master;
    private MotorEx Slave;
    private ControlSystem controller;


    public static final int POSE_LOW = 0;
    public static final int POSE_MIDDLE = 500;
    public static final int POSE_HIGH = 1200;

    public void init(HardwareMap hwMap) {
        Master = new MotorEx(hwMap.get(DcMotorEx.class, "Master"));
        Slave = new MotorEx(hwMap.get(DcMotorEx.class, "Slave"));

        Slave.setPower(Master.getPower());

        controller = ControlSystem.builder()
                .posPid(0.2, 0.0, 0.0)
                .elevatorFF(0.0)
                .build();

        controller.setGoal(new KineticState(0.0));
    }

    public void goToPosition(double toPose) {
        controller.setGoal(new KineticState(toPose));
    }

    public Command toHigh(){
        return new InstantCommand(() -> goToPosition(POSE_HIGH));
    }
    public Command toMiddle(){
        return new InstantCommand(() -> goToPosition(POSE_MIDDLE));
    }
    public Command toLow(){
        return new InstantCommand(() -> goToPosition(POSE_LOW));
    }

    public Command toSetPoint(int setpoint) {
        return new InstantCommand(()-> Master.atPosition(setpoint));
    }

    public void power(double power){
        Master.setPower(power);
        Slave.setPower(power);
    }
}