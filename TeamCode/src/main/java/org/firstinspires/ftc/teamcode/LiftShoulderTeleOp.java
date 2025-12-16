package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.core.components.SubsystemComponent;
import static dev.nextftc.bindings.Bindings.*;

import org.firstinspires.ftc.teamcode.subsystems.LiftShoulder;

@TeleOp 


    public LiftShoulderTeleOp() {
        clone(
                new SubsystemComponent(LiftShoulder.INSTANCE),
                BindingsComponent.INSTANCE,
                BulkReadComponent.INSTANCE
        );
    }

    @Override
    public void onStartButtonPressed(){
        button(() -> gamepad1.a)
                .whenBecomesTrue(LiftShoulder.INSTANCE.toLow());
        button(() -> gamepad1.b)
                .whenBecomesTrue(LiftShoulder.INSTANCE.toMiddle());
        button(() -> gamepad1.y)
                .whenBecomesTrue(LiftShoulder.INSTANCE.toHigh());

        button(() -> gamepad1.x)
                .whenBecomesTrue(LiftShoulder.INSTANCE.toSetPoint(250));
    }
}

/*package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.core.components.SubsystemComponent;
import static dev.nextftc.bindings.Bindings.*;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name = "LiftShoulder TeleOp", group = "nextftc")
public class LiftShoulderTeleOp extends NextFTCOpMode {

    public LiftShoulderTeleOp() {
        addComponents(
                new SubsystemComponent(LiftShoulder.INSTANCE),
                BindingsComponent.INSTANCE,
                BulkReadComponent.INSTANCE
        );
    }

    // אתחול החומרה מועבר ל-onInit, שם ה-hardwareMap זמין ופעיל
    @Override
    public void onInit() {
        LiftShoulder.INSTANCE.initHardware(hardwareMap);
    }

    @Override
    public void onStartButtonPressed(){
        // כאשר הכפתור נלחץ (whenBecomesTrue), הפקודה מתחילה לרוץ
        button(() -> gamepad1.a)
                .whenBecomesTrue(LiftShoulder.INSTANCE.toLow());
        button(() -> gamepad1.b)
                .whenBecomesTrue(LiftShoulder.INSTANCE.toMiddle());
        button(() -> gamepad1.y)
                .whenBecomesTrue(LiftShoulder.INSTANCE.toHigh());

        button(() -> gamepad1.x)
                .whenBecomesTrue(LiftShoulder.INSTANCE.toSetPoint(250));
    }
}*/