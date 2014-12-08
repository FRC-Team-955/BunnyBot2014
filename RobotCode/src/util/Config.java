package util;

/**
 *
 * @author Programming
 */
public class Config {

    public class MyJoystick {

        public static final int numberOfButtons = 12;
        public static final double minDpadNumber = .5;
        public static final int chn = 1;

        // Buttons chns
        public static final int chnDpadHorz = 6;
        public static final int chnDpadVert = 5;
        public static final int btIntakeOpen = 4;
        public static final int btIntakeClose = 2;
        public static final int btIntakeUp = 7;
        public static final int btIntakeDown = 8;

    }

    public class Drive 
    {

        public static final double maxRampRate = .1;
        public static final int chnMtLeftOne = 2;
        public static final int chnMtLeftTwo = 3;
        public static final int chnMtLeftThree = 4;
        public static final int chnMtRightOne = 7;
        public static final int chnMtRightTwo = 8;
        public static final int chnMtRightThree = 9;
    }

    public class Intake {

        public static final double mtClawSpeed = 1;
        public static final double mtArmSpeed = 1;
        public static final int chnMtClaw = 6; //TODO CHANGE
        public static final int chnMtArm = 10;
    }

    public class Auto 
    {

        public static final int driveForwardTime = 10;
        public static final double driveForwardSpeed = 1;
    }
}