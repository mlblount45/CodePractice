package com.blountmarquis.datastructures;

import java.util.Iterator;

/**
 * Created by MLBlount on 12/8/2015.
 */
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        next = next();
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer temp = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public void remove() {

    }
}
