package com.blountmarquis.datastructures;

/**
 * Created by MLBlount on 2/23/2015.
 */
public class MultiDimensionalArray {

    private static class Coordinate {
        int row;
        int col;
        public Coordinate(int row, int column){
            this.row = row;
            this.col = column;
        }

        public Coordinate(){}

        private static Coordinate getMidPoint(Coordinate start, Coordinate end){
            Coordinate midCoordinate = new Coordinate();
            midCoordinate.row = (start.row + end.row)/2;
            midCoordinate.col = (start.col + end.col)/2;
            return midCoordinate;
        }

        private boolean isBefore(Coordinate coord){
            return row <= coord.row && col <= coord.col;
        }

        public Coordinate decrementCoordinate(){
            return new Coordinate(this.row - 1,this.col - 1);
        }

        public Coordinate incrementCoordinate(){
            return new Coordinate(this.row + 1, this.col + 1);
        }

    }

    /**
     * Do not use not properly implemented contains bugs
     * @param multiArr
     * @param val
     * @return
     */
    @Deprecated
    public static int binarySearch(int[][] multiArr, int val) {
        if(multiArr == null)return -1;
        Coordinate start = new Coordinate(0,0);
        Coordinate end = new Coordinate(multiArr.length - 1, multiArr[0].length - 1);
        return binarySearch(multiArr, val, start, end);
    }

    @Deprecated
    private static int binarySearch(int[][] multiArr, int val, Coordinate start, Coordinate end) {
        if(!start.isBefore(end)) return -1;
        Coordinate midCoord = Coordinate.getMidPoint(start, end);

        if(multiArr[midCoord.row][midCoord.col] == val)
            return val;
        else if(multiArr[midCoord.row][midCoord.col] < val){
            return binarySearch(multiArr, val, midCoord.incrementCoordinate(), end);
        }else
            return binarySearch(multiArr,val,start,midCoord.decrementCoordinate());
    }

    /**
     * Print 2D multi-dimensional array
     * @param multiArr
     */
    public static void print(int[][] multiArr){
        if(multiArr == null) return;
        for(int i = 0; i < multiArr.length; i++){
            for (int j = 0; j < multiArr[i].length; j++) {
                System.out.print(multiArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
