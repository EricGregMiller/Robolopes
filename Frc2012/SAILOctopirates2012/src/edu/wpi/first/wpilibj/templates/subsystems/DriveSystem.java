/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.Gyro;
//import edu.wpi.first.wpilibj.Accelerometer;
import edu.wpi.first.wpilibj.ADXL345_I2C;

/**
 *
 * @author Wendy Chan
 */
public class DriveSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private RobotDrive drive;
    private Gyro gyro;
    //private Accelerometer accel;
    private ADXL345_I2C accel;

    double angle;
    double accread;

    private static DriveSystem instance = null;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoystick());
    }

    public DriveSystem(){
        gyro = new Gyro(RobotMap.gyrochan);
        //accel = new Accelerometer(RobotMap.accelchan);
        accel = new ADXL345_I2C (1, ADXL345_I2C.DataFormat_Range.k4G);
        drive = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.rearLeftMotor, RobotMap.frontRightMotor, RobotMap.rearRightMotor);
        drive.setSafetyEnabled(false);
    }

    public static DriveSystem getInstance() {
        if (instance == null)
            instance = new DriveSystem();
        return instance;
    }

    //public void driveWithJoy(double x, double y, double twist, double gyro){
    public void driveWithJoy(double y, double twist){
        //drive.mecanumDrive_Cartesian(x, y, twist, gyro);
        drive.arcadeDrive(y, twist);
        System.out.println("Drive Me");
    }

    public void zerogyro(){
        gyro.reset();
    }

    public void readgyro(){
        angle = gyro.getAngle();
        System.out.println("Gyro Angle = " + angle);
    }

    public void readaccel(){
        accread = accel.getAcceleration(ADXL345_I2C.Axes.kX);
        System.out.println("Acceleration (X axis)= " + accread);
        accread = accel.getAcceleration(ADXL345_I2C.Axes.kY);
        System.out.println("Acceleration (Y axis)= " + accread);
        accread = accel.getAcceleration(ADXL345_I2C.Axes.kZ);
        System.out.println("Acceleration (Z axis)= " + accread);
    }

}