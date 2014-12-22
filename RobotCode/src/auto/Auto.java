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
        
        if(Station.getDigitalIn(Config.Station.chnAutoDoNothing))
            autoID = Config.Auto.idDoNothing;
        
        else if(Station.getDigitalIn(Config.Station.chnAutoDropBunny))
            autoID = Config.Auto.idDropBunny;
        
        else if(Station.getDigitalIn(Config.Station.chnAutoDropBunnyTimed))
            autoID = Config.Auto.idDropBunnyTimed;
    }
    
    /**
     * Ends auto
     */
    public void end()
    {
        stopEverything();
        step = 0;
        tmAuto.stop();
        tmAuto.reset();
    }
    
    /**
     * Goes to the next auto step by increasing autoStep and resetting auto time
     */
    private void nextStep()
    {
        step++;
        tmAuto.reset();
    }
    
    /**
     * Stops everything on the robot
     */
    private void stopEverything()
    {
        drive.stop();
        intake.armStop();
        intake.clawStop();
    }
    
    /**
     * Runs the auto routine
     */
    public void run()
    {
        switch(autoID)
        {
            case Config.Auto.idDropBunny:
            {
                dropBunnyInArm();
                break;
            }
        }
    }
    
    /**
     *  Drops bunny from inside the arm, pretty ghetto 
     */
    public void dropBunnyInArm()
    {
        switch(step)
        {
            case 0: // DRIVE TO WHITE ZONE
            {
                drive.moveForward(Config.Auto.driveForwardSpeed, true);
                    
                if(tmAuto.get() >= Config.Auto.driveForwardTime)
                {
                    drive.stop();
                    nextStep();
                }
                
                break;
            }
            
            case 1: // MOVE CLAW DOWN AND DRIVE BACK
            {
                intake.setArmPos(Config.Intake.posStation);
                drive.moveBack(Config.Auto.driveBackwardSpeed, true);
                
                if(tmAuto.get() >= Config.Auto.driveBackwardTime)
                {
                    intake.clawStop();
                    drive.stop();
                    nextStep();
                }
                
                break;
            }
                        
            default:
                stopEverything();
        }
    }
    
    /**
     * Drops the bunny with arm using pid and claw timed
     */
    public void dropBunny()
    {
        switch(step)
        {
            case 0: // CLOSE CLAW
            {
                intake.clawClose();
                
                if(tmAuto.get() >= Config.Auto.intakeCloseTime)
                {
                    intake.clawStop();
                    nextStep();
                }
                
                break;
            }
            
            case 1: // DRIVE TO WHITE ZONE
            {
                drive.moveForward(Config.Auto.driveForwardSpeed, true);
                    
                if(tmAuto.get() >= Config.Auto.driveForwardTime)
                {
                    drive.stop();
                    nextStep();
                }
                
                break;
            }
            
            case 2: // LOWER CLAW
            {
                intake.setArmPos(Config.Intake.posGround);
                    
                if(tmAuto.get() >= Config.Auto.intakeDownTime)
                {
                    intake.armStop();
                    nextStep();
                }
                
                break;
            }
            
            case 3: // OPEN CLAW
            {
                intake.clawOpen();
                
                if(tmAuto.get() >= Config.Auto.intakeOpenTime)
                {
                    intake.clawStop();
                    nextStep();
                }
                
                break;
            }
            
            case 4: // DRIVE BACK
            {
                drive.moveBack(Config.Auto.driveBackwardSpeed, true);
                    
                if(tmAuto.get() >= Config.Auto.driveBackwardTime)
                {
                    drive.stop();
                    nextStep();
                }
                
                break;
            }
                
            default:
                stopEverything();
        }
    }
    
    /**
     * Drops the bunny with arm using timer and claw timed
     */
    public void dropBunnyTimed()
    {
        switch(step)
        {
            case 0:
            {
                intake.clawClose();
                
                if(tmAuto.get() >= Config.Auto.intakeCloseTime)
                {
                    intake.clawStop();
                    nextStep();
                }
                
                break;
            }
            
            case 1:
            {
                drive.moveForward(Config.Auto.driveForwardSpeed, true);
                    
                if(tmAuto.get() >= Config.Auto.driveForwardTime)
                {
                    drive.stop();
                    nextStep();
                }
                
                break;
            }
            
            case 2:
            {
                intake.armDown();
                
                if(tmAuto.get() >= Config.Auto.intakeDownTime)
                {
                    intake.armStop();
                    nextStep();
                }
                
                break;
            }
            
            case 3:
            {
                intake.clawOpen();
                
                if(tmAuto.get() >= Config.Auto.intakeCloseTime)
                {
                    intake.clawStop();
                    nextStep();
                }
                
                break;
            }
                
            default:
                stopEverything();
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
                {
                    drive.setMtLeftOne(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Left 1";
                    break;
                }
                
                case 1:
                {
                    drive.setMtLeftOne(0, false);
                    drive.setMtLeftTwo(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Left 2";
                    break;
                }
                
                case 2:
                {
                    drive.setMtLeftTwo(0, false);
                    drive.setMtLeftThree(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Left 3";
                    break;
                }
                
                case 3:
                {
                    drive.setMtLeftThree(0, false);
                    drive.setMtRightOne(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Right 1";
                    break;
                }
                
                case 4:
                {
                    drive.setMtRightOne(0, false);
                    drive.setMtRightTwo(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Right 2";
                    break;
                }
                
                case 5:
                {
                    drive.setMtRightTwo(0, false);
                    drive.setMtRightThree(Config.Auto.testDriveSpeed, false);
                    statAuto = "Drive Motor Right 3";
                    break;
                }
                
                case 6:
                {
                    drive.setMtRightThree(0, false);
                    statAuto = "Ending...";
                    break;
                }
                
                default:
                {
                    tmAuto.stop();
                    statAuto = "Finished";
                }
            }
            
            nextStep();
        }
        
        Station.print(Config.Station.lnAuto, "Test: " + statAuto);
    }
}