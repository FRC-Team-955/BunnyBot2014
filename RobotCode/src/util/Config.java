package util;

/**
 *  Class that contains constants for the whole robot
 * 
 * @author Programming
 */
public class Config
{
    public static class MyJoystick 
    {
        // General constants for joystick
        public static final int numberOfButtons = 12;
        public static final int chn = 1;

        // Axes for DPAD AXES MAY CHANGE WITH DIFFERENT LAPTOPS
        public static final int chnDpadHorz = 5;    
        public static final int chnDpadVert = 6;    
        public static final double minDpadNumber = .5;
        
        // Button chn for joystick BUTTON CHN MAY CHANGE WITH DIFFERENT LAPTOPS
        public static final int btClawOpen = 4;
        public static final int btClawClose = 2;
        public static final int btArmUp = 7;
        public static final int btArmDown = 8;
        public static final int btArmManual = 9;     
        public static final int btArmAutomatic = 10; 
    }

    public static class Drive 
    {
        // Max ramp
        public static final double maxRampRate = .1;
        
        // Chn for drive talons
        public static final int chnMtLeftOne = 2;
        public static final int chnMtLeftTwo = 3;
        public static final int chnMtLeftThree = 4;
        public static final int chnMtRightOne = 7;
        public static final int chnMtRightTwo = 8;
        public static final int chnMtRightThree = 9;
    }

    public static class Intake 
    {
        // Speed for arm/claw in manual mode
        public static final double mtClawSpeed = 1;
        public static final double mtArmSpeed = 1;
        
        // Chn for intake talons
        public static final int chnMtClaw = 6;
        public static final int chnMtArm = 10;
        
        // Intake arm encoder
        public static final double armEncDistPerPulse = 256 / 360;
        public static final int chnEncArmA = 11; 
        public static final int chnEncArmB = 6;
        
        // Constants for arm pos/movement
        public static final double posGround = 588;     // Down about to pick stuff
        public static final double posStation = 224;    // Up doing nothing
        public static final double posDropOff = 90;     // Drop widgets into pan
        public static final double posStarting = 0;     // Starting position 
    }

    public static class Auto 
    {
        // IDs for auto routines
        public static final int idDoNothing = 1;
        public static final int idDropWidget = 2;
        
        // Times/Speeds for auto routines
        public static final int driveForwardTime = 7;
        public static final double driveForwardSpeed = 1;
        public static final double intakeCloseTime = 1.5;
        
        // Times/Speeds for test routine
        public static final double testDriveTime = 1;
        public static final double testDriveSpeed = 0.5;
        
    }
    
    public static class Station
    {
        // Lines for printing on driverstation 1-6 only
        public static final int lnMain = 1;
        public static final int lnDrive = 2;
        public static final int lnIntakeEncs = 3;
        public static final int lnIntakeArm = 4;
        public static final int lnIntakeClaw = 5;
        public static final int lnAuto = 6;
        
        // Digital Input Channels for Autonomous 1-8 only
        public static final int chnModeDoNothing = 1;
        public static final int chnModeForwardOnly = 2;
        public static final int chnManualArmOnly = 8;
    }
    
    // Pid consts for various systems on the robot
    public static class Pid
    {
        public static class Arm
        {
            public static double kP = 0.01;
            public static double kI = 0.0;
            public static double kD = 0.0;
        }
    }
}