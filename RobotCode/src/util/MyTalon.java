package util;
import edu.wpi.first.wpilibj.Talon;
import java.lang.Math;

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
