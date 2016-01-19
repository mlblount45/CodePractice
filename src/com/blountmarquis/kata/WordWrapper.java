package com.blountmarquis.kata;

/**
 * Created by MLBlount on 1/19/2016.
 */
public class WordWrapper {
    public static String wrap(String text, int maxColumn) {
        if(text == null) throw new IllegalArgumentException();
        if(maxColumn > text.length()) return text;


        return text.replace(" ", "\n");

    }
}
