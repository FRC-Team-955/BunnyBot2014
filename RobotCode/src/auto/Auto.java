package auto;

import core.Drive;
import core.Intake;
import edu.wpi.first.wpilibj.Timer;
import util.Config;
/**
 *
 * @author Programming
 */
public class Auto 
{
    private Timer driveTime = new Timer();
    private Drive drive;
	boolean timerStarted = false;
    //private Intake intake;
    
    public Auto(/*Intake newIntake,*/ Drive newDrive)
    {
       drive = newDrive;
       //intake = newIntake;
    }
    
    public void driveForward() 
    {
		if(!timerStarted) {
			driveTime.start();
			timerStarted = true;
		}
        
        if(driveTime.get() <= Config.Auto.driveForwardTime)
        {
            drive.moveForward(Config.Auto.driveForwardSpeed);
        }	
		else {
            drive.moveForward(0);
			driveTime.stop();
		}	
		System.out.println(driveTime.get());
       //intake.openClaw();
    }
}