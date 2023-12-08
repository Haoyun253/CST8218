/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.haoyun.bouncer;

import cst8218.haoyun.bouncer.entity.Bouncer;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Haoyun Deng
 * 
 * This is the main class executed by the driver. Contains the main methods of your application.
 * The @Startup annotation instantiates the class when the application is deployed, and the @Singleton annotation makes it a single instance that belongs to the application.
 * It accesses the Bouncer entity by injecting the BouncerFacade @PostConstruct annotation which calls the go() method on class instantiation.
 * Inside the runnable, an infinite while loop runs on the thread until the application is shut down. 
 * When the loop runs, the logic implements time passing on the bouncer by getting all the bouncers in the database, calling its advanceOneFrame() method on each instance, and saving the updated bouncer back to the database every second specified by the CHANGE_RATE constant a given number of times.
 */
@Startup 
@Singleton
public class BouncerGame {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public static final int CHANGE_RATE = 1;
    
    @Inject
    private BouncerFacade bouncerFacade;
    
    private List<Bouncer> bouncers;
    
    @PostConstruct
    public void go() {
        new Thread(new Runnable() {
            public void run() {
                // the game runs indefinitely
                while (true) {
                    //update all the bouncers and save changes to the database
                    bouncers = bouncerFacade.findAll();
                    for (Bouncer bouncer : bouncers) {
                        bouncer.advanceOneFrame();
                        bouncerFacade.edit(bouncer);
                    }
                    //sleep while waiting to process the next frame of the animation
                    try {
                        // wake up roughly CHANGE_RATE times per second
                        Thread.sleep((long) (1.0 / CHANGE_RATE * 1000));
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
