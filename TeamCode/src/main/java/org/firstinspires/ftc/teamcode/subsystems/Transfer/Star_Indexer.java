package org.firstinspires.ftc.teamcode.subsystems.Transfer;

import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.hardware.impl.MotorEx;

public class Star_Indexer{
    private MotorEx starMotor;

    public static final int BALL1Pos = 90;
    public static final int BALL2Pos = 180;
    public static final int BALL3Pos = 270;

    public void init(HardwareMap hwMap) {
        starMotor = hwMap.get(MotorEx.class, "Star Indexer");
    }

    public ControlSystem controlSystem = ControlSystem.builder()
            .posPid(0,0,0)
            .elevatorFF(0)
            .build();

    public Command Ball1(){
        return new InstantCommand(() ->{
           starMotor.atPosition(BALL1Pos);
        });
    }

    public Command Ball2(){
        return new InstantCommand(() ->{
            starMotor.atPosition(BALL2Pos);
        });
    }

    public Command Ball3(){
        return new InstantCommand(() ->{
            starMotor.atPosition(BALL3Pos);
        });
    }
}
