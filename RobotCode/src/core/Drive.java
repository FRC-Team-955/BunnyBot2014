package core;

import util.MyTalon;
import util.Config;
import util.MyJoystick;

/**
 * Uses joystick to set the talons, or uses commands from the autonomous code to turn and move. 
 * @author Programming
 */
public class Drive 
{
    MyTalon mtRightOne = new MyTalon(Config.Drive.chnMtRightOne);
    MyTalon mtRightTwo = new MyTalon(Config.Drive.chnMtRightTwo);
    MyTalon mtRightThree = new MyTalon(Config.Drive.chnMtRightThree);
    MyTalon mtLeftOne = new MyTalon(Config.Drive.chnMtLeftOne);
    MyTalon mtLeftTwo = new MyTalon(Config.Drive.chnMtLeftTwo);
    MyTalon mtLeftThree = new MyTalon(Config.Drive.chnMtLeftThree);
    MyJoystick joy;
    
    public Drive (MyJoystick newJoy) 
    {
        joy = newJoy;
    }
    
    /**
     * When this is run, it uses joystick input to maneuver the robot.
     */
    public void run() 
    {
        setDrive((-joy.getX()) + joy.getY(), joy.getX() + joy.getY());
    }

    /**
     * This function sets the left, and right speeds of the motors.
     * @param left is the speed of the motors on the left side
     * @param right is the speed of the motors on the right side
     */
    public void setDrive(double left, double right) 
    {
		
        mtRightOne.ramp(-right);
        mtRightTwo.ramp(-right);
        mtRightThree.ramp(-right);

        mtLeftOne.ramp(left);
        mtLeftTwo.ramp(left);
        mtLeftThree.ramp(left);
    }
    
    /**
     * Turns the robot to the right.
     * @param speed is the speed at which this is accomplished.
     */
    public void turnRight (double speed) 
    {
        setDrive(speed, -speed);
    } 
    
    /**
     * Turns the robot to the left.
     * @param speed is the speed at which this is accomplished.
     */
    public void turnLeft (double speed) 
    {
        setDrive( -speed, speed);
    } 
    
    /**
     * Moves the robot forward.
     * @param speed is the speed at which this is accomplished.
     */
    public void moveForward (double speed) 
    {
        setDrive(-speed,-speed);
    } 
    
    /**
     * Moves the robot backward.
     * @param speed is the speed at which this is accomplished.
     */
    public void moveBack (double speed) 
    {
        setDrive( -speed, -speed);
    } 
}