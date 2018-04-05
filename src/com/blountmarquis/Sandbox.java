package com.blountmarquis;

import java.io.IOException;

/**
 */
public class Sandbox {
    public static void main(String args[]) throws IOException {

        //int array[] = new int[]{31, 41, 59, 26, 41, 58};
            /*InsertionSort.printArray(array);
            System.out.println("--------------");
            InsertionSort.sort(array);
            System.out.println("-------------");
            InsertionSort.printArray(array);*/

            /*SelectionSort.printArray(array);
            SelectionSort.sort(array);
            System.out.println();
            SelectionSort.printArray(array);*/

           /* MergeSort.printArray(array);
            MergeSort.sort(array);
            System.out.println();
            MergeSort.printArray(array);*/

            /*int array[] = new int[]{13, -3, -25, 20, -3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
            MaxSubArray.printArray(MaxSubArray.findMaxSubArray(array));*/
        //1, 2, 3, 8, 4, 9, 10, 14, 16, 7
        //16, 4, 10, 14, 7, 9, 3, 2, 8, 1
            /*int array[] = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
            PrintableArray.printArray("initial array", array);
            Heap.buildMinHeap(array);
            Heap.printArray("Min Heap ",array);
            Heap.buildMaxHeap(array);
            Heap.printArray("Max Heap Recursive", array);
            array = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
            Heap.buildMaxHeapIterative(array);
            Heap.printArray("Max Heap Iterative", array);*/

            /*PriorityQueue.heapDecreaseKey(array, 3, 5);
            PrintableArray.printArray(array);

            array = PriorityQueue.minHeapInsert(array, 20);
            PrintableArray.printArray(array);

            array = PriorityQueue.heapExtractMin(array);
            PrintableArray.printArray(array);

            array = Heap.minHeapDelete(array, 0);
            array = Heap.minHeapDelete(array, 0);
            array = Heap.minHeapDelete(array, 0);
            array = Heap.minHeapDelete(array, 0);
            PrintableArray.printArray("Heap delete", array);*/

            /*int array[] = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
            PrintableArray.printArray("initial array", array);
            HeapSort.maxHeapSort(array);
            Heap.printArray("Max Heap Sort", array);

            Integer array1[] = new Integer[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
            ArrayList<Integer> list = new ArrayList<Integer>(Arrays.<Integer>asList(array1));
            HeapSort.maxHeapSort(list);
            System.out.println("ArrayListHeap : " + list);*/
            /*Permutation.printPermutations("AB");*/
            /*TreeMap<String, ArrayList<String>> treeMap = new TreeMap<String, ArrayList<String>>();
            treeMap.put("hello", new ArrayList<String>());
            ArrayList<String> list = treeMap.get("hello");
            list.add("world");
            list.add("its quis");
            treeMap.put("A", new ArrayList<String>());
            ArrayList<String> list2 = treeMap.get("A");
            list2.add("Sup");
            list2.add("fam");
            for(String key: treeMap.keySet()){
                System.out.print(treeMap.get(key));

            }*/


            /*int array[] = new int[]{5 ,8 ,1 ,3 ,7 ,9 ,2};//{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
            QuickSort.sort(array);
            PrintableArray.printArray("Quick Sort ", array);*/



            /*LinkedList<Integer> LL = new LinkedList<Integer>();
            LL.insert(10);
            LL.insert(15);
            LL.insert(25);
            LinkedList.Node<Integer> LL2 = LL.rotateRight(2);
            while(LL2 != null) System.out.println(LL2.getValue());*/

            /*LinkedList<Integer> LL2 = new LinkedList<Integer>();


            System.out.println(LL);
            LL2.insert(1);
            LL2.insert(9);
            LL2.insert(5);
            System.out.println(LL2);
            LL.set(LL2);
            System.out.println(LL);
            LL.partition(10);
            System.out.println(LL);
            LL.reverse();
            System.out.println(LL);*/

    /*        Integer[] array = new Integer[]{1, 3, 4, 5, 7, 10, 12};
            BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();

            binaryTree.insert(5);
            binaryTree.insert(3);
            binaryTree.insert(10);
            binaryTree.insert(1);
            binaryTree.insert(4);
            binaryTree.insert(7);
            binaryTree.insert(12);
            System.out.println("Height is: " + binaryTree.getHeight());
            System.out.println("sum of height: " + binaryTree.getSumOfHeight(2));
            binaryTree.preOrderTraversalPrint();
            System.out.println();
            binaryTree.iterativePreOrder();
            System.out.println();
            binaryTree.inOrderTraversalPrint();
            System.out.println();
            binaryTree.postOrderTraversalPrint();
            System.out.println();
            BinaryTree<Integer> binaryTree1 = BinaryTree.constructTreeFromInOrderList(array);
            binaryTree1.postOrderTraversalPrint();
            System.out.println();
            BinaryTree.Node node = binaryTree.search(12);
            BinaryTree.Node successor = binaryTree.successor(node);
            BinaryTree.Node parent = binaryTree.getParent(node);
            System.out.println("Successor is: " + successor);
            binaryTree.delete(10);
            binaryTree.preOrderTraversalPrint();*/

            /*Integer array[] = new Integer[]{1,6,3,4,5};
            BinaryTree tree = new BinaryTree(BinaryTree.createMinimalBST(array));
            tree.preOrderTraversalPrint();
            System.out.println(BinaryTree.isBST(tree.getRoot()));*/

            /*int[][] multiArray = new int[][]{
                    new int[]{15, 20, 70, 85},
                    new int[]{20, 35,80,95},
                    new int[]{30,55,95,105},
                    new int[]{40,80,100,120}
            };

            MultiDimensionalArray.print(multiArray);
            System.out.println("Value Searched for is: " + MultiDimensionalArray.binarySearch(multiArray, 15));*/

    /*        int x = 6;
                int i=0;
                while(x > 0) {
                    x=x&(x-1);
                    i++;
                }
            System.out.println(i);*/

           /* ArithmeticSymbols.Operands eString = ArithmeticSymbols.Operands.addition;
            System.out.println(ArithmeticSymbols.Operands.addition.operand);*/



            /*Integer array[] = new Integer[]{1,6,3,4,5};
            PrintableArray.printArrayDescendingOrder(array);*/
            /*String date = "12-31-2015";
            DateCalculator dateCalculator = new DateCalculator();
            System.out.println("Number of Days is: " + dateCalculator.dateToDays(date));*/

            /*int array[] = new int[]{4,6,6,6,5,8,8};
            int leader = Leader.getLeader(array);
            System.out.println(leader);*/

    /*      int[] array = new int[]{2,3,7,5,1,3,9};
            int[] sums = CountingPrefix.getPrefixSums(array);
            PrintableArray.printArray("Sums is: ", sums);
            System.out.println("Slice total of sum from 0 to 4 is: " + CountingPrefix.countTotalSlice(sums, 0, 4));*/

            /*int[] array = new int[]{5,-7,3,5,-2,4,-1};
            int maxSlice = MaxSlice.getMaxSlice(array);
            System.out.println("------Final Max Slice-----");
            System.out.println("Max slice is: " + maxSlice);*/

        /*String timezone = "US/Eastern";
        ZoneId zoneId = ZoneId.of(timezone);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), zoneId);

        ZonedDateTime midNight = ZonedDateTime.of(zonedDateTime.getYear(), zonedDateTime.getMonthValue(),
                                                 zonedDateTime.getDayOfMonth(), 16, 0, 0, 0, zoneId);

        zonedDateTime.truncatedTo(ChronoUnit.HOURS);
        midNight.truncatedTo(ChronoUnit.HOURS);

        System.out.println("Truncated time 1: " + zonedDateTime.truncatedTo(ChronoUnit.HOURS));
        System.out.println("Midnight: " + midNight.truncatedTo(ChronoUnit.HOURS));

        boolean isEqual = zonedDateTime.truncatedTo(ChronoUnit.HOURS).isEqual(midNight);
        System.out.println("isEqual? " + String.valueOf(isEqual));
        if(zonedDateTime.truncatedTo(ChronoUnit.HOURS).equals(midNight.truncatedTo(ChronoUnit.HOURS))) {
            System.out.println("timezones must be the same");
        }

        System.out.println("---------");
        ZonedDateTime currentTime = ZonedDateTime.ofInstant(Instant.now(),ZoneId.systemDefault());
        System.out.println("Current time in sd: " + currentTime);
        //String timezone = venue.getTimezone();
        //ZoneId zoneId = ZoneId.of(timezone);
        ZonedDateTime currentTimeAtVenue = currentTime.withZoneSameInstant(zoneId);
        System.out.println("Current time in NY: " +currentTimeAtVenue);


        System.out.println(36D);*/




	   
    }

}
