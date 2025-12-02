//package org.firstinspires.ftc.teamcode.Teleops;
//
//import static dev.nextftc.bindings.Bindings.button;
//
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//import org.firstinspires.ftc.teamcode.subsystems.Intake;
//
//import dev.nextftc.bindings.Button;
//
//@TeleOp(name = "IntakeTeleop")
//public class IntakeTeleop extends OpMode {
//    Intake intake = Intake.INSTANCE;
//
//
//    @Override
//    public void init() {
//        intake.init(hardwareMap);
//    }
//
//    @Override
//    public void loop() {
//        Button A = button(() -> gamepad1.a);
//        A.whenBecomesTrue(() -> {
//            intake.intake();
//        });
//    }
//}
