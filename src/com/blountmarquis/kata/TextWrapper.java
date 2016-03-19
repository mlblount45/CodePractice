package com.blountmarquis.kata;

/**
 * Created by mlblount on 1/19/2016.
 */
public class TextWrapper {
    public static String wrap(String text, int maxColumn) {
        if(text.length() <= maxColumn) return text;

        int firstSpaceIndex = text.substring(0, maxColumn).lastIndexOf(' ');
        if(firstSpaceIndex != -1)
            return text.substring(0, firstSpaceIndex) + "\n" + wrap(text.substring(firstSpaceIndex + 1),maxColumn);
        else if(text.charAt(maxColumn) == ' ')
            return text.substring(0, maxColumn) + "\n" + wrap(text.substring(maxColumn + 1),maxColumn);
        else
            return text.substring(0, maxColumn) + "\n" + wrap(text.substring(maxColumn),maxColumn);
    }
}
