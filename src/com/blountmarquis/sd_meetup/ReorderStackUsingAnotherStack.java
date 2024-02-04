package com.blountmarquis.sd_meetup;

import java.util.Random;

/**
 * Created by me28017 on 04/09/2016.
 */

/**
 * From "Coding Interview Practice" Meetup on 04/08/2016
 * 
 * Problem: Given a stack of random integers sort the stack.
 * The only other data structure that can be used is another stack.
 * 
 * Note: There exists more elegant solutions out there.
 * 
 */

public class ReorderStackUsingAnotherStack
{
	public static void main (String[] args)
	{
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

		fillStack(stack, 25);

		System.out.println("Stack before reorder:");
		printStack(stack);

		java.util.Stack<Integer> orderedStack = reorderStack(stack);

		System.out.println("\nStack after reorder:");
		printStack(orderedStack);
	}

	/*
	 * Orders the passed in stack using only another stack and returns the other
	 * stack with the values in ascending order.
	 */
	private static java.util.Stack<Integer> reorderStack (java.util.Stack<Integer> stack)
	{
		java.util.Stack<Integer> orderedStack = new java.util.Stack<Integer>();

		int count = 0;
		int size = stack.size();

		while (orderedStack.size() != size)
		{
			int largest = Integer.MIN_VALUE;

			while (!stack.isEmpty())
			{
				int curr = stack.pop();

				if (curr > largest)
				{
					largest = curr;
				}
				orderedStack.push(curr);
			}

			int numOfLargest = 0;
			for (int i = 0; i < size - count; i++)
			{
				int curr = orderedStack.pop();

				if (curr != largest)
				{
					stack.push(curr);
				}
				else
				{
					numOfLargest++;
				}
			}

			for (int i = 0; i < numOfLargest; i++)
			{
				orderedStack.push(largest);
				count++;
			}
		}
		return orderedStack;
	}

	/*
	 * Prints out the stack in vertical format.
	 */
	private static void printStack (java.util.Stack<Integer> stack)
	{
		Object[] arr = stack.toArray();

		System.out.println("top");
		for (int i = arr.length - 1; i >= 0; i--)
		{
			System.out.println(" " + arr[i]);
		}
		System.out.println("bottom");
	}

	/*
	 * Fills a stack with random numbers.
	 */
	private static void fillStack (java.util.Stack<Integer> stack, int size)
	{
		for (int i = 0; i < size; i++)
		{
			Random r = new Random();
			stack.push(r.nextInt());
		}
	}
}
