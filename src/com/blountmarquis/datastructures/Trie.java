package com.blountmarquis.datastructures;

/**
 * Created by mlblount on 8/23/2015.
 */
class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}

/**
 * This Trie representation is designed to handle the english alphabet set of lowercase letters i.e a-z. This
 * implementation could be expanded to a larger language set by using a HashMap<Character,TrieNode> instead of using
 * TrieNode[26] array.
 * <p/>
 * The Trie Data Structure can be used to solve the following tasks:
 * <br/>
 * 1. Finding a word in a long text body <br/>
 * 2. Finding a prefix in a long text body <br/>
 * 3. Finding the longest prefix of two strings.<br/>
 *
 */
public class Trie {
    private TrieNode root = new TrieNode();

    /**
     * Insert word into Trie. Each Parent has a pointer to all of its children. each child has a designated location
     * in the "children" array.
     *
     * @param word
     */
    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /**
     * Returns true if and only if there exist a word in the Trie that matches the String word. search differs from
     * search in that search must match an entire word, where as startsWith only needs the prefix to exist in the trie
     *
     * @param word word to be match
     * @return true if and only if there exist a word in the Trie that matches the String word.
     */
    public boolean search(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    /**
     *  Returns true if and only if there is a word in the trie that starts with the given prefix. startsWith differs
     *  from search in that startsWith does not need to match an entire word as long as the entire prefix string exist
     *  true is returned
     * @param prefix String to be match
     * @return true if and only if there exist a word in the Trie that matches the String word.
     */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}
