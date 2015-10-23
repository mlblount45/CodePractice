package com.blountmarquis.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by MLBlount on 7/4/2015.
 */
@Deprecated
public class LeetCode_SubStringConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words == null) return new ArrayList();
        List<Integer> list = new ArrayList<Integer>();
        int size = words.length * words[0].length();
        int i = 0;
        int j = size;

        Set<String> set = populateSet(words);
        while(i < s.length() && j <= s.length()){
            if(isConcatenatedSubString(s.substring(i,j),set, words[0].length())){
                list.add(i);
                i += words[0].length();
                j += words[0].length();
            }else{
                i++;
                j++;
            }
        }
        return list;
    }

    private HashSet<String> populateSet(String[] words){
        HashSet<String> set = new HashSet<String>();
        perm(set, new String[]{}, words);
        return set;
    }

    private void perm(HashSet<String> set, String[] seen, String[] unseen) {
        if(unseen.length == 0) {
            StringBuilder sb = new StringBuilder();
        }
    }

    private boolean isConcatenatedSubString(String s, Set<String> set, int size){
        int i = 0;
        int j = size;
        while(i < s.length() && j <= s.length()){
            if(!set.contains(s.substring(i,j))) return false;
            i+=size;
            j+=size;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_SubStringConcatenation obj = new LeetCode_SubStringConcatenation();
        List<Integer> list = obj.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        for (int i: list) {
            System.out.print(i + " ");
        }
    }
}
