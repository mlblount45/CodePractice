package com.blountmarquis;

import java.awt.*;
import java.util.Random;

/**
 * Created by mlblount on 9/17/2014.
 */
public class MouseMover implements Runnable {

    @Override
    public void run() {
        long threadSleepTime = 120000;
        for (;;){
            moveMouse();
            try {
                Thread.sleep(threadSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void moveMouse() {
        Random randomGenerator = new Random();
        int val1 = randomGenerator.nextInt(1500);
        int val2 = randomGenerator.nextInt(1500);
        try {
            Robot robot = new Robot();
            robot.mouseMove(val1, val2);
            System.out.println("Moving mouse to X: " + val1 + " Y: " + val2);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
