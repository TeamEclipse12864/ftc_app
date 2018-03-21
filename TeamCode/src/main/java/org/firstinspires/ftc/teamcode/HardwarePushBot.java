package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * Created by shrey on 2017-09-26.
 *
 *
 * This class defines all the different hardware pieces in a single robot:
 *
 * rightFrontDrive = front right motor
 * leftFrontDrive = front left motor
 * rightBackDrive = back right motor
 * leftBackDrive = back left motor
 *
 */

public class HardwarePushBot{

    public static DcMotor rightFrontDrive = null;
    public static DcMotor leftFrontDrive = null;
    public static DcMotor rightBackDrive = null;
    public static DcMotor leftBackDrive = null;

    //glyphlift subsystem
    public static DcMotor glyphLift = null;
    public static Servo glyphLiftRight = null;
    public static Servo glyphLiftLeft = null;
    public static Servo glyphLiftRight2 = null;
    public static Servo glyphLiftLeft2 = null;

    //Claw subsystem
    //public static Servo grabRelic = null;
    //public static DcMotor relicPosition = null;

    public static ColorSensor colorSense = null;
    public static Servo colorSensorArm = null;
    public static Servo colorSensorArmRotate = null;

    /* local OpMode members. */
    public HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwarePushBot(){
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        // Define and Initialize Motors
        rightFrontDrive = hwMap.dcMotor.get("rfd"); //0
        leftFrontDrive = hwMap.dcMotor.get("lfd");  //1
        rightBackDrive = hwMap.dcMotor.get("rbd");  //2
        leftBackDrive = hwMap.dcMotor.get("lbd");   //3

        //glyphlift subsystem
        glyphLift = hwMap.dcMotor.get("gl");        //1
        glyphLiftRight = hwMap.servo.get("glr");    //2
        glyphLiftLeft = hwMap.servo.get("gll");     //3
        glyphLiftRight2 = hwMap.servo.get("glr2");  //4
        glyphLiftLeft2 = hwMap.servo.get("gll2");   //5


        //Claw subsytem
        //grabRelic = hwMap.servo.get("gr");          //3
        //relicPosition = hwMap.dcMotor.get("rp");    //2

        //Color Sensor
        colorSense = hwMap.colorSensor.get("cs");     //12 Bus3
        colorSensorArm = hwMap.servo.get("csa");      //4
        colorSensorArmRotate = hwMap.servo.get("csa1");

        // Set all motors to zero power
        rightFrontDrive.setPower(0);
        leftFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
        leftBackDrive.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);

        //relicPosition.setDirection(DcMotor.Direction.FORWARD);
    }

}