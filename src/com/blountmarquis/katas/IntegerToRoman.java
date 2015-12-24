package com.blountmarquis.katas;

/**
 * Created by MLBlount on 12/24/2015.
 */
public class IntegerToRoman {

    public static String getRoman(int i) {
        if(i == 0) return "";
        if(i == 5) return "V";
        return "I";
    }
}
