package com.blountmarquis.kata;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by mlblount on 1/23/2016.
 */
public class BraceChecker {

    private static HashMap<Character,Character> popChars = new HashMap<Character, Character>(){{
        put(')','(');put(']','[');put('}','{');
    }};

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (popChars.containsKey(c)) {
                if(stack.isEmpty()) return false;
                if(stack.pop() != popChars.get(c)) return false;
            }else
                stack.push(c);
        }
        return stack.isEmpty();
    }

}
