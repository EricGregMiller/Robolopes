/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.avhsd.robolopes._2012.sample.iterative;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class AnInterativeJavaBot extends IterativeRobot {
	
	private Joystick joystick = new Joystick(RobotMap.joystickPort);
	private Button shoot = new JoystickButton(joystick, 1), 
				   ballCollect = new JoystickButton(joystick, 3), 
				   ballEject = new JoystickButton(joystick, 6), 
				   rampLeverUp = new JoystickButton(joystick, 4), 
				   rampLeverDown = new JoystickButton(joystick, 4);
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    }
    
    

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	// Get joystick
    	
    	// Set drive motor speeds from axis info.
    	
    	// Set collector belt from buttons.
    	
    	// Set shooting speed from buttons.
        
    }
    
}
