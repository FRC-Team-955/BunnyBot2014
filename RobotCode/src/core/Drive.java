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
        double x = Math.abs(joy.getX()) * joy.getX();
        double y = Math.abs(joy.getY()) * joy.getY();
        
        setSpeed(-x + y, x + y, true);
    }

    /**
     * This function sets the left, and right speeds of the motors and ramps
     * to the speed is ramp = true
     * @param leftSpeed is the speed of the motors on the left side
     * @param rightSpeed is the speed of the motors on the right side
     * @param ramp is whether is should ramp or not
     */
    public void setSpeed(double leftSpeed, double rightSpeed, boolean ramp) 
    {
        rightSpeed = -rightSpeed;
        
	if(ramp)
        {
            mtRightOne.ramp(rightSpeed);
            mtRightTwo.ramp(rightSpeed);
            mtRightThree.ramp(rightSpeed);
            mtLeftOne.ramp(leftSpeed);
            mtLeftTwo.ramp(leftSpeed);
            mtLeftThree.ramp(leftSpeed);
        }
        
        else
        {
            mtRightOne.set(rightSpeed);
            mtRightTwo.set(rightSpeed);
            mtRightThree.set(rightSpeed);
            mtLeftOne.set(leftSpeed);
            mtLeftTwo.set(leftSpeed);
            mtLeftThree.set(leftSpeed);
        }
    }
    
    /**
     * Turns the robot to the right.
     * @param speed is the speed at which this is accomplished.
     */
    public void turnRight (double speed) 
    {
        setSpeed(speed, -speed, true);
    } 
    
    /**
     * Turns the robot to the left.
     * @param speed is the speed at which this is accomplished.
     */
    public void turnLeft (double speed) 
    {
        setSpeed( -speed, speed, true);
    } 
    
    /**
     * Moves the robot forward.
     * @param speed is the speed at which this is accomplished.
     */
    public void moveForward (double speed) 
    {
        setSpeed(speed, speed, true);
    } 
    
    /**
     * Moves the robot backward.
     * @param speed is the speed at which this is accomplished.
     */
    public void moveBack (double speed) 
    {
        setSpeed( -speed, -speed, true);
    } 
}