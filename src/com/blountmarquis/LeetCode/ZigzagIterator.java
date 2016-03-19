package com.blountmarquis.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MLBlount on 12/8/2015.
 */
public class ZigzagIterator {

    Integer current;
    Integer size;
    List<List<Integer>> lists = new ArrayList<List<Integer>>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        lists.add(v1);
        lists.add(v2);
        current = lists.size();
        size = v1.size() + v2.size();
    }

    public int next() {
        int loc = current % 2;
        current = (loc + 1) % 2;
        size--;
        if (lists.get(loc).size() == 0) return lists.get(current).remove(0);
        else return lists.get(loc).remove(0);
    }

    public boolean hasNext() { return size > 0; }
}
