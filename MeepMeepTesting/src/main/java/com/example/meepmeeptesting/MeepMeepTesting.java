package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(600);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(0, -60, Math.PI/2))

                .setTangent(7*Math.PI/6)
                .splineToLinearHeading(new Pose2d(0, -50, 1.25), Math.PI*3/2
                        , new TranslationalVelConstraint(200),null )

                .setTangent(Math.PI/7)
                .splineToLinearHeading(new Pose2d(38, -60, Math.PI), 0
                        , new TranslationalVelConstraint(200),null )
                .splineToLinearHeading(new Pose2d(48, -60, Math.PI), 0
                        , new TranslationalVelConstraint(30.0),null )

                .setTangent(Math.PI)
                .splineToLinearHeading(new Pose2d(0, -50, 1.25), Math.PI
                        , new TranslationalVelConstraint(200),null )

                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}