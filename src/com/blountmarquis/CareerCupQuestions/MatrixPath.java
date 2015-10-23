package com.blountmarquis.CareerCupQuestions;

/**
 * Created by mlblount on 5/28/2015.
 */
public class MatrixPath {

    public static boolean isPathExist(int[][] matrix, Position start, Position end){

        if(start.row < 0 || start.row >= matrix.length) return false;
        if(start.col < 0 || start.col >= matrix[0].length) return false;
        return search(matrix, start, end);
    }

    private static boolean search(int[][] matrix, Position location, Position end) {
        if(location == null) return false;
        if(location.equals(end)) return true;
        matrix[location.row][location.col] = -1;
        Position moveUp = moveUp(matrix, location);
        Position moveRight = moveRight(matrix,location);
        Position moveDown = moveDown(matrix,location);
        Position moveLeft = moveLeft(matrix,location);

        return search(matrix,moveDown,end) || search(matrix, moveLeft, end) ||
                search(matrix, moveRight, end) || search(matrix,moveUp, end);
    }

    private static Position moveLeft(int[][] matrix, Position location) {
        int keep = location.row;
        int move = location.col - 1;
        if(move < 0 || matrix[keep][move] != 0) return null;
        return new Position(keep,move);
    }

    private static Position moveDown(int[][] matrix, Position location) {
        int move = location.row + 1;
        int keep = location.col;
        if(move >= matrix.length || matrix[move][keep] != 0) return null;
        return new Position(move,keep);
    }

    private static Position moveRight(int[][] matrix, Position location) {
        int keep = location.row;
        int move = location.col + 1;
        if(move >= matrix[0].length || matrix[keep][move] != 0) return null;
        return new Position(keep,move);
    }

    private static Position moveUp(int[][] matrix, Position location) {
        int move = location.row - 1;
        int keep = location.col;
        if(move < 0 || matrix[move][keep] != 0) return null;
        return new Position(move,keep);
    }

    private static class Position {
        int row;
        int col;

        public Position(int x, int y){
            this.row = x;
            this.col = y;
        }
        public Position(Position p){
            this.row = p.row;
            this.col = p.col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;

            Position position = (Position) o;

            if (col != position.col) return false;
            if (row != position.row) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }

    public static void main(String[] args){

        int[][] matrix = new int[][]{
                {0,0,1,0,1},
                {0,0,0,0,0},
                {0,1,1,1,1},
                {0,1,1,0,0},
                {0,0,0,0,0}
        };
        Position start = new Position(1,4);
        Position end = new Position(3,0);
        System.out.println("is path exist? : " + MatrixPath.isPathExist(matrix,start,end)); //output true
        start = new Position(0,0);
        end = new Position(2,1);
        System.out.println("is path exist? : " + MatrixPath.isPathExist(matrix,start,end)); //output false

    }
}
