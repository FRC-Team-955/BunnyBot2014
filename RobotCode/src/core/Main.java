package core;

import edu.wpi.first.wpilibj.IterativeRobot;
import util.MyJoystick;
import util.Config;
import auto.Auto;
import util.Station;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot
{
    private MyJoystick joy = new MyJoystick(Config.MyJoystick.chn);
    private Drive drive = new Drive(joy);
    private Intake intake = new Intake(joy);
    private Auto auto = new Auto(drive, intake);
    private String inspirationalMessage = "Good Luck, You da best :)";
    
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
     * This function is called once before autonomousPeriodic
     */
    public void autonomousInit()
    {
        auto.init();
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        auto.run();
    }
    
    /**
     * This function is called once before teleopPeriodic
     */
    public void teleopInit()
    {
        auto.end();
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        joy.update();
        drive.run();
        intake.run();
//        System.out.println(joy.getDpadRight() + " RIGHT ");
//        System.out.println(joy.getDpadUp()+ " UP ");
//        System.out.println(joy.getDpadDown()+ " DOWN ");
        Station.print(Config.Station.lnMain, inspirationalMessage);
    }
    
    /**
     * This function is called once before testPeriodic
     */
    public void testInit()
    {
        auto.init();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {
        auto.runTest();
    }
    
    /**
     * This function is called once when the robot gets disabled
     */
    public void disabledInit()
    {
        auto.end();
    }
}