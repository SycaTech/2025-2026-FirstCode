//package org.firstinspires.ftc.teamcode;
//
//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
//
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//
//import dev.nextftc.core.components.BindingsComponent;
//import dev.nextftc.core.components.SubsystemComponent;
//import dev.nextftc.ftc.NextFTCOpMode;
//
//import static dev.nextftc.bindings.Bindings.*;
//
//
//@TeleOp(name = "LiftShoulder TeleOp", group = "nextftc")
//public class LiftShoulderTeleOp extends NextFTCOpMode {
//
//    public LiftShoulderTeleOp() {
//        addComponents(
//                new SubsystemComponent(LiftShoulder.INSTANCE),
//                BindingsComponent.INSTANCE,
//                BulkReadComponent.INSTANCE
//        );
//    }
//
//    @Override
//    public void onStartButtonPressed(){
//        button(() -> gamepad1.a)
//                .whenBecomesTrue(LiftShoulder.INSTANCE.toLow);
//        button(() -> gamepad1.b)
//                .whenBecomesTrue(LiftShoulder.INSTANCE.toMiddle);
//        button(() -> gamepad1.y)
//                .whenBecomesTrue(LiftShoulder.INSTANCE.toHigh);
//
//        button(() -> gamepad1.x)
//                .whenBecomesTrue(LiftShoulder.INSTANCE.toSetPoint(250));
//    }
//}