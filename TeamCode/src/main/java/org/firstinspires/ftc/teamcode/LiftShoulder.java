//package org.firstinspires.ftc.teamcode;
//
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//
//import dev.nextftc.control.ControlSystem;
//import dev.nextftc.core.commands.Command;
//import dev.nextftc.core.subsystems.Subsystem;
//
//public class LiftShoulder implements Subsystem {
//
//    public static final LiftShoulder INSTANCE = new LiftShoulder();
//
//    public final String MOTOR_LEFT_NAME = "Master";
//    public final String MOTOR_RIGHT_NAME = "Slave";
//
//    public DcMotor motorLeft;
//    public DcMotor motorRight;
//
//    public static final double POSE_LOW = -200;
//    public static final double POSE_MIDDLE = 0;
//    public static final double POSE_HIGH = 500;
//
//
//    private LiftShoulder() {
//        motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//        motorRight.setPower(0);
//    }
//
//    public ControlSystem controlSystem = ControlSystem.builder()
//            .posPid(0.005, 0.0001, 0.0)
//            .elevatorFF(0.1)
//            .build();
//
//
//    public Command toLow = new RunToPosition(controlSystem, POSE_LOW);
//    public Command toMiddle = new RunToPosition(controlSystem, POSE_MIDDLE);
//    public Command toHigh = new RunToPosition(controlSystem, POSE_HIGH);
//
//    public Command toSetPoint(double setpoint) {
//        return new RunToPosition(controlSystem, setpoint);
//    }
//
//    @Override
//    public void periodic() {
//        motorRight.setPower(motorLeft.getPower());
//    }
//}