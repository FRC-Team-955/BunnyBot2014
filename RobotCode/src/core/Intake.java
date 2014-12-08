package core;

import util.Config;
import util.MyJoystick;
import util.MyTalon;

/**
 * Controls the intake moving parts.
 *
 * @author Programming
 */
public class Intake {

    MyTalon mtClaw = new MyTalon(Config.Intake.chnMtClaw);
    MyTalon mtArm = new MyTalon(Config.Intake.chnMtArm);
    MyJoystick joy;

    public Intake(MyJoystick newJoy) {
        joy = newJoy;
    }

    /**
     * Run this to get input from the joystick buttons and use them to operate
     * the intake.
     */
    public void run() {
        
        // TODO SET TO 0 FOR CLAW
        // mtClaw.set(0) VERY IMPORTANT!!!
//        if (joy.getButton(Config.MyJoystick.btIntakeOpen))
//            openClaw();   
//        if (joy.getButton(Config.MyJoystick.btIntakeClose))
//            closeClaw();
//      
        mtArm.set(0);
        
        if (joy.getRawButton(Config.MyJoystick.btIntakeUp)) 
        {
            System.out.println("Intake Up");
            armUp();
        }

        if (joy.getRawButton(Config.MyJoystick.btIntakeDown))
        {
            System.out.println("Intake Down");
            armDown();
        }
        
    }

    /**
     * Opens horizontal part of intake
     */
    public void openClaw() {
        mtClaw.set(Config.Intake.mtClawSpeed);
    }

    /**
     * Closes horizontal part of intake
     */
    public void closeClaw() {
        mtClaw.set(-Config.Intake.mtClawSpeed);
    }

    /**
     * Opens vertical part of intake
     */
    public void armUp() {
        mtArm.set(Config.Intake.mtArmSpeed);
    }

    /**
     * Closes vertical part of intake
     */
    public void armDown() {
        mtArm.set(-Config.Intake.mtArmSpeed);
    }

}
