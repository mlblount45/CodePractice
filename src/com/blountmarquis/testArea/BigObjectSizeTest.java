package com.blountmarquis.testArea;

import java.util.List;

/**
 * Created by mlblount on 6/3/2015.
 */
public class BigObjectSizeTest {
    public List<BigObject>  testSize() {
        return BigObjectFactory.getfBigObjects(55000);

    }

    public static void main(String[] args){
        System.out.println("Max Heap Size: " + Runtime.getRuntime().maxMemory());

        long preInitialization = Runtime.getRuntime().freeMemory();
        System.out.println("Current Heap Size: " + Runtime.getRuntime().totalMemory());

        System.out.println("Current Free Space: " + Runtime.getRuntime().freeMemory());

       /* // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory();

        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.
        // Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        // Get amount of free memory within the heap in bytes. This size will increase
        // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory();*/

        List<BigObject> bigObjectList = BigObjectFactory.getfBigObjects(45000);
        long postInitialization = Runtime.getRuntime().freeMemory();
       // System.out.println("Object Size: " + (preInitialization - postInitialization));
       /* for(BigObject big: bigObjectList){
            System.out.println("--");
        }*/
        System.out.println("Object Size: " + (preInitialization - postInitialization));

        System.out.println("Max Heap Size: " + Runtime.getRuntime().maxMemory());

        System.out.println("Current Heap Size: " + Runtime.getRuntime().totalMemory());

        System.out.println("Current Free Space: " + Runtime.getRuntime().freeMemory());

        BigObjectSizeTest test = new BigObjectSizeTest();
        //List<BigObject> a = test.testSize();
        //System.out.println("a size: " + a.size());
        //System.out.println(a.get(0).att1);

        List<BigObject> bigObjectList2 = BigObjectFactory.getfBigObjects(55000);
        System.out.println("Current Free Space: " + Runtime.getRuntime().freeMemory());

        //System.out.println(test.toString());
    }
}

