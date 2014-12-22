package core;

import util.MyTalon;
import util.Config;
import util.MyJoystick;
import util.Station;

/**
 * Uses joystick to set the talons, or provides commands for the autonomous 
 * code to turn and move. 
 * 
 * @author Programming
 */
public class Drive 
{
    private MyTalon mtRightOne = new MyTalon(Config.Drive.chnMtRightOne);
    private MyTalon mtRightTwo = new MyTalon(Config.Drive.chnMtRightTwo);
    private MyTalon mtRightThree = new MyTalon(Config.Drive.chnMtRightThree);
    private MyTalon mtLeftOne = new MyTalon(Config.Drive.chnMtLeftOne);
    private MyTalon mtLeftTwo = new MyTalon(Config.Drive.chnMtLeftTwo);
    private MyTalon mtLeftThree = new MyTalon(Config.Drive.chnMtLeftThree);
    private MyJoystick joy;
    private String statDrive = "No Crasherino Pls";
    
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
        
        x *= Config.Drive.turningScalar;
        setSpeed(-x + y, x + y, true);
        Station.print(Config.Station.lnDrive, statDrive);
    }

    /**
     * This function sets the left, and right speeds of the motors and ramps
     * to the speed is ramp = true
     * 
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
     * Stops the drive, no ramping
     */
    public void stop()
    {
        setSpeed(0, 0, false);
    }
    
    /**
     * Turns the robot to the right.
     * 
     * @param speed is the speed at which this is accomplished.
     * @param ramp is whether to ramp to the speed
     */
    public void turnRight (double speed, boolean ramp) 
    {
        setSpeed(speed, -speed, ramp);
    } 
    
    /**
     * Turns the robot to the left.
     * 
     * @param speed is the speed at which this is accomplished.
     * @param ramp is whether to ramp to the speed
     */
    public void turnLeft (double speed, boolean ramp) 
    {
        setSpeed( -speed, speed, ramp);
    } 
    
    /**
     * Moves the robot forward.
     * 
     * @param speed is the speed at which this is accomplished.
     * @param ramp is whether to ramp to the speed
     */
    public void moveForward (double speed, boolean ramp) 
    {
        setSpeed(-speed, -speed, ramp);
    } 
    
    /**
     * Moves the robot backward.
     * 
     * @param speed is the speed at which this is accomplished.
     * @param ramp is whether to ramp to the speed
     */
    public void moveBack (double speed, boolean ramp) 
    {
        setSpeed(speed, speed, ramp);
    } 
    
    /**
     * Sets the first motor on the left to the speed
     * 
     * @param speed is the speed at which this is accomplished.
     * @param ramp is whether to ramp to the speed
     */
    public void setMtLeftOne(double speed, boolean ramp)
    {
        if(ramp)
            mtLeftOne.ramp(speed);
        
        else
            mtLeftOne.set(speed);
    }
    
    /**
     * Sets the second motor on the left to the speed
     * 
     * @param speed is the speed at which this is accomplished.
     * @param ramp is whether to ramp to the speed
     */
    public void setMtLeftTwo(double speed, boolean ramp)
    {
        if(ramp)
            mtLeftTwo.ramp(speed);
        
        else
            mtLeftTwo.set(speed);
    }
    
    /**
     * Sets the third motor on the left to the speed
     * 
     * @param speed is the speed at which this is accomplished.
     * @param ramp is whether to ramp to the speed
     */
    public void setMtLeftThree(double speed, boolean ramp)
    {
        if(ramp)
            mtLeftThree.ramp(speed);
        
        else
            mtLeftThree.set(speed);
    }
    
    /**
     * Sets the first motor on the right to the speed
     * 
     * @param speed is the speed at which this is accomplished.
     * @param ramp is whether to ramp to the speed
     */
    public void setMtRightOne(double speed, boolean ramp)
    {
        if(ramp)
            mtRightOne.ramp(speed);
        
        else 
            mtRightOne.set(speed);
    }
    
    /**
     * Sets the second motor on the right to the speed
     * 
     * @param speed is the speed at which this is accomplished.
     * @param ramp is whether to ramp to the speed
     */
    public void setMtRightTwo(double speed, boolean ramp)
    {
        if(ramp)
            mtRightTwo.ramp(speed);
        
        else 
            mtRightTwo.set(speed);
    }
    
    /**
     * Sets the third motor on the right to the speed
     * 
     * @param speed is the speed at which this is accomplished.
     * @param ramp is whether to ramp to the speed
     */
    public void setMtRightThree(double speed, boolean ramp)
    {
        if(ramp)
            mtRightThree.ramp(speed);
        
        else 
            mtRightThree.set(speed);
    }
}