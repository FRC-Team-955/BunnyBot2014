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
        if (joy.getButton(Config.MyJoystick.btIntakeOpen))
            openClaw();
        
        if (joy.getButton(Config.MyJoystick.btIntakeClose))
            closeClaw();
        
        if (joy.getButton(Config.MyJoystick.btIntakeUp)) 
            armUp();
        
        if (joy.getButton(Config.MyJoystick.btIntakeDown)) 
            armDown();
    }
    
    /**
     * Opens horizontal part of intake
     */
    public void openClaw()
    {
        mtClaw.set(Config.Intake.mtClawSpeed);
    }
    
    /**
     * Closes horizontal part of intake
     */
    public void closeClaw()
    {
        mtClaw.set(-Config.Intake.mtClawSpeed);
    }
    
    /**
     * Opens vertical part of intake
     */
    public void armUp()
    {
        mtArm.set(Config.Intake.mtArmSpeed);
    }
    
    /**
     * Closes vertical part of intake
     */
    public void armDown()
    {
        mtArm.set(-Config.Intake.mtArmSpeed);
    }
    
}
