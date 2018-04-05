package com.blountmarquis;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

/**
 * Created by mlblount on 9/17/2014.
 */
public class MouseMover implements Runnable {

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

  @Override
  public void run() {
    for (; ; ) {
      moveMouse();
      sleepThread();
    }
  }

  private void sleepThread() {
    long threadSleepTime = 120000;
    try {
      Thread.sleep(threadSleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
