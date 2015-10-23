package com.blountmarquis.testArea;

import com.blountmarquis.util.ObjectSizeFetcher;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MLBlount on 7/16/2015.
 */
public class SizeTest {

    private static Instrumentation instrumentation;
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("0000000000");
        list.add("9999999999");
        System.out.println(ObjectSizeFetcher.getObjectSize(list));
    }
}
