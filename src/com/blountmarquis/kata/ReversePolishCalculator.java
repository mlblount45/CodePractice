package com.blountmarquis.kata;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by mlblount on 1/24/2016.
 */
public class ReversePolishCalculator {

    private static Set<String> ops = new HashSet<String>(){{
        add("+");add("*");add("-");add("/");
    }};

    public static Double evaluate(String s) {
        if(s.isEmpty()) return 0.0;
        if(s.length() == 1) return Double.parseDouble(s);

        String[] content = s.split(" ");
        Stack<Double> nums = new Stack<>();
        for(int i = 0; i < content.length; i++) {
            if (ops.contains(content[i])) {
                Double eval = getEvaluation(nums.pop(),nums.pop(), content[i]);
                nums.push(eval);
            } else{
                nums.push(Double.parseDouble(content[i]));
            }
        }
        return nums.pop();
    }

    private static Double getEvaluation(Double num1, Double num2, String oper) {
        if(oper.equals("+")) return num1 + num2;
        else if(oper.equals("*")) return num1 * num2;
        else if(oper.equals("/")) return num2 /  num1;
        else if(oper.equals("-")) return num2 -  num1;
        else return Double.MAX_VALUE;
    }
}
