package org.firstinspires.ftc.teamcode.subsystems.Transfer;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;

public class Star_Indexer{
    private DcMotor starMotor;

    public void init(HardwareMap hwMap) {
        starMotor = hwMap.get(DcMotor.class, "Star Indexer");
        starMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public static final int BALL1 = 90;
    public static final int BALL2 = 180;
    public static final int BALL3 = 270;

    public ControlSystem controlSystem = ControlSystem.builder()
            .posPid(0,0,0)
            .elevatorFF(0)
            .build();

    public Command Ball1(){
        return new InstantCommand(() ->{
           starMotor.setTargetPosition(BALL1);
        });
    }

    public Command Ball2(){
        return new InstantCommand(() ->{
            starMotor.setTargetPosition(BALL2);
        });
    }

    public Command Ball3(){
        return new InstantCommand(() ->{
            starMotor.setTargetPosition(BALL3);
        });
    }
}
