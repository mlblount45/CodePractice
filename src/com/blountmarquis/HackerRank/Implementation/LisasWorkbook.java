package com.blountmarquis.HackerRank.Implementation;

import java.util.Scanner;

/**
 * Created by mlblount on 3/23/2016.
 *
 * https://www.hackerrank.com/challenges/bear-and-workbook
 *
 * this is a problem marked as easy in hackerrank. I started by first trying to solve this problem by creating a design
 * representing the problem including a Chapter, Page, and Problem object this added unnecessary complexity and
 * complicated the problem.
 *
 * I then tried coming up with some formula which would outperform the naive algorithm. I observed i would need to
 * calculate all of the pages the new chapter would create then determine how many special problems exist in that
 * range of new pages. This seemed like it was definitely the right way to go but i wasn't seeing clearly how to connect
 * the range of pages back to the problems that would exist on the page. This approach is O(n)
 *
 * I finely settled with just implementing the naive approach which have complexity of O(n * t) n is the number of
 * chapters while t is the largest problem set out of the n chapters.
 */
public class LisasWorkbook {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] arr = buildArray(in, n);
    System.out.println(specialProblemCount(arr, k));
  }

  private static int[] buildArray(Scanner in, int size) {
    in.nextLine();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = in.nextInt();
    }
    return arr;
  }

  private static int specialProblemCount(int[] arr, int k) {

    int page = 1, special = 0;
    for (int probCount : arr) {
      for (int i = 1; i <= probCount; i++) {
        if (i == page) {
          special++;
        }
        if (i % k == 0) {
          page++;
        }
      }
      if (probCount % k != 0) {
        page++;
      }
    }
    return special;
  }
}
