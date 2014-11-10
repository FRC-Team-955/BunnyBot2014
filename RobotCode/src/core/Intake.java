package core;
        
import util.Config;
import util.MyJoystick;
import util.MyTalon;

/**
 * Controls the intake moving parts.
 * @author Programming
 */
public class Intake
{
    MyTalon mtClaw = new MyTalon(Config.Intake.chnMtClaw);
    MyTalon mtArm = new MyTalon(Config.Intake.chnMtArm);
    MyJoystick joy;
    
    public Intake (MyJoystick newJoy) 
    {
        joy = newJoy;
    }
    
    /**
     * Run this to get input from the joystick buttons and use them to operate the intake.
     */
    public void run()
    {
        if (joy.getButton(Config.MyJoystick.chnIntakeOpen))
        {
            openClaw();
        }
        
        if (joy.getButton(Config.MyJoystick.chnIntakeClose))
        {
            closeClaw();
        }
        
        if (joy.getButton(Config.MyJoystick.chnIntakeUp)) 
        {
            openArm();
        }
        
        if (joy.getButton(Config.MyJoystick.chnIntakeDown)) 
        {
            closeArm();
        }
    }
    
    /**
     * Opens horizontal part of intake
     */
    public void openClaw ()
    {
        mtClaw.set(Config.Intake.mtClawSpeed);
    }
    
    /**
     * Closes horizontal part of intake
     */
    public void closeClaw ()
    {
        mtClaw.set(-Config.Intake.mtClawSpeed);
    }
    
    /**
     * Opens vertical part of intake
     */
    public void openArm ()
    {
        mtArm.set(Config.Intake.mtArmSpeed);
    }
    
    /**
     * Closes vertical part of intake
     */
    public void closeArm ()
    {
        mtArm.set(-Config.Intake.mtArmSpeed);
    }
    
}
