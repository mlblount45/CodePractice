package com.blountmarquis.HackerRank.Greedy;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Jim and the Orders
 *
 * https://www.hackerrank.com/challenges/jim-and-the-orders
 *
 * Created by mlblount on 2/18/2016.
 */
public class BurgerOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int customers = in.nextInt();

        Queue<Order> priorityQueue = new PriorityQueue<>(10, new OrderComparator());
        for(int i = 1; i <= customers; i++) {
            priorityQueue.add(new Order(i,in.nextInt() + in.nextInt()));
        }
        System.out.println(printOrder(priorityQueue));
    }

    private static String printOrder(Queue<Order> priorityQueue) {
        StringBuilder sb = new StringBuilder();
        while(!priorityQueue.isEmpty()){
            sb.append(priorityQueue.poll().orderNumber);
            if(!priorityQueue.isEmpty()) sb.append(" ");
        }
        return sb.toString();
    }

    private static class Order {
        int orderNumber;
        int completeTime;
        public Order(int number, int time){
            this.orderNumber = number;
            this.completeTime = time;
        }
    }

    private static class OrderComparator implements java.util.Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            int timeSort = o1.completeTime-o2.completeTime;
            if(timeSort != 0) return timeSort;
            return o1.orderNumber - o2.orderNumber;
        }
    }
}
