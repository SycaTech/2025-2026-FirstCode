package org.firstinspires.ftc.teamcode.subsystems.Transfer;

import com.qualcomm.robotcore.hardware.ControlSystem;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;

public class Star_Indexer implements Subsystem {
    public static final Star_Indexer INSTANCE = new Star_Indexer();

    public final String rotateMotorName = "Star Motor";

    public DcMotor starMotor;

    public static final double BALL1 = 90;
    public static final double BALL2 = 180;
    public static final double BALL3 = 270;

    private Star_Indexer() {
        starMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        starMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        starMotor.setPower(0);
    }

    public ControlSystem controlSystem = ControlSystem.builder()
            .posPid()

}
