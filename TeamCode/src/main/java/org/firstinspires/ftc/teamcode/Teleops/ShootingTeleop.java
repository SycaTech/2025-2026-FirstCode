package org.firstinspires.ftc.teamcode.Teleops;

import static dev.nextftc.bindings.Bindings.button;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.Shooting.AngleChanger;
import org.firstinspires.ftc.teamcode.subsystems.Shooting.Shooter;

import dev.nextftc.bindings.Button;
import dev.nextftc.core.commands.CommandManager;

public class ShootingTeleop extends OpMode {
    AngleChanger angleChanger = new AngleChanger();
    Shooter shooter = new Shooter();

    @Override
    public void init() {
        angleChanger.init(hardwareMap);
        shooter.init(hardwareMap);
    }

    @Override
    public void loop() {
        Button ChangeAngel = button(() -> gamepad1.dpad_down);
        ChangeAngel.whenTrue(() -> angleChanger.changeAngle(-1));
        ChangeAngel.whenFalse(() -> angleChanger.changeAngle(1));

        CommandManager.INSTANCE.scheduleCommand(shooter.Shoot());
    }
}
