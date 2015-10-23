package com.blountmarquis.util;

import java.lang.instrument.Instrumentation;

/**
 * Created by MLBlount on 7/16/2015.
 */
public class ObjectSizeFetcher {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }
}
