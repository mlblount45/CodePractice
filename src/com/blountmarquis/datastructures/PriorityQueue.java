package com.blountmarquis.datastructures;

import java.util.Arrays;

/**
 * Created by mlblount on 10/7/2014.
 */
public class PriorityQueue<S> {
    public static int heapMaximum(int[] array){return array[0];}

    public static int[] heapExtractMax(int[] array){
        if (array == null) return null;

        int max = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = max;
        int[] copy = Arrays.copyOf(array, array.length - 1);

        Heap.maxHeapify(copy, 0, copy.length);
        return copy;
    }

    public static void heapIncreaseKey(int[] array, int position, int value) {
        if (array == null) return;
        if (position > array.length || position < 0) return;

        array[position] = value;
        int parent = (position - 1)/2;
        while (parent >= 0 && array[position] > array[parent]){
            int temp = array[position];
            array[position] = array[parent];
            array[parent] = temp;
            position = parent;
            parent = (position - 1)/2;
        }
    }

    public static int[] maxHeapInsert(int[] array, int value){
        if (array == null) return null;
        int[] tempArray = Arrays.copyOf(array, array.length + 1);
        heapIncreaseKey(tempArray, tempArray.length - 1, value);
        return tempArray;
    }

    public static int heapMin(int[] array){ return array[0];}

    public static int[] heapExtractMin(int[] array){
        if (array == null) return null;

        int min = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = min;

        int[] copy = Arrays.copyOf(array, array.length-1);
        Heap.minHeapify(copy);
        return  copy;
    }

    public static void heapDecreaseKey(int[] array, int position, int value){
        if (array == null) return;
        if (position > array.length || position < 0) return;

        array[position] = value;
        int parent = (position - 1)/2;
        int temp;
        while (parent >= 0 && array[parent] > array[position]){
            temp = array[position];
            array[position] = array[parent];
            array[parent]= temp;
            position = (parent  - 1)/2;
            parent = (position - 1)/2;
        }
    }

    public static int[] minHeapInsert(int[] array, int value){
        if (array == null) return null;
        int[] copy = Arrays.copyOf(array, array.length+1);
        heapDecreaseKey(copy, copy.length - 1,value);
        return copy;
    }
}
