package com.blountmarquis.kata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MLBlount on 12/29/2015.
 */
public class StringCalculatorKata {

    private static final String defaultDelimiters = ",\n";

    public static int sum(String str) {
        if(str == null) throw new IllegalArgumentException();
        if(str.isEmpty())return 0;
        if(str.length() == 1) return Integer.parseInt(str);
        Matcher m = getMatch(str);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(1);
            str = str.replace(("//" + customDelimiter + "\n"), "");
        }
        return getSum(str,defaultDelimiters+customDelimiter);
    }

    private static Matcher getMatch(String s){
        Pattern p = Pattern.compile("//(.)\n");
        Matcher m = p.matcher(s);
        return m;
    }

    private static int getSum(String str,String regex) {
        int sum = 0;
        for (String s : str.split("["+regex+"]")) sum += Integer.parseInt(s);
        return sum;
    }
}
