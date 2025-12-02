//package org.firstinspires.ftc.teamcode.subsystems;
//
//import com.pedropathing.control.PIDFController;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//
//import dev.nextftc.control.ControlSystem;
//import dev.nextftc.control.KineticState;
//import dev.nextftc.control.feedforward.BasicFeedforward;
//import dev.nextftc.core.commands.Command;
//import dev.nextftc.core.commands.utility.InstantCommand;
//import dev.nextftc.core.subsystems.Subsystem;
//import dev.nextftc.hardware.controllable.RunToPosition;
//import dev.nextftc.hardware.impl.MotorEx;
//
//public class LiftShoulder implements Subsystem {
//    public static final LiftShoulder INSTANCE = new LiftShoulder();
//    private LiftShoulder() {}
//    public MotorEx Master;
//    private MotorEx Slave;
//
//    public String NameMaster = "Master";
//    public String NameSlave = "Slave";
//
//    public static final int POSE_LOW = 0;
//    public static final int POSE_MIDDLE = 500;
//    public static final int POSE_HIGH = 1200;
//
//    public void init(HardwareMap hwMap) {
//        Master = new MotorEx(NameMaster);
//        Slave = new MotorEx(NameSlave);
//    }
//    public Command toHigh(){
//        return new RunToPosition(controller,POSE_HIGH);
//    }
//    public Command toMiddle(){
//        return new RunToPosition(controller,POSE_MIDDLE);
//    }
//    public Command toLow(){
//        return new RunToPosition(controller,POSE_LOW);
//    }
//
//    public Command toSetPoint(int setpoint) {
//        return new InstantCommand(()-> Master.atPosition(setpoint));
//    }
//
//    public void periodic() {
//        Slave.setPower(Master.getPower());
//    }
//
//}