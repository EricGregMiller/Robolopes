package org.avhsd.robolopes2339.rr2012.noob.subsystems;

import org.avhsd.robolopes2339.rr2012.noob.RobotMap;

import org.avhsd.robolopes2339.rr2012.noob.commands.ShootBall;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Eric G. Miller
 */
public class BallShooterSystem extends Subsystem {
    /* Put methods for controlling this subsystem
     * here. Call these from Commands.
     */
    private Victor shootVictor1;
    private Victor shootVictor2;
    private static BallShooterSystem instance = null;
    private double longSpeed = 1.0;
    private double mediumSpeed = 0.75;
    private double shortSpeed = 0.5;
    private byte shootSyncGroup = (byte)0x40;

    public enum BallShootingState {
	    	Stop,
	    	Long,
	    	Medium, 
	    	Short, 
	    	Automatic;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ShootBall());
    }

    public BallShooterSystem(){
    	shootVictor1 = new Victor(RobotMap.shootMotor1);
    	shootVictor2 = new Victor(RobotMap.shootMotor1);
    	shootVictor1.setSafetyEnabled(false);
    	shootVictor2.setSafetyEnabled(false);
    }

    public static BallShooterSystem getInstance() {
        if (instance == null)
            instance = new BallShooterSystem();
        return instance;
    }

    /*
     * Move robot
     * 
     * @param ballCollect Set state of ball collector.
     * 
     */
    public void setShooter(BallShootingState ballShoot){
        System.out.println("BallShootingSystem setShooter");
        
        switch (ballShoot) {
        case Stop:
        	shootVictor1.set(0, shootSyncGroup);
        	shootVictor2.set(0, shootSyncGroup);
        	break;
        case Long:
        	shootVictor1.set(longSpeed, shootSyncGroup);
        	shootVictor2.set(longSpeed, shootSyncGroup);
        	break;
        case Medium:
        	shootVictor1.set(mediumSpeed, shootSyncGroup);
        	shootVictor2.set(mediumSpeed, shootSyncGroup);
        	break;
        case Short:
        	shootVictor1.set(shortSpeed, shootSyncGroup);
        	shootVictor2.set(shortSpeed, shootSyncGroup);
        	break;
        case Automatic:
        	shootVictor1.set(longSpeed, shootSyncGroup);
        	shootVictor2.set(longSpeed, shootSyncGroup);
        	break;
        }
    }

}