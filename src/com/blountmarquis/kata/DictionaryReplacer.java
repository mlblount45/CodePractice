package com.blountmarquis.kata;

import java.util.Map;

/**
 * Created by MLBlount on 1/18/2016.
 */
public class DictionaryReplacer {

  private static final Character KEY_IDENTIFIER = '$';

  public static String replaceText(String text, Map<String, String> dictionary) {
    if (text == null || dictionary == null) {
      throw new IllegalArgumentException();
    }
    String[] words = text.split(" ");

    if (words.length == 0) {
      return text;
    }
    return buildReplacedText(dictionary, words);
  }

  private static String buildReplacedText(Map<String, String> dictionary, String[] words) {
    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      if (isKey(word)) {
        String wordWithOutKeyIdentifier = word.replace(KEY_IDENTIFIER.toString(), "");
        if (dictionary.containsKey(wordWithOutKeyIdentifier)) {
          appendWordToOutPutText(sb, dictionary.get(wordWithOutKeyIdentifier));
        } else {
          appendWordToOutPutText(sb, word);
        }
      } else {
        appendWordToOutPutText(sb, word);
      }
    }
    return sb.toString().trim();
  }

  private static boolean isKey(String word) {
    int size = word.length();
    return size > 2 && word.charAt(0) == KEY_IDENTIFIER && word.charAt(size - 1) == KEY_IDENTIFIER;
  }

  private static void appendWordToOutPutText(StringBuilder sb, String s) {
    sb.append(s).append(" ");
  }
}
