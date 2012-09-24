package org.avhsd.robolopes2339.rr2012.noob;

import org.avhsd.robolopes2339.rr2012.noob.subsystems.BallCollectorSystem.BallCollectState;
import org.avhsd.robolopes2339.rr2012.noob.subsystems.BallShooterSystem.BallShootingState;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/*
 * Process operator input
 */
public class OI {
	private Joystick joystick = new Joystick(RobotMap.joystickPort);
	private Button shoot = new JoystickButton(joystick, 1), 
				   ballCollect = new JoystickButton(joystick, 3), 
				   ballEject = new JoystickButton(joystick, 6), 
				   rampLeverDown = new JoystickButton(joystick, 4), 
				   rampLeverUp = new JoystickButton(joystick, 5);
	
	public enum RampLever {
		Stop,
		MoveDown,
		MoveUp;
	}
	
	public Joystick getJoystick() {
		return joystick;
	}
	
	public boolean getShoot() {
		return shoot.get();
	}
	
	public BallCollectState getBallCollect() {
		if (ballCollect.get()) {
			return BallCollectState.Collect;
		} else if (ballEject.get()) {
			return BallCollectState.Eject;
		}
		return BallCollectState.Stop;
	}
	
	public BallShootingState getBallShoot() {
		if (shoot.get()) {
			return BallShootingState.Long;
		}
		return BallShootingState.Stop;
	}
	
	public RampLever getRampLever() {
		if (rampLeverDown.get()) {
			return RampLever.MoveDown;
		} else if (rampLeverUp.get()) {
			return RampLever.MoveUp;
		}
		return RampLever.Stop;
	}
}

