package com.blountmarquis.algorithms.sorting;

import com.blountmarquis.datastructures.ArrayListHeap;
import com.blountmarquis.datastructures.Heap;

import java.util.ArrayList;

/**
 * Created by MLBlount on 10/5/2014.
 */
public class HeapSort extends Heap {

    public static void maxHeapSort(int[] array) {
        if (array == null) return;
        Heap.buildMaxHeap(array);
        int heapSize = array.length;
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            Heap.maxHeapify(array, 0, --heapSize);
            //maxHeapifyIterative(array, --heapSize);
        }
    }

    public static void maxHeapSort(ArrayList<Integer> list){
        if(list == null) return;
        ArrayListHeap.buildHeap(list);
        int heapSize = list.size();
        for(int i = list.size() - 1; i >=0; i--){
            int temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);
            ArrayListHeap.heapify(list, 0, --heapSize);
        }
    }
}