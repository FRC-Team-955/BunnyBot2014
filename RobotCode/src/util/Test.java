/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import core.Drive;
import core.Intake;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Programming
 */
public class Test {

    Drive d;
    Intake i;

    public Test(Drive d, Intake i) {

        this.d = d;
        this.i = i;

    }

    Timer timer = new Timer();

    public void run() {
        boolean timerStarted = false;

        if(!timerStarted) {
			timer.start();
			timerStarted = true;
		}
        
        if (timer.get() > 5.0) {

            
            System.out.println("Testing Left 1");
            
            d.mtLeftOne.ramp(.7);
            d.mtLeftTwo.ramp(0);
            d.mtLeftThree.ramp(0);
            d.mtRightOne.ramp(0);
            d.mtRightTwo.ramp(0);
            d.mtRightThree.ramp(0);
        }

        if (timer.get() > 10.0) {

            System.out.println("Testing Left 2");
            d.mtLeftOne.ramp(0);
            d.mtLeftTwo.ramp(.7);
            d.mtLeftThree.ramp(0);
            d.mtRightOne.ramp(0);
            d.mtRightTwo.ramp(0);
            d.mtRightThree.ramp(0);

        }

        if (timer.get() > 15.0) {

            System.out.println("Testing Left 3");
            d.mtLeftOne.ramp(0);
            d.mtLeftTwo.ramp(0);
            d.mtLeftThree.ramp(.7);
            d.mtRightOne.ramp(0);
            d.mtRightTwo.ramp(0);
            d.mtRightThree.ramp(0);

        }

        if (timer.get() > 20.0) {

            System.out.println("Testing Right 1");
            d.mtLeftOne.ramp(0);
            d.mtLeftTwo.ramp(0);
            d.mtLeftThree.ramp(0);
            d.mtRightOne.ramp(.7);
            d.mtRightTwo.ramp(0);
            d.mtRightThree.ramp(0);

        }

        if (timer.get() > 25.0) {

            
            System.out.println("Testing Right 2");
            d.mtLeftOne.ramp(0);
            d.mtLeftTwo.ramp(0);
            d.mtLeftThree.ramp(0);
            d.mtRightOne.ramp(0);
            d.mtRightTwo.ramp(.7);
            d.mtRightThree.ramp(0);

        }
        if (timer.get() > 30.0) {

            System.out.println("Testing Right 3");
            d.mtLeftOne.ramp(0);
            d.mtLeftTwo.ramp(0);
            d.mtLeftThree.ramp(0);
            d.mtRightOne.ramp(0);
            d.mtRightTwo.ramp(0);
            d.mtRightThree.ramp(.7);

        }
    
        if(timer.get() > 35) {}
        
        System.out.println("Stopping all");
        
         d.mtLeftOne.ramp(0);
            d.mtLeftTwo.ramp(0);
            d.mtLeftThree.ramp(0);
            d.mtRightOne.ramp(0);
            d.mtRightTwo.ramp(0);
            d.mtRightThree.ramp(0);
        
    }

}



