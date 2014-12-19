package core;

import edu.wpi.first.wpilibj.Encoder;
import util.Config;
import util.MyJoystick;
import util.MyTalon;
import util.PID;
import util.Station;

/**
 * Controls the intake moving parts.
 *
 * @author Programming
 */
public class Intake 
{
    private Encoder encArm = new Encoder(Config.Intake.chnEncArmA, Config.Intake.chnEncArmB);
    private MyJoystick joy;
    private String statArm = "";            // Status of the arm
    private String statClaw = "";           // Status of the claw
    private boolean manualArmMode = true;
    private double posArm = 0.0;
    private PID pidArm = new PID(Config.Pid.Arm.kP, Config.Pid.Arm.kI, Config.Pid.Arm.kD);
    public MyTalon mtClaw = new MyTalon(Config.Intake.chnMtClaw);
    public MyTalon mtArm = new MyTalon(Config.Intake.chnMtArm);
    
    public Intake(MyJoystick newJoy) 
    {
        joy = newJoy;
        pidArm.reset();
        encArm.setDistancePerPulse(Config.Intake.armEncDistPerPulse);
        //encArm.reset();
        encArm.start();
    }

    /**
     * Run this to get input from the joystick buttons and use them to operate
     * the intake.
     */
    public void run()
    {
        // Change between manual/automatic mode
        if(joy.getButton(Config.MyJoystick.btArmManual) || Station.getDigitalIn(Config.Station.chnManualArmOnly))
            manualArmMode = true;
        
        else if(joy.getButton(Config.MyJoystick.btArmAutomatic))
            manualArmMode = false;
        
        // Reset stat messages
        statArm = "ARM: " + (manualArmMode ? "M " : "A ");
        statClaw = "CLAW: ";
        
        /*** INTAKE ARM ***/
        // Manual mode, not using pid and encoders
        if(manualArmMode)
        {
            // Get arm pos so if we switch to automatic it wont go cray cray
            posArm = getArmPos();
            armStop();
        
            if(joy.getRawButton(Config.MyJoystick.btArmUp)) 
            {
                statArm += "UP";
                armUp();
            }

            else if(joy.getRawButton(Config.MyJoystick.btArmDown))
            {
                statArm += "DOWN";
                armDown();
            }
            
            else
                statArm += "NOTHING";
        }
        
        // PID mode as in using pid and encoders
        else
        {            
            // Sets the arm pid constants from driver station for tuning
            //pidArm.setConsts(Station.getAnalogIn(1), Station.getAnalogIn(2), Station.getAnalogIn(3));
                        
            // Sets posArm to preset values depending on dpad            
            if(joy.getDpadUp())
            {
                statArm += "DROP OFF";
                posArm = Config.Intake.posDropOff;
            }
            
            if(joy.getDpadRight())
            {
                statArm += "STATIONARY";
                posArm = Config.Intake.posStation;
            }
            
            if(joy.getDpadDown())
            {
                statArm += "GROUND";
                posArm = Config.Intake.posGround;
            }
            
            if(joy.getDpadLeft())
            {
                statArm += "STARTING";
                posArm = Config.Intake.posStarting;
            }
            
            // Updates the pid and sets mtArm to it
            setArmPos(posArm);
        }
        
        System.out.println("PID: " + pidArm.getOutput() + " || ENC: " + getArmPos() + " || WANT: " + posArm);
        
        /*** INTAKE CLAW ***/
        clawStop();

        if(joy.getRawButton(Config.MyJoystick.btClawOpen))
        {
            statArm += "OPENING";
            clawOpen();
        }   

        else if(joy.getRawButton(Config.MyJoystick.btClawClose))
        {
            statArm += "CLOSING";
            clawClose();
        }
         
        else
            statArm += "NOTHING";
        
        // PRINTING TO DRIVERSTATION
        Station.print(Config.Station.lnIntakeEncs, "Arm: " + getArmPos());
        Station.print(Config.Station.lnIntakeArm, statArm);
        Station.print(Config.Station.lnIntakeClaw, statClaw);
    }

    /**
     * Sets the arm position
     * 
     * @param pos
     */
    public void setArmPos(double pos)
    {
        pidArm.update(getArmPos(), pos);
        mtArm.set(pidArm.getOutput());
    }
    
    /** 
     * Gets the arm rotation pos
     * 
     * @return arm pos
     */
    public double getArmPos()
    {
        return encArm.getRaw();
    }
    
    /**
     * Opens horizontal part of intake
     */
    public void clawOpen() 
    {
        mtClaw.set(Config.Intake.mtClawSpeed);
    }

    /**
     * Closes horizontal part of intake
     */
    public void clawClose()
    {
        mtClaw.set(-Config.Intake.mtClawSpeed);
    }
    
    /**
    * Stops claw motion
    */
    public void clawStop()
    {
        mtClaw.set(0);
    }

    /**
     * Opens vertical part of intake
     */
    public void armUp() 
    {
        mtArm.set(-Config.Intake.mtArmSpeed);
    }

    /**
     * Closes vertical part of intake
     */
    public void armDown()
    {
        mtArm.set(Config.Intake.mtArmSpeed);
    }
    
    /**
     * Stops arm motion
     */
    public void armStop()
    {
        mtArm.set(0);
    }
}