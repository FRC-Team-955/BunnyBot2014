/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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

    public void run(){
    
    Timer timer = new Timer();
    
    timer.start();
    if(timer.getTime == 1) System.out.println("Running Left Talon 1 in 5 Seconds");
    if(timer.getTime == 2) System.out.println("Running Left Talon 1 in 4 Seconds");
    if(timer.getTime == 3) System.out.println("Running Left Talon 1 in 3 Seconds");
    if(timer.getTime == 4) System.out.println("Running Left Talon 1 in 2 Seconds");
    if(timer.getTime == 5) System.out.println("Running Left Talon 1 in 1 Seconds");
  
    
    }
    
    
}
