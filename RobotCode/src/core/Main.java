package core;

import edu.wpi.first.wpilibj.IterativeRobot;
import util.*;
import auto.Auto;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot
{
    MyJoystick joy = new MyJoystick(Config.MyJoystick.chn);
    Drive drive = new Drive(joy);
   // Auto auto = new Auto(drive);
    Intake intake = new Intake(joy);
    Test test = new Test(drive, intake);
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
        joy.setAxisChannel(MyJoystick.AxisType.kX, 3);
        joy.setAxisChannel(MyJoystick.AxisType.kY, 2);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
	//	auto.driveForward();
        test.run();
    
    }
    

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
    
        
        
        
        
        joy.update();
        drive.run();
        intake.run();
    }
}