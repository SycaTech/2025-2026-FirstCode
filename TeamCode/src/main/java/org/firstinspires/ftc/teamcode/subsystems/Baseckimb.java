package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;

public class Baseckimb {
    private DcMotorEx basemotor;

    double setpoint = 800;




    public int getTicks() {
        return basemotor.getCurrentPosition();
    }

    int ticks;
    public double setSetpoint() {
        return setpoint = ticks;
    }



    public Command settarget(){
       return new InstantCommand(() -> {
            basemotor.setTargetPosition(ticks);
        });
    };
    public Command setmode(){
        return new InstantCommand(() -> {
            new RunToPosition(basemotor, ticks, this);

        });
    };
    public Command power(){
       return new InstantCommand(() -> {
            basemotor.setPower(1.0);
        });
    };


















}
