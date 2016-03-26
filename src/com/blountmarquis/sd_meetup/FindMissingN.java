package com.blountmarquis.sd_meetup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by me28017 on 3/26/2016.
 */

/**
 * From "Coding Interview Practice" Meetup on 3/25/2016
 * 
 * Problem: Given an array of N-1 integers whose range can be
 * from 1 - N, find the number that is missing.
 * 
 * The array won't have any duplicates and can be in any order.
 * 
 * Example: N = 5
 *   Array: [4, 1, 3, 5]
 *   
 *   Answer: The missing number is 2
 * 
 */

public class FindMissingN
{
	public static void main (String[] args)
	{
		int [] arr = new int [] {4, 1, 3, 5};
		int missing = getMissing(arr);

		System.out.println("For the array: " + Arrays.toString(arr));
		System.out.println("The missing number is: " + missing);

		arr = generateRandomNMinusOneArray(10000, 8789);
		missing = getMissing(arr);

		System.out.println("For the array: " + Arrays.toString(arr));
		System.out.println("The missing number is: " + missing);
	}

	/*
	 * The missing number is found by summing the digits 1 - N
	 * and comparing that sum to the sum of the digits in the array.
	 * The difference is the missing number.
	 */
	private static int getMissing (int [] arr)
	{
		// determine N
		int n = arr.length + 1;
		
		// see https://en.wikipedia.org/wiki/Triangular_number
		int expectedSum = (n * (n + 1)) / 2; // this will always be even
		
		int actualSum = 0;
		
		for (int i : arr)
		{
			actualSum += i;
		}

		int missing = expectedSum - actualSum;

		return missing;
	}

	private static int [] generateRandomNMinusOneArray (final int n, final int exclude)
	{
		if (exclude < 1 || exclude > n)
		{
			throw new IllegalArgumentException("Your exclude is less than 1 or greater than n");
		}
		
		List<Integer> list = new ArrayList<Integer> (n - 1);
		
		for (int i = 1; i <= n; i++)
		{
			if (i != exclude)
			{
				list.add(i);
			}
		}

		java.util.Collections.shuffle(list);

		int [] arr = new int [n - 1];
		
		for (int i = 0; i < n - 1; i++)
		{
			arr[i] = list.get(i);
		}

		return arr;
	}
}
