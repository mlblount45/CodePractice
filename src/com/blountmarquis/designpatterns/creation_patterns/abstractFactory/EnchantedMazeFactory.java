package com.blountmarquis.designpatterns.creation_patterns.abstractFactory;

import com.blountmarquis.maze.models.Door;
import com.blountmarquis.maze.models.EnchantedDoor;
import com.blountmarquis.maze.models.EnchantedMaze;
import com.blountmarquis.maze.models.EnchantedWall;
import com.blountmarquis.maze.models.Maze;
import com.blountmarquis.maze.models.Spell;
import com.blountmarquis.maze.models.Wall;

/**
 * Created by MLBlount on 10/1/2014.
 */
public class EnchantedMazeFactory extends MazeFactory {

  protected Spell castSpell() {
    assert (true);
    return new Spell();
  }

  @Override
  public Maze makeMaze() {
    return new EnchantedMaze();
  }

  @Override
  public Door makeDoor() {
    return new EnchantedDoor();
  }

  @Override
  public Wall makeWall() {
    return new EnchantedWall();
  }
}
