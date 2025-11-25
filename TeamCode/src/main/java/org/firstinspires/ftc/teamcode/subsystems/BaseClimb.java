package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.hardware.impl.MotorEx;

public class BaseClimb {
    private MotorEx telescope;

    public static final int ClosedPos = 0;
    public static final int OpenPos = 180;

    public void init(HardwareMap hwMap) {
        telescope = hwMap.get(MotorEx.class, "Telescope");
    }

    public ControlSystem controlSystem = ControlSystem.builder()
            .posPid(0,0,0)
            .elevatorFF(0)
            .build();

    public Command OpenTelescope() {
        return new InstantCommand(() -> {
            telescope.atPosition(OpenPos);
        });
    }

    public Command CloseTelescope() {
        return new InstantCommand(() -> {
            telescope.atPosition(ClosedPos);
        });
    }
}
