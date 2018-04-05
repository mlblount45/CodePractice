package com.blountmarquis.datastructures;

/**
 * Created by MLBlount on 10/12/2014.
 */
public class Queue<T extends Comparable<T>> {

  LinkedList<T> queue;

  public Queue() {
    queue = new LinkedList<T>();
  }

  public void add(T val) {
    queue.insert(val);
  }

  public void remove() {
    queue.delete(queue.getTail());
  }

}
