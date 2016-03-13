package com.blountmarquis.HackerRank;


import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by mlblount on 3/9/2016.
 */
public class PriorityQueueComparator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Student> queue = new PriorityQueue<Student>();
        for (int i = 0; i < n; i++) {
            in.nextLine();
            manageEvent(in, queue);
        }
        System.out.println(getRemainingStudents(queue));
    }

    private static void manageEvent(Scanner in, PriorityQueue<Student> queue) {
        String eventType = in.next();
        String name = in.next();
        double gpa = in.nextDouble();
        int token = in.nextInt();
        if (eventType.equals("ENTER")) {
            queue.add(new Student(token, name, gpa));
        } else {
            if (queue.isEmpty()) return;
            queue.poll();
        }
    }

    private static String getRemainingStudents(PriorityQueue<Student> queue) {
        if(queue.isEmpty()) return "EMPTY";
        StringBuilder sb = new StringBuilder();
        for (Student s : queue) {
            sb.append(s.name + "\n");
        }
        return sb.toString();
    }

    private static class Student implements Comparable<Student> {
        Double gpa;
        String name;
        Integer token;

        public Student(int token, String name, double gpa) {
            this.gpa = gpa;
            this.name = name;
            this.token = token;
        }

        @Override
        public int compareTo(Student that) {
            int result = 0;
            if ((result = this.gpa.compareTo(that.gpa)) != 0) return -result;
            else if ((result = this.name.compareTo(that.name)) != 0) return result;
            else return this.token.compareTo(that.token);
        }
    }

}
