package com.blountmarquis.designpatterns.creation_patterns.abstractFactory;

import com.blountmarquis.maze.models.Maze;

/**
 * Created by MLBlount on 10/1/2014.
 */
public class MazeGame {
    public MazeGame(){}
    public Maze createMaze(MazeFactory factory){
        Maze maze = new Maze();
        //build maze
        return maze;
    }
}
