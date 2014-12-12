package util;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Adjusts joystick value to accommodate the refresh time of the program
 * 
 * @author Seraj B
 */
public class MyJoystick extends Joystick 
{
    private boolean[] lastButtonState = new boolean[Config.MyJoystick.numberOfButtons];
    private boolean[] buttonState = new boolean[Config.MyJoystick.numberOfButtons];
    
    /**
     * Constructor
     * 
     * @param portNum port number for the joystick 
     */
    public MyJoystick(int portNum)
    {
        super(portNum);
        
        for(int i = 0; i < Config.MyJoystick.numberOfButtons; i++)
        {
            lastButtonState[i] = false;
            buttonState[i] = false;
        }
    }
    
    /**
     * Updates the button values for the joystick
     */
    public void update()
    {   
        for(int i = 0; i < Config.MyJoystick.numberOfButtons; i++)
        {
            buttonState[i] = !lastButtonState[i] && super.getRawButton(i + 1);
            lastButtonState[i] = super.getRawButton(i + 1);
        }
    }
    
    /**
     * Gives button value
     * 
     * @param button the button number on the joystick
     * @return button value
     */
    public boolean getButton(int button)
    {
        return buttonState[button - 1];
    }
    
    /**
     * Adjusts the dpad values from integers to booleans
     * 
     * @return adjusted dpad value
     */
    public boolean getDpadUp()
    {
        return super.getRawAxis(Config.MyJoystick.chnDpadVert) > Config.MyJoystick.minDpadNumber;           
    }
    
    /**
     * Adjusts the dpad values from integers to booleans
     * 
     * @return adjusted dpad value
     */
    public boolean getDpadDown()
    {
        return super.getRawAxis(Config.MyJoystick.chnDpadVert) < -Config.MyJoystick.minDpadNumber;            
    }
    
    /**
     * Adjusts the dpad values from integers to booleans
     * 
     * @return adjusted dpad value
     */
    public boolean getDpadRight()
    {
        return super.getRawAxis(Config.MyJoystick.chnDpadHorz) > Config.MyJoystick.minDpadNumber;            
    }
    
    /**
     * Adjusts the dpad values from integers to booleans
     * 
     * @return adjusted dpad value
     */
    public boolean getDpadLeft()
    {
        return super.getRawAxis(Config.MyJoystick.chnDpadHorz) < -Config.MyJoystick.minDpadNumber;
    }        
}