package com.blountmarquis.InterviewQuestions.StringManipulation;

/**
 * Created by MLBlount on 4/19/2015.
 */
public class MultipleSpaceRemover {

    public static String removeMultipleSpaces(String str){
        if (str == null) return null;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                sb.append(' ');
                while(i < str.length() - 1 && str.charAt(i+1) == ' '){
                    i++;
                }
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s = "H E L  L              ";
        System.out.println("String without unneccesary whitespace " + removeMultipleSpaces(s) + "|");
    }
}
