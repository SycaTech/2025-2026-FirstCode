package org.firstinspires.ftc.teamcode.Teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.LimeLight;

import dev.nextftc.core.components.SubsystemComponent;
import dev.nextftc.ftc.NextFTCOpMode;

@TeleOp(name = "LimeLightTeleop")
public class LimeLightTeleop extends NextFTCOpMode {

//    public LimeLightTeleop(){
//        addComponents(
//                new SubsystemComponent(LimeLight.INSTANCE)
//        );
//    }
    @Override
    public void onInit() {
        LimeLight.INSTANCE.initialize(hardwareMap, telemetry);
    }

    @Override
    public void onUpdate() {
        LimeLight.INSTANCE.periodic();
    }
}
