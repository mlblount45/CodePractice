package com.blountmarquis.testArea;

/**
 * Created by MLBlount on 8/3/2015.
 */
public class polyClass implements polyInterface{
    public int i;
    public int j;

    public polyClass(int i, int i1) {
        this.i = i;
        this.j = i1;
    }

    @Override
    public String toString() {
        return "polyClass{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
