package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;


import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.controllable.MotorGroup;
import dev.nextftc.hardware.controllable.RunToPosition;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.hardware.positionable.SetPosition;
import dev.nextftc.hardware.positionable.SetPositions;

public class LiftShoulder implements Subsystem {
    public static final LiftShoulder INSTANCE = new LiftShoulder();
    private LiftShoulder() {}

    private MotorEx Master;
    private MotorEx Slave;

    private final ControlSystem controller = ControlSystem.builder()
            .posPid(0.005, 0,0)
            .build();

    public String NameMaster = "LF";
    public String NameSlave = "LR";

    public static final int POSE_LOW = 0;
    public static final int POSE_MIDDLE = 500;
    public static final int POSE_HIGH = 1200;
    MotorGroup mm = new MotorGroup(Master , Slave);

    public void init() {

        Master = new MotorEx(NameMaster).zeroed();
        Slave = new MotorEx(NameSlave).reversed().zeroed();



    }

    public Command toLow = new RunToPosition(controller, POSE_LOW).requires(this);
    public Command toMiddle = new RunToPosition(controller, POSE_MIDDLE).requires(this);
    public Command toHigh = new RunToPosition(controller, POSE_HIGH).requires(this);
    public Command d(){
        return new InstantCommand(()-> {Master.atPosition(300);});
    }


    public Command toSetPoint(int setpoint) {
        return new InstantCommand(()-> Master.atPosition(setpoint));
    }


    public void periodic() {
        mm.setPower(controller.calculate(Master.getState()));

    }

}
