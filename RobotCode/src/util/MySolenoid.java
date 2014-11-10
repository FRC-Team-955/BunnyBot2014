package util;

import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Programming
 */
public class MySolenoid {

    Solenoid noidOne;
    Solenoid noidTwo;

    /**
     * Constructor
     *
     * @param portOne
     * @param portTwo
     */
    public MySolenoid(int portOne, int portTwo) {
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
    public void set(boolean newState) {
        noidOne.set(newState);
        noidTwo.set(!newState);
    }

    public void switchNoids() {
        
    }

}
