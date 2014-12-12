package util;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * Wrapper class for Solenoid making two objects in this class
 * 
 * @author Programming
 */
public class MyNoid
{
    Solenoid noidOne;
    Solenoid noidTwo;

    /**
     * Constructor
     *
     * @param portOne
     * @param portTwo
     */
    public MyNoid(int portOne, int portTwo) 
    {
        noidOne = new Solenoid(portOne);
        noidTwo = new Solenoid(portTwo);
        noidOne.set(true);
        noidTwo.set(false);
    }

    /**
     * Sets solenoids to true or false
     *
     * @param newState
     */
    public void set(boolean newState) 
    {
        noidOne.set(newState);
        noidTwo.set(!newState);
    }
    
    /**
     * Gets solenoid value
     * 
     * @return solenoid value
     */
    public boolean get() 
    {
        return noidOne.get();
    }
}
