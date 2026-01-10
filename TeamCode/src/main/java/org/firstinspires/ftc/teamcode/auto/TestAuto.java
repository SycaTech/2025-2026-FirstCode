package org.firstinspires.ftc.teamcode.auto;

import android.graphics.Point;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import  com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.Shooting.Shooter;
import org.opencv.video.TrackerGOTURN;

import java.lang.reflect.Method;

@Autonomous(name = "TEST",group = "test")
public class TestAuto extends OpMode {

        private Follower follower;
        private Timer pathTimer, actions, opmodeTimer;
        private int pathState;

        private Shooter shooter;


    private final Pose startPoint = new Pose(50, 100, Math.toRadians(120));
    private final Pose scorePoint = new Pose(30, 130, Math.toRadians(129));

    private final Pose Shooter = new Pose(55, 97, Math.toRadians(129));

    // Start Pose of our robot.





    public void buildPaths() {

        /* This is our scorePreload path. We are using a BezierLine, which is a straight line. */
        scorePreload = new Path(new BezierLine(startPoint, scorePoint));
        scorePreload.setLinearHeadingInterpolation(startPoint.getHeading(), scorePoint.getHeading());

    /* Here is an example for Constant Interpolation
    scorePreload.setConstantInterpolation(startPose.getHeading()); */

        /* This is our grabPickup1 PathChain. We are using a single path with a BezierLine, which is a straight line. */
        /* This is our scorePickup1 PathChain. We are using a single path with a BezierLine, which is a straight line. */
        scorePickup1 = follower.pathBuilder()
                .addPath(new BezierLine())
                .setLinearHeadingInterpolation(pickupballs1.getHeading(), scorePoint.getHeading())
                .lin
                .build();

        /* This is our grabPickup2 PathChain. We are using a single path with a BezierLine, which is a straight line. */
        grabPickup2 = follower.pathBuilder()
                .addPath(new BezierLine(scorePoint, pickupballs2))
                .setLinearHeadingInterpolation(scorePoint.getHeading(), pickupballs2.getHeading())
                .build();

        /* This is our scorePickup2 PathChain. We are using a single path with a BezierLine, which is a straight line. */
        scorePickup2 = follower.pathBuilder()
                .addPath(new BezierLine(pickupballs2, scorePoint))
                .setLinearHeadingInterpolation(pickupballs2.getHeading(), scorePoint.getHeading())
                .build();

        /* This is our grabPickup3 PathChain. We are using a single path with a BezierLine, which is a straight line. */
        grabPickup3 = follower.pathBuilder()
                .addPath(new BezierLine(scorePoint, pickupballs3))
                .setLinearHeadingInterpolation(scorePoint.getHeading(), pickupballs3.getHeading())
                .build();

        /* This is our scorePickup3 PathChain. We are using a single path with a BezierLine, which is a straight line. */
        scorePickup3 = follower.pathBuilder()
                .addPath(new BezierLine(pickupballs3, scorePoint))
                .setLinearHeadingInterpolation(pickupballs3.getHeading(), scorePoint.getHeading())
                .build();
    }
    private Path scorePreload;

    private PathChain grabPickup1, scorePickup1, grabPickup2, scorePickup2, grabPickup3, scorePickup3;



        @Override
        public void init() {

        }

        @Override
        public void loop() {

        }
    }







