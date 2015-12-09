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
        System.out.println(current);
    }

    public int next() {
        int temp = 0;
        int next = current % lists.size() + 1;
        if (lists.get(current).size() == 0) temp = lists.get(next).remove(0);
        else temp = lists.get(current).remove(0);
        current = next;
        size--;
        return temp;
    }

    public boolean hasNext() {
        return size > 0;
    }
}
