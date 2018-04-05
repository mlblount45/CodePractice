package com.blountmarquis.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Suffix Trees is a Trie which contains all the suffixes of a Text as words in your Trie. Additionally Suffix Trees
 * keep track of the starting indices(from the original text) of each of its suffixes. if you wanted to index the
 * string banana in a suffix tree, you would build a Trie which would consist of the following strings:
 * <p>
 * 1. banana <br/>
 * 2. anana <br/>
 * 3. nana<br/>
 * 4. ana<br/>
 * 5. na<br/>
 * 6. a<br/>
 * </p>
 *
 *
 * Suffix trees are space intensive since each suffix is represented in the Trie.
 * An alternative suffix trees are suffix arrays which is more space efficient.
 *
 * <p/>
 * The construction of such a tree for the string S takes time and space linear in the length of S.
 * Once constructed, several operations can be performed quickly.
 * <p/>
 * Suffix Trees can be used to complete the following task:
 * 1. Locating all of a substring's index in a long text S
 * 2. Locating a substring if a certain amount of mistakes are allowing (wildcard search).
 * 3. Longest common substring done in linear time complexity.
 *
 * Created by mlblount on 10/6/2015.
 */
public class SuffixTree {

  SuffixTreeNode root = new SuffixTreeNode();

  public SuffixTree(String s) {
    for (int i = 0; i < s.length(); i++) {
      String suffix = s.substring(i);
      root.insertString(suffix, i);
    }
  }

  public ArrayList<Integer> getIndexes(String s) {
    return root.getIndexes(s);
  }


  public class SuffixTreeNode {

    HashMap<Character, SuffixTreeNode> children = new HashMap<>();
    ArrayList<Integer> indexes = new ArrayList<>();

    /**
     * Builds the suffix tree by recursively adding each character of String "s" to the suffix trie. Each parent
     * SuffixTreeNode has a pointer to its child nodes. The index is added to the indices list which is responsible
     * for recording the start of each suffix.
     */
    public void insertString(String s, int index) {
      indexes.add(index);
      if (s != null && s.length() > 0) {
        char value = s.charAt(0);
        SuffixTreeNode child;
        if (children.containsKey(value)) {
          child = children.get(value);
        } else {
          child = new SuffixTreeNode();
          children.put(value, child);
        }
        String remainder = s.substring(1);
        child.insertString(remainder, index);
      }
    }

    /**
     * Return the index list of suffix s. That is return the list of all indices where suffix s appears
     * in the original text. As an example with the original text "BANANA" and suffix s of "ana" the
     * returned suffix indices should be the list [1,5].
     *
     * This list is obtained by recursively traversing down the Tree of each child element in suffix s.
     * once the last child is seen that is represented in the suffix s return that child's indices list.
     */
    public ArrayList<Integer> getIndexes(String s) {
      if (s == null || s.length() == 0) {
        return indexes;
      }
      char first = s.charAt(0);
      if (children.containsKey(first)) {
        String remainder = s.substring(1);
        return children.get(first).getIndexes(remainder);
      }
      return null;
    }
  }
}
