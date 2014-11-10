package util;

import edu.wpi.first.wpilibj.Talon;
//import java.lang.Math; // TODO: Don't need this import

/**
 *
 * @author Programming
 */

public class MyTalon extends Talon 
{
    public MyTalon(int channel) 
    {
        super(channel);
    }

    // TODO: Remove empty lines, make calls to base class functions explicitly
    //       known as in put super.functionName() ex super.get() instead of
    //       just get() because it not clear whether you're calling a function
    //       you made or the base class's function, add javadoc for this 
    //       function as well, this could also be a little simpler
    public void ramp(double required) 
    {
        if (Math.abs(super.get() - required) > Config.Drive.maxRampRate) 
        {

            if (required > get()) 
                set(super.get() + Config.Drive.maxRampRate);
            
            else 
                set(super.get() - Config.Drive.maxRampRate);
        } 
        
        else 
            set(required);
    }
}
