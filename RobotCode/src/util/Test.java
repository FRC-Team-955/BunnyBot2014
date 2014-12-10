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
    
    public void run(){
    
      
    
    }
    
    
    public void testTalon(MyTalon talon, double startTime, String talonName){
    timer.reset();
    timer.start();
    
    if(timer.get() == 1) System.out.println("Running Left Talon 1 in 5 Seconds");
    if(timer.get() == 2) System.out.println("Running Left Talon 1 in 4 Seconds");
    if(timer.get() == 3) System.out.println("Running Left Talon 1 in 3 Seconds");
    if(timer.get() == 4) System.out.println("Running Left Talon 1 in 2 Seconds");
    if(timer.get() == 5) System.out.println("Running Left Talon 1 in 1 Seconds");
     d.mtLeftOne.ramp(.7);
    if(timer.get() == 10) d.mtLeftOne.ramp(0);
    
    if(timer.get() > 13) timer.stop();
    
    }
    
    
}
