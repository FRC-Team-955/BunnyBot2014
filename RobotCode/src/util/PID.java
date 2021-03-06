package util;

/**
 * PID controller
 * 
 * @author Merfoo
 */
public class PID
{
    private double kP = 0;
    private double kI = 0;
    private double kD = 0;
    private double totalErr = 0;
    private double prevErr = 0;
    private double output = 0;
    
    /**
     * Creates a pid controller with kP, kI, kD constants based on args
     * 
     * @param newP
     * @param newI
     * @param newD 
     */
    public PID(double newP, double newI, double newD)
    {
        kP = newP;
        kI = newI;
        kD = newD;
    }
    
    /**
     * Updates the pid loop output value
     * 
     * @param curr
     * @param want 
     */
    public void update(double curr, double want)
    {
        double errP = want - curr;      // err = diff in pos aka proportional
        totalErr += errP;               // integral of the err aka total err
        double errD = errP - prevErr;   // derivative of err aka change in err
        output = (errP * kP) + (totalErr * kI) + (errD * kD);
        prevErr = errP;
    }
    
    /**
     * Returns the output from the pid loop
     * 
     * @return 
     */
    public double getOutput()
    {
        return output;
    }
    
    /**
     * Sets the kP, kI, kD constants
     * 
     * @param newP
     * @param newI
     * @param newD 
     */
    public void setConsts(double newP, double newI, double newD)
    {
        kP = newP;
        kI = newI;
        kD = newD;
    }
    
    /**
     * Resets the pid loop by setting output, totalErr, prevErr to 0
     */
    public void reset()
    {
        output = 0;
        totalErr = 0;
        prevErr = 0;
    }
}