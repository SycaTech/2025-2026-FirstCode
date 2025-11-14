package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.groups.SequentialGroup;
import dev.nextftc.core.commands.utility.InstantCommand;

public class Baseclimb {
    private DcMotorEx basemotor;

    double setpoint = 800;

    public int getTicks() {
        return basemotor.getCurrentPosition();
    }

    int ticks;
    public void setSetpoint(int value) {
        ticks = value;
    }

    public Baseclimb(HardwareMap hardwareMap) {
        basemotor = hardwareMap.get(DcMotorEx.class, "basemotor");
    }

    public Command settarget(){
       return new InstantCommand(() -> {
            basemotor.setTargetPosition(ticks);
        });
    };
    public Command setmode(){
        return new InstantCommand(() -> {
            basemotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        });
    };

    public Command power(){
       return new InstantCommand(() -> {
            basemotor.setPower(1.0);
        });
    };

    public Command climb(){
        return new SequentialGroup(
                settarget(),
                setmode(),
                power()
        );
    }





















}
