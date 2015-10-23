package com.blountmarquis.designpatterns.creation_patterns.abstractFactory;

import com.blountmarquis.maze.models.*;

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
