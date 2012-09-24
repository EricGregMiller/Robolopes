package org.avhsd.robolopes2339.rr2012.noob.subsystems;

import org.avhsd.robolopes2339.rr2012.noob.RobotMap;
import org.avhsd.robolopes2339.rr2012.noob.commands.CollectBalls;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Eric G. Miller
 */
public class BallCollectorSystem extends Subsystem {
    /* Put methods for controlling this subsystem
     * here. Call these from Commands.
     */
    private Victor victor;
    private static BallCollectorSystem instance = null;
    private double collectSpeed = 0.5;
    private double ejectSpeed = -0.5;

    public enum BallCollectState {
    	Stop,
    	Collect,
    	Eject;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new CollectBalls());
    }

    public BallCollectorSystem(){
        victor = new Victor(RobotMap.conveyorMotor);
        victor.setSafetyEnabled(false);
    }

    public static BallCollectorSystem getInstance() {
        if (instance == null)
            instance = new BallCollectorSystem();
        return instance;
    }

    /*
     * Move robot
     * 
     * @param ballCollect Set state of ball collector.
     * 
     */
    public void setBallCollector(BallCollectState ballCollect){
        System.out.println("BallCollectorSystem setBallCollector");
        switch (ballCollect) {
        case Stop:
        	victor.set(0);
        	break;
        case Collect:
        	victor.set(collectSpeed);
        	break;
        case Eject:
        	victor.set(ejectSpeed);
        	break;
        }
    }

}