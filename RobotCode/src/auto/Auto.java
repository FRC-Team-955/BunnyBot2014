package auto;

import edu.wpi.first.wpilibj.Timer;
import core.Drive;
import core.Intake;
import util.Config;
import util.Station;

/**
 * Contains all the autonomous routines, including the test routine
 * 
 * @author Programming
 */
public class Auto 
{
    private Timer tmAuto = new Timer();
    private Drive drive;
    private Intake intake;
    private String statAuto = "";                   // Status of auto
    private int step = 0;                           // Step for step during auto
    private int autoID = Config.Auto.idDoNothing;   // ID for auto routine
    
    public Auto(Drive newDrive, Intake newIntake)
    {
       drive = newDrive;
       intake = newIntake;
    }
    
    /**
     * Initialized auto
     */
    public void init()
    {
        statAuto = "Beginning...";
        step = 0;
        tmAuto.reset();
        tmAuto.start();
        autoID = Config.Auto.idDoNothing;
        
        if(Station.getDigitalIn(Config.Station.chnModeForwardOnly))
            autoID = Config.Auto.idDropWidget;
    }
    
    /**
     * Ends auto
     */
    public void end()
    {
        drive.stop();
        step = 0;
        tmAuto.stop();
        tmAuto.reset();
    }
    
    /**
     * Runs the auto routine
     */
    public void run()
    {
        switch(autoID)
        {
            case Config.Auto.idDoNothing:
                break;
            case Config.Auto.driveForwardTime:
                dropWidgets();
                break;
        }
    }
    
    public void dropWidgets()
    {
        switch(step)
        {
            case 0:
            {
                if(tmAuto.get() <= Config.Auto.intakeCloseTime)
                    intake.clawClose();
                
                else
                {
                    intake.clawStop();
                    tmAuto.reset();
                    step++;
                }
                
                break;
            }
            
            case 1:
            {
                if(tmAuto.get() <= Config.Auto.driveForwardTime)
                {
                    drive.moveForward(Config.Auto.driveForwardSpeed, true);
                    intake.setArmPos(Config.Intake.posGround);
                }
                
                else
                {
                    drive.stop();
                    intake.armStop();
                    tmAuto.reset();
                    step++;
                }
                
                break;
            }
            
            case 2:
            {
                if(tmAuto.get() <= Config.Auto.intakeCloseTime)
                    intake.clawOpen();
                
                else
                {
                    intake.clawStop();
                    tmAuto.reset();
                    step++;
                }
                
                break;
            }
                  
        }
    }
    
    /**
     * Runs the test routine
     */
    public void runTest()
    {
        if(tmAuto.get() > Config.Auto.testDriveTime)
        {
            switch(step)
            {
                case 0:
                    drive.setMtLeftOne(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Left 1";
                    break;
                case 1:
                    drive.setMtLeftOne(0, false);
                    drive.setMtLeftTwo(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Left 2";
                    break;
                case 2:
                    drive.setMtLeftTwo(0, false);
                    drive.setMtLeftThree(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Left 3";
                    break;
                case 3:
                    drive.setMtLeftThree(0, false);
                    drive.setMtRightOne(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Right 1";
                    break;
                case 4:
                    drive.setMtRightOne(0, false);
                    drive.setMtRightTwo(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Right 2";
                    break;
                case 5:
                    drive.setMtRightTwo(0, false);
                    drive.setMtRightThree(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Right 3";
                    break;
                case 6:
                    drive.setMtRightThree(0, false);
                    statAuto = "Ending...";
                    break;
                default:
                    tmAuto.stop();
                    statAuto = "Finished";
            }
            
            step++;
            tmAuto.reset();
        }
        
        Station.print(Config.Station.lnAuto, "Test: " + statAuto);
    }
}