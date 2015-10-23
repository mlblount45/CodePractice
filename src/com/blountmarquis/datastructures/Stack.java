package com.blountmarquis.datastructures;

/**
 * Created by MLBlount on 10/12/2014.
 */
public class Stack<T extends Comparable<T>>  {
    private LinkedList<T> stack;

    private int size;

    public Stack(){
        stack = new LinkedList<T>();
        size = 0;
    }

    public <T extends Comparable<T>> void push(T val){
        stack.insert(val);
        size++;
    }

    public T pop(){
        if(size <= 0) return null;
        else{
            size--;
            return stack.delete(stack.getHead()).getValue();
        }
    }

    public int size() {
        return size;
    }

}
