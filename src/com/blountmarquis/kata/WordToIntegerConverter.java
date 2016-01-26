package com.blountmarquis.kata;

import java.util.HashMap;

/**
 * Created by mlblount on 1/11/2016.
 */
public class WordToIntegerConverter {

    private static HashMap<String, Integer> integerLookup = new HashMap<String, Integer>(){{
        put("",0);put("Zero",0);put("One", 1);put("Two", 2);put("Three", 3);put("Four", 4);put("Five",5);
        put("Six", 6);put("Seven",7);put("Eight",8);put("Nine",9);

        put("Ten",10);put("Eleven",11);put("Twelve",12);put("Thirteen",13);put("Fourteen",14);put("Fifteen",15);
        put("Sixteen",16);put("Seventeen",17);put("Eighteen",18);put("Nineteen",19);

        put("Twenty",20);put("Thirty",30);put("Forty",40);put("Fifty",50);put("Sixty",60);put("Seventy",70);
        put("Eighty",80);put("Ninety",90);
    }};

    private static HashMap<String, Integer> denominationLookup = new HashMap<String, Integer>(){{
        put("Hundred", 100);put("Thousand", 1000);put("Million", 1000000);put("Billion", 1000000000);
    }};
    public static int toInteger(String word) {
        int num = 0, finalNum = 0;
        for (String w : word.split(" ")) {
            if(integerLookup.containsKey(w)) num += integerLookup.get(w);
            else {
                num *= denominationLookup.get(w);
                if(w.equals("Hundred")) continue;
                finalNum += num;
                num = 0;
            }
        }
        return finalNum+num;
    }
}
