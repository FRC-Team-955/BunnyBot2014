package util;

/**
 *  Class that contains constants for the whole robot
 * 
 * @author Programming
 */
public class Config
{
    public class MyJoystick 
    {
        // General constants for joystick
        public static final int numberOfButtons = 12;
        public static final int chn = 1;

        // Axes for DPAD
        public static final int chnDpadHorz = 5;    // AXES MIGHT CHANGE LAPTOP TO TOP
        public static final int chnDpadVert = 6;    // THIS TOO!!!
        public static final double minDpadNumber = .5;
        
        // Button chn for joystick
        public static final int btIntakeOpen = 4;
        public static final int btIntakeClose = 2;
        public static final int btIntakeUp = 7;
        public static final int btIntakeDown = 8;
        public static final int btIntakeManual = 9;     // TODO SET THIS
        public static final int btIntakeAutomatic = 10; // TODO SET THIS
        public static final int btResetArmPid = 11;     // TODO SET THIS
        public static final int btResetArmEnc = 12;     // TODO SET THIS
    }

    public class Drive 
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

    public class Intake 
    {
        // Speed for arm/claw in manual mode
        public static final double mtClawSpeed = 1;
        public static final double mtArmSpeed = 1;
        
        // Chn for intake talons
        public static final int chnMtClaw = 6;
        public static final int chnMtArm = 10;
        
        // Chn for intake arm encoder
        public static final double distPerPulse = 256 / 360;
        public static final int chnEncArmA = 11; // TODO SET CORRECT CHNS
        public static final int chnEncArmB = 6;
        
        // Constants for arm pos/movement
        public static final double posGround = -588;   // Down about to pick stuff
        public static final double posStation = -224;  // Up doing nothing
        public static final double posDropOff = -90;  // Drop widgets into pan
        public static final double posInc = 10;      // Amount to increase arm
        public static final double posMinArm = posGround;
        public static final double posMaxArm = posDropOff;
    }

    public class Auto 
    {
        // IDs for auto routines
        public static final int idDoNothing = 0;
        public static final int idForwardOnly = 1;
        
        // Times/Speeds for auto routines
        public static final int driveForwardTime = 7;
        public static final double driveForwardSpeed = 1;
        public static final double intakeLowerTime = 1.5;
        public static final double intakeCloseTime = .5;
        
        // Times/Speeds for test routine
        public static final double testDriveTime = 1;
        public static final double testDriveSpeed = 0.5;
        
    }
    
    public class Station
    {
        // Lines for printing on driverstation 1-6 only
        public static final int lnMain = 1;
        public static final int lnDrive = 2;
        public static final int lnIntakeArm = 4;
        public static final int lnIntakeClaw = 5;
        public static final int lnAuto = 6;
        
        // Digital Input Channels for Autonomous
        public static final int chnModeDoNothing = 0;
        public static final int chnModeForwardOnly = 1;
    }
}