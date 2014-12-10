package util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * Class providing easy access to the driverstation screen and digital/analog
 * inputs
 * @author Merfoo
 */
public class Station 
{
    /**
     * Gets the button status from the driverstation, 1 - 8 available.
     * @param chn
     * @return 
     */
    public static boolean getDigitalIn(int chn)
    {
        return DriverStation.getInstance().getDigitalIn(chn);
    }
    
    /**
     * Gets the analog value from the driverstation, 1 - 8 available.
     * @param chn
     * @return 
     */
    public static double getAnalogIn(int chn)
    {
        return DriverStation.getInstance().getAnalogIn(chn);
    }

    /**
     * Prints specified message to the driver station on the corresponding line
     * 1-6 are available.
     * @param line
     * @param msg
     */
    public static void print(int line, String msg)
    {
        DriverStationLCD.Line printLine = null;
        
        switch(line)
        {
            case 1: printLine = DriverStationLCD.Line.kUser1; break;
            case 2: printLine = DriverStationLCD.Line.kUser2; break;
            case 3: printLine = DriverStationLCD.Line.kUser3; break;
            case 4: printLine = DriverStationLCD.Line.kUser4; break;
            case 5: printLine = DriverStationLCD.Line.kUser5; break;
            case 6: printLine = DriverStationLCD.Line.kUser6; break;
        }
        
        DriverStationLCD.getInstance().println(printLine, 1, msg);
        DriverStationLCD.getInstance().updateLCD(); 
    }
    
    /**
     * Clears all the text in the driver station
     */
    public static void clearAllText()
    {
        DriverStationLCD.getInstance().clear();
    }
}