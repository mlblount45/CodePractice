package com.blountmarquis.kata;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mlblount on 1/11/2016.
 */
public class IntegerToWordConverter {

    private static final Map<Integer,String> singleDigitLookup = new HashMap<Integer, String>(){{
        put(0,"Zero");put(1,"One");put(2,"Two");put(3,"Three");put(4,"Four");put(5,"Five");put(6,"Six");put(7,"Seven");
        put(8,"Eight");put(9,"Nine");
    }};

    private static final Map<Integer,String> teensLookup = new HashMap<Integer, String>(){{
        put(10,"Ten");put(11,"Eleven");put(12,"Twelve");put(13,"Thirteen");put(14,"Fourteen");put(15,"Fifteen");
        put(16,"Sixteen");put(17,"Seventeen");put(18,"Eighteen");put(19,"Nineteen");
    }};

    private static final Map<Integer,String> tensDigitLookup = new HashMap<Integer, String>(){{
        put(2,"Twenty");put(3,"Thirty");put(4,"Forty");put(5,"Fifty");put(6,"Sixty");put(7,"Seventy");put(8,"Eighty");
        put(9,"Ninety");
    }};

    public static String toWords(int num) {
        if(num < 10) return singleDigitLookup.get(num);
        else if(num < 20) return teensLookup.get(num);
        else if(num < 100) return tensDigitLookup.get(num / 10) + getRemainingWords(num, 10);
        else if(num < 1000) return toWords(num / 100) + " Hundred" + getRemainingWords(num, 100);
        else if(num < 1000000) return toWords(num / 1000) + " Thousand" + getRemainingWords(num, 1000);
        else if(num < 1000000000) return toWords(num / 1000000) + " Million" + getRemainingWords(num, 1000000);
        else if(num >= 1000000000) return toWords(num / 1000000000) + " Billion" + getRemainingWords(num, 1000000000);
        else return "";
    }

    private static String getRemainingWords(int num, int div) {return num % div == 0 ? "" : " " + toWords(num % div);}
}
