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
    private String statArm = "";    // Status of the arm
    private String statClaw = "";   // Status of the claw
    private boolean manualMode = true;
    private double posArm = 0.0;
    private double kP = 0.0;
    private double kI = 0.0;
    private double kD = 0.0;
    private PID pidArm = new PID(kP, kI, kD);
    
    public MyTalon mtClaw = new MyTalon(Config.Intake.chnMtClaw);
    public MyTalon mtArm = new MyTalon(Config.Intake.chnMtArm);

    public Intake(MyJoystick newJoy) 
    {
        joy = newJoy;
        encArm.setDistancePerPulse(Config.Intake.distPerPulse);
        encArm.reset();
        encArm.start();
    }

    /**
     * Run this to get input from the joystick buttons and use them to operate
     * the intake.
     */
    public void run()
    {
        // Reset stat messages
        statArm = "ARM: " + (manualMode ? "M " : "A ");
        statClaw = "CLAW: ";
        
        // Change between manual/automatic mode
        if(joy.getButton(Config.MyJoystick.btIntakeManual))
            manualMode = true;
        
        if(joy.getButton(Config.MyJoystick.btIntakeAutomatic))
            manualMode = false;
        
        /* INTAKE ARM */
        // Manual mode, not using pid and encoders
        if(manualMode)
        {
            posArm = encArm.getRaw() * -1;
            mtArm.set(0);
        
            if(joy.getRawButton(Config.MyJoystick.btIntakeUp)) 
            {
                statArm += "UP";
                System.out.println("Intake Up");
                armUp();
            }

            if(joy.getRawButton(Config.MyJoystick.btIntakeDown))
            {
                statArm += "DOWN";
                System.out.println("Intake Down");
                armDown();
            }
        }
        
        // PID mode as in using pid and encoders
        else
        {            
            // Sets the arm pid constants from driver station for tuning
            pidArm.setConsts(Station.getAnalogIn(1), Station.getAnalogIn(2), Station.getAnalogIn(3));
            System.out.println(Station.getAnalogIn(1));
            
            // We should reset the pid after changing constants
            if(joy.getButton(Config.MyJoystick.btResetArmPid))
                pidArm.reset();
                
            // Reset encoder 
            if(joy.getButton(Config.MyJoystick.btResetArmEnc))
                encArm.reset();
            
            // Moves the intake arm manually by preset const
//            if(joy.getRawButton(Config.MyJoystick.btIntakeUp)) 
//                posArm += Config.Intake.posInc;
//
//            if(joy.getRawButton(Config.MyJoystick.btIntakeDown))
//                posArm -= Config.Intake.posInc;
            
            // Sets posArm to preset values depending on dpad
            if(joy.getDpadRight())
                posArm = Config.Intake.posStation;
            
            if(joy.getDpadUp())
                posArm = Config.Intake.posDropOff;
            
            if(joy.getDpadDown())
                posArm = Config.Intake.posGround;
                
            // Limits the posArm min/max
//            if(posArm < Config.Intake.posMinArm)
//                posArm = Config.Intake.posMinArm;
//            
//            else if(posArm > Config.Intake.posMaxArm)
//                posArm = Config.Intake.posMaxArm;
            
            // Updates the pid and sets mtArm to it
            pidArm.update(encArm.getRaw() * -1, posArm);
            mtArm.set(pidArm.getOutput() * -1);
            
            // Status message
            statArm += posArm;
        }
        
        System.out.println("PID: " + pidArm.getOutput() + " || ENC: " + (encArm.getRaw() * -1)+ " || WANT: " + posArm);
        
        /* INTAKE CLAW */
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
        mtArm.set(-Config.Intake.mtArmSpeed);
    }

    /**
     * Closes vertical part of intake
     */
    public void armDown()
    {
        mtArm.set(Config.Intake.mtArmSpeed);
    }
}