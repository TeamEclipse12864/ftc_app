package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * Created by shrey on 2017-11-05.
 */

public class DriveMethods extends HardwarePushBot{

        public static void driveRight(double speed){
            rightFrontDrive.setPower(speed);
            rightBackDrive.setPower(speed);
        }

        public static void driveLeft(double speed){
            leftFrontDrive.setPower(speed);
            leftBackDrive.setPower(speed);
        }

    /*
     * This method is used to stop the drive motors in order for the robot to stop when in between
     * the two thresholds. It's important to do this so the robot will stop, safely
     */
        public static void stopRightMotors() { //always zero
            rightFrontDrive.setPower(0);
            rightBackDrive.setPower(0);
        }

        public static void stopLeftMotors(){
            leftFrontDrive.setPower(0);
            leftBackDrive.setPower(0);
        }

    /*
     * These set of methods control the Glyph Lift system and the glyph claws
     */

        // GlyphLift moving up and down
    public static void glyphLift(double speed){
        glyphLift.setPower(speed);
    }

        // Opening the GlyphLift claws to grab the glyph
    public static void openGlyph (){
        glyphLiftRight.setPosition(0.5);//0.55
        glyphLiftLeft.setPosition(0.4);//0.4
        glyphLiftRight2.setPosition(0.5);
        glyphLiftLeft2.setPosition(0.4);
    }

    //Closing the GlyphLift claws to gain posession og glyph
    public static void closeGlyph (){
        glyphLiftRight.setPosition(0.2);
        glyphLiftLeft.setPosition(0.6);
        glyphLiftRight2.setPosition(0.2);
        glyphLiftLeft2.setPosition(0.6);
    }

    }