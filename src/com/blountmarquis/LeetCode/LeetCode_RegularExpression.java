package com.blountmarquis.LeetCode;

/**
 *
 * not implemented correctly has bugs
 * Created by MLBlount on 7/4/2015.
 */
@Deprecated
public class LeetCode_RegularExpression {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) return true;
        int i = 0, j = 0;
        char matchChar;
        for(;;){
            if(i >= s.length() && j >= p.length()) return true;
            else if(j + 1 < p.length() && isWildCharacter(p.charAt(j+1))){
                if(i < s.length() && isMatchAny(p.charAt(j))){
                    while (i < s.length()) {
                        if(isMatch(s.substring(i), p.substring(j + 2)))
                            return  true;
                        i++;
                    }
                }else{
                    matchChar = p.charAt(j);
                    while (i < s.length() && s.charAt(i) == matchChar) i++;
                    j += 2;
                }
            }else if(j < p.length() && isMatchAny(p.charAt(j))){
                j++;  i++;
            }else if(i < s.length() && j < p.length() && s.charAt(i) == p.charAt(j)) {
                i++; j++;
            }else{
                return false;
            }
        }
    }

    private boolean isMatchAny(char c) {
        return c=='.';
    }

    private boolean isWildCharacter(char c) {
        return c == '*';
    }

    public static void main(String[] args) {
        LeetCode_RegularExpression leetCode_RegularExpression = new LeetCode_RegularExpression();
        System.out.println("is match: " + leetCode_RegularExpression.isMatch("aaa", "a*a"));
    }
}
