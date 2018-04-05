package com.blountmarquis;

import com.blountmarquis.designpatterns.creation_patterns.abstractFactory.EnchantedMazeFactory;
import com.blountmarquis.designpatterns.creation_patterns.abstractFactory.MazeGame;
import com.blountmarquis.maze.models.EnchantedMaze;
import com.blountmarquis.maze.models.Maze;

/**
 * Created by MLBlount on 10/1/2014.
 */

/**
 * This implementation doesn’t use an AbstractFactory. It uses a Base concrete class
 * that other products extent and override parts as needed.
 */
public class RunMazeAbstractFactoryClient {

  public static void main(String[] args) {
    playWithBasicMaze();
  }

  public static void playWithBasicMaze() {
    MazeGame mazeGame = new MazeGame();
    EnchantedMazeFactory enchantedMazeFactory = new EnchantedMazeFactory();
    Maze maze = new EnchantedMaze(mazeGame.createMaze(enchantedMazeFactory));
    System.out.println("Maze class is:" + maze.getClass());
  }
}
