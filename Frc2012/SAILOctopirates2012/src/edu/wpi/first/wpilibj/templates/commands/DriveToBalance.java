/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;


/**
 *
 * @author Wendy Chan
 */
public class DriveToBalance extends CommandBase {
    boolean gyroInit = true;

    public DriveToBalance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Not sure if this will be inside the loop... will gyroInit be reset back to true in the teleop loop??
        if (gyroInit == true){
            drive.zerogyro();
            gyroInit = false;
        }

        drive.readgyro();
        drive.readaccel();
        //drive.driveWithJoy(oi.getleftstickTwist(), oi.getleftstickY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}