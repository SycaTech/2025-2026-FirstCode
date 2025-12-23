package org.firstinspires.ftc.teamcode.Teleops;

import static dev.nextftc.bindings.Bindings.button;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift.Lift;

import dev.nextftc.bindings.Button;
import dev.nextftc.bindings.BindingsComponent;
import dev.nextftc.core.components.SubsystemComponent;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.ftc.components.BulkReadComponent;


public class LiftTeleop extends NextFTCOpMode {

    public LiftTeleop() {
        addComponents(
                new SubsystemComponent(Lift.INSTANCE),
                BindingsComponent.INSTANCE,
                BulkReadComponent.INSTANCE
        );
    }
    @Override
    public void onInit() {
        Lift.INSTANCE.Init();
    }

    @Override
    public void onUpdate() {
        Button A = button(() -> gamepad1.a);
    }
}