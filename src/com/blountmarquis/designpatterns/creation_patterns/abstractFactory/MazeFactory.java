package com.blountmarquis.designpatterns.creation_patterns.abstractFactory;

import com.blountmarquis.maze.models.Door;
import com.blountmarquis.maze.models.Maze;
import com.blountmarquis.maze.models.Wall;

/**
 * Created by MLBlount on 10/1/2014.
 */
public class MazeFactory {
    public MazeFactory(){}

    public Maze makeMaze(){
        return new Maze();
    }
    public Wall makeWall(){
        return new Wall();
    }
    public Door makeDoor(){
        return new Door();
    }
}
