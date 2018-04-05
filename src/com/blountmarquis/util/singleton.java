package com.blountmarquis.util;

/**
 * Created by mlblount on 7/14/16.
 */
public class singleton {
	private static singleton ourInstance = new singleton();

	public static singleton getInstance() {
		return ourInstance;
	}

	private singleton() {
	}
}
