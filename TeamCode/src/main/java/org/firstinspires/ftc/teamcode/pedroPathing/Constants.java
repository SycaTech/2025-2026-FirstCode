package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.DriveEncoderConstants;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Timer;

public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(5);
    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .rightFrontMotorName("RF")
            .rightRearMotorName("RR")
            .leftRearMotorName("LR")
            .leftFrontMotorName("LF")
            .leftFrontMotorDirection(DcMotor.Direction.REVERSE)
            .leftRearMotorDirection(DcMotor.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotor.Direction.FORWARD)
            .rightRearMotorDirection(DcMotor.Direction.FORWARD)
            .xVelocity(97)
            .yVelocity(55);

    public static DriveEncoderConstants localizerConstants = new DriveEncoderConstants()
            .leftFrontEncoderDirection(Encoder.FORWARD)
            .leftRearEncoderDirection(Encoder.FORWARD)
            .rightFrontEncoderDirection(Encoder.FORWARD)
            .rightRearEncoderDirection(Encoder.FORWARD)
            .robotWidth(16.5)
            .robotLength(16.5)
            .forwardTicksToInches(55.55)
            .strafeTicksToInches(44.430)
            .turnTicksToInches(22.54);


    public static PathConstraints pathConstraints = new PathConstraints(
            0.99,
            0.1,
            0.1,
            0.009,
            100,
            1,
            10,
            1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .mecanumDrivetrain(driveConstants)
                .driveEncoderLocalizer(localizerConstants)
                .pathConstraints(pathConstraints)
                .build();
    }
    @Autonomous(name = "test" , group = "test")
    public class Constans extends OpMode {

        private Follower follower;

        private Timer pathTimer, actions, opmodeTimer;
        private int pathState;

        private final Pose startPose = new Pose(9, 72, Math.toRadians(0));
        private final Pose firstSpec = new Pose(35, 72, Math.toRadians(0));
        private final Pose firstPushSet = new Pose(62, 24, Math.toRadians(360));
        private final Pose firstPush = new Pose(62, 24, Math.toRadians(360));
        private final Pose endPose = new Pose( 0 , 0 , Math.toRadians(0));


        @Override
        public void init() {

        }

        @Override
        public void loop() {

        }
    }

}