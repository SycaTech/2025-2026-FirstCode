package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;

import dev.nextftc.core.subsystems.Subsystem;

public class LimeLight implements Subsystem {
    public static final LimeLight INSTANCE = new LimeLight();
    Limelight3A limelight;
    Telemetry telemetry;

    // ⚡ Set your real values here
    private final double cameraHeight = 0; // meters
    private final double tagHeight = 0.0825;    // meters
    private final double cameraAngle = 0.0; // degrees

    public void initialize(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(100);
        limelight.start();
        limelight.pipelineSwitch(0);  // Must be AprilTag pipeline
    }

    @Override
    public void periodic() {
        LLResult result = limelight.getLatestResult();

        if (result == null || !result.isValid()) {
            telemetry.addData("Limelight", "No Targets");
            telemetry.update();
            return;
        }

        List<LLResultTypes.FiducialResult> fiducials = result.getFiducialResults();

        if (fiducials.isEmpty()) {
            telemetry.addData("Limelight", "No AprilTags");
            telemetry.update();
            return;
        }

        for (LLResultTypes.FiducialResult fiducial : fiducials) {
            int id = fiducial.getFiducialId();
            double ty = fiducial.getTargetYDegrees();

            // ✅ Distance calculation
            double distance = (tagHeight - cameraHeight) / Math.tan(Math.toRadians(ty + cameraAngle));

            telemetry.addData("Tag ID", id);
            telemetry.addData("Vertical Angle (ty)", ty);
            telemetry.addData("Distance (m)", String.format("%.2f", distance));
            telemetry.addLine("----------------------");
        }

        telemetry.update();
    }
}
