package core;

import util.Config;
import util.MyJoystick;
import util.MyTalon;
import util.Station;

/**
 * Controls the intake moving parts.
 *
 * @author Programming
 */
public class Intake 
{
    private MyTalon mtClaw = new MyTalon(Config.Intake.chnMtClaw);
    private MyTalon mtArm = new MyTalon(Config.Intake.chnMtArm);
    private MyJoystick joy;
    private String statArm = "";    // Status of the arm
    private String statClaw = "";   // Status of the claw

    public Intake(MyJoystick newJoy) 
    {
        joy = newJoy;
    }

    /**
     * Run this to get input from the joystick buttons and use them to operate
     * the intake.
     */
    public void run()
    {
        statArm = "ARM: ";
        statClaw = "CLAW: ";
        
        // INTAKE ARM
        mtArm.set(0);
        
        if (joy.getRawButton(Config.MyJoystick.btIntakeUp)) 
        {
            statArm += "UP";
            System.out.println("Intake Up");
            armUp();
        }

        if (joy.getRawButton(Config.MyJoystick.btIntakeDown))
        {
            statArm += "DOWN";
            System.out.println("Intake Down");
            armDown();
        }
        
        // INTAKE CLAW
        mtClaw.set(0);
        
        if (joy.getRawButton(Config.MyJoystick.btIntakeOpen))
        {
            statClaw += "CLOSING";
            System.out.println("Intake Claw Closing");
            openClaw();   
        }
        
        if (joy.getRawButton(Config.MyJoystick.btIntakeClose))
        {
            statClaw += "OPENING";
            System.out.println("Intake Claw Opening");
            closeClaw();
        }
        
        // PRINTING TO DRIVERSTATION
        Station.print(Config.Station.lnIntakeArm, statArm);
        Station.print(Config.Station.lnIntakeClaw, statClaw);
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