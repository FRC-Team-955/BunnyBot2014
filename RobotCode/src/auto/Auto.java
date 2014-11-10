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
    private Intake intake;
    
    public Auto(Intake newIntake, Drive newDrive)
    {
       drive = newDrive;
       intake = newIntake;
    }
    
    public void driveForward() 
    {
        driveTime.start();
        if(driveTime.get() <= Config.Auto.driveForwardTime)
        {
            drive.moveForward(Config.Auto.driveForwardSpeed);
        }
        else
            drive.moveForward(0);
        intake.openClaw();
    }
}