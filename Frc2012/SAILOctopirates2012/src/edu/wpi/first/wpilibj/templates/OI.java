package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.DriveToBalance;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;

//import commands
//import edu.wpi.first.wpilibj.templates.commands.ScoopOn;

public class OI {
    // Process operator interface input here.
    private Joystick leftstick = new Joystick(RobotMap.leftstick_port);
    private Joystick rightstick = new Joystick(RobotMap.rightstick_port);

    Button lftbtn7 = new JoystickButton(leftstick, 7),
           lftbtn8 = new JoystickButton(leftstick, 8);

    //boolean rtbtn7last = false;

    public OI(){
        lftbtn7.whenPressed(new DriveToBalance());
        lftbtn8.whenPressed(new DriveWithJoystick());
    }

    public Joystick getleftstick() {
        return leftstick;
    }

    public Joystick getrightstick() {
        return rightstick;
    }

    /**
     * @return The X value of the left (driving) joystick.
     */
    public double getleftstickX() {
        return leftstick.getX();
    }

    /**
     * @return The Y value of the left (driving) joystick.
     */
    public double getleftstickY() {
        return leftstick.getY();
    }

    /**
     * @return The twist value of the left (driving) joystick.
     */
    public double getleftstickTwist() {
        return leftstick.getTwist();
    }

}