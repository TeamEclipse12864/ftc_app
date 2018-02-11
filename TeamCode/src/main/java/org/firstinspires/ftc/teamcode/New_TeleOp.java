package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by shrey on 2017-11-05.
 */

@TeleOp(name="TeleOp", group="group")

public class New_TeleOp extends LinearOpMode{

    // Declaring and defining the motors
    //Robot and Timer
    public static HardwarePushBot robot = new HardwarePushBot();
    public static ElapsedTime runTime = new ElapsedTime();

    public static Servo colorSensorArm = null;

    @Override
    public void runOpMode() throws InterruptedException {

        // Intialize the robot's hardware from HardwareMap amd allows you to run all this code within TeleOp
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.addData("Hello Driver", "Press Play Button");
        telemetry.update();



        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // Drive variables
            double rightPower = -gamepad1.right_stick_y * 0.8;
            double leftPower = -gamepad1.left_stick_y * 0.8;
            double reverse_Thres = -0.5;
            double forward_Thres = 0.5;
            // Glyph Lift system
            double liftPow = -gamepad2.left_stick_y;
            double up_Thres = 0.5;
            double down_Thres = -0.5;

            // Claw system
            double pullPow = -gamepad2.left_stick_y;
            double forwardMovement_Thres = 0.5;
            double backwardMovement_Thres = -0.5;
            double drive_Speed = 0.6;
            double turn_Speed = 0.4;

            //Color Sensor System

            // Send calculated power to wheels
            // Drive system
            if(rightPower < forward_Thres && rightPower > reverse_Thres && leftPower < forward_Thres && leftPower > reverse_Thres){
                DriveMethods.stopRightMotors();
                DriveMethods.stopLeftMotors();
            }else if(rightPower != 0.0 && leftPower != 0.0) {
                DriveMethods.driveRight(rightPower * drive_Speed);
                DriveMethods.driveLeft(leftPower * drive_Speed);
            }else if(rightPower != 0.0 && leftPower == 0.0){
                DriveMethods.driveRight(rightPower * drive_Speed);
            }else if(leftPower != 0.0 && rightPower == 0.0) {
                DriveMethods.driveLeft(leftPower * drive_Speed);
            }else if(rightPower < reverse_Thres && leftPower > forward_Thres){
                DriveMethods.driveLeft(leftPower * turn_Speed);
                DriveMethods.driveRight(rightPower * turn_Speed);
            }else if(rightPower > forward_Thres && leftPower < reverse_Thres){
                DriveMethods.driveLeft(leftPower * turn_Speed);
                DriveMethods.driveRight(rightPower * turn_Speed);
            }

            // GlyphLift sub-system
            // Lifting glyph
            if(liftPow < up_Thres && liftPow > down_Thres) {
                DriveMethods.glyphLift(0);

            }else if(liftPow > up_Thres){
                DriveMethods.glyphLift(-liftPow * -0.5);

            }else{
                DriveMethods.glyphLift(liftPow * 0.5);
            }

            // Grabbing glyph
            if(gamepad2.b) {
                DriveMethods.openGlyph();
            }
            if(gamepad2.a){
                DriveMethods.closeGlyph();
            }

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runTime.toString());
            telemetry.addData("Motors", "power (%.2f)");
            telemetry.update();
        }
    }
}