package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDriveSubsystem {

    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMototr;

    public MecanumDriveSubsystem(DcMotor frontLeftMotor, DcMotor frontRightMotor, DcMotor backLeftMotor
    , DcMotor backRightMototr){
        this.frontLeftMotor = frontLeftMotor;
        this.frontRightMotor = frontRightMotor;
        this.backLeftMotor = backLeftMotor;
        this.backRightMototr = backRightMototr;
    }

    public MecanumDriveSubsystem(HardwareMap hwMap) {
        frontLeftMotor = new DcMotor(hwMap, "LF");
        backLeftMotor = new DcMotor(hwMap, "LR");
        frontRightMotor = new DcMotor(hwMap, "RF");
        backRightMototr = new DcMotor(hwMap, "RR");



    }
