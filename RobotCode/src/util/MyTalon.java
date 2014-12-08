package util;

import edu.wpi.first.wpilibj.Talon;

/**
 * Control for talon / ramp utility
 * @author Programming
 */
public class MyTalon extends Talon 
{
    public MyTalon(int channel) 
    {
         super(channel);
    }
    
    /**
     * Ramps the motor to the desired speed.
     * @param required is the speed you want to ramp to
     */
    public void ramp(double required) 
    {
        if (Math.abs(super.get() - required) > Config.Drive.maxRampRate) 
        {
            if (required > get()) 
                super.set(super.get() + Config.Drive.maxRampRate);
            
            else 
                super.set(super.get() - Config.Drive.maxRampRate);
        } 
        
        else 
            super.set(required);
    }
}
