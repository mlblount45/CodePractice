package com.blountmarquis.crackingTheCodingInterview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ArrayList;

/**
 * Created by MLBlount on 5/12/2015.
 */
public class Problem9_4 {
    public static ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set){
        if (set == null) return null;

        ArrayList<Integer> seen = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> subSets = new ArrayList<ArrayList<Integer>>();
        subSet(seen, set, subSets);
        return subSets;
    }

    private static void subSet(ArrayList<Integer> seen, ArrayList<Integer> unSeen, ArrayList<ArrayList<Integer>> subSets) {
        if (unSeen.size() == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(seen);
            subSets.add(temp);
        }else {
            Integer temp = unSeen.iterator().next();
            unSeen.remove(temp);
            ArrayList<Integer>  newUnseen = new ArrayList<Integer>();
            newUnseen.addAll(unSeen);
            subSet(seen, newUnseen, subSets);
            seen.add(temp);
            ArrayList<Integer> newSeen = new ArrayList<Integer>();
            newSeen.addAll(seen);
            subSet(newSeen, newUnseen, subSets);


        }
    }

    public static void main(String[] args){
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        /*set.add(4);
        set.add(5);*/
        ArrayList<ArrayList<Integer>> subSets = Problem9_4.getSubSets(set);
        for(ArrayList<Integer> hs: subSets){
            for (Integer i: hs){
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
