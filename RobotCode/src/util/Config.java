package util;

/**
 *
 * @author Programming
 */
public class Config 
{
    public class MyJoystick
    {
        public static final int numberOfButtons = 12;
        public static final double  minDpadNumber = .5;
        
        // Buttons chns
        public static final int chnDpadHorz = 6;
        public static final int chnDpadVert = 5;
    }
    
    public class Drive
    {
        public static final double maxRampRate = .1;
    }
}