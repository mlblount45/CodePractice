package com.blountmarquis.kata;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by MLBlount on 1/18/2016.
 */
public class DictionaryReplacerTest {

  Map<String, String> dictionary;

  @Before
  public void setUp() {
    dictionary = new HashMap<String, String>() {{
      put("Wo", "World");
      put("smile", "=)");
    }};
  }

  @Test(expected = IllegalArgumentException.class)
  public void whenInputOrDictionaryNullThenThrowIllegalArgumentException() {
    assertEquals("", DictionaryReplacer.replaceText(null, null));
  }

  @Test
  public void whenInputOrDictionaryEmptyThenReturnEmptyString() {
    assertEquals("", DictionaryReplacer.replaceText("", new HashMap<String, String>()));
  }


  @Test
  public void whenInputWhiteSpaceOnlyThenReturnInputSting() {
    assertEquals("  ", DictionaryReplacer.replaceText("  ", dictionary));
  }

  @Test
  public void whenInputDoesntContainKeyThenReturnInputSting() {
    assertEquals("Hello", DictionaryReplacer.replaceText("Hello", dictionary));
  }

  @Test
  public void whenInputContainsDictKeyThenReturnValueReplacedString() {
    assertEquals("Hello World", DictionaryReplacer.replaceText("Hello $Wo$", dictionary));
  }

  @Test
  public void whenInputContainsNonDictKeyThenReturnUnReplacedKeyString() {
    assertEquals("Hello $W$", DictionaryReplacer.replaceText("Hello $W$", dictionary));
  }

  @Test
  public void whenInputContainsImproperKeyIdentifierThenReturnUnReplacedKeyString() {
    assertEquals("Hello $Wo", DictionaryReplacer.replaceText("Hello $Wo", dictionary));
  }

  @Test
  public void whenInputContainsKeyAsTextThenReturnTextUnReplaced() {
    assertEquals("Hello Wo", DictionaryReplacer.replaceText("Hello Wo", dictionary));
  }

  @Test
  public void whenInputContainsMultiKeysThenReturnReplacedSting() {
    assertEquals("Hello World =)",
        DictionaryReplacer.replaceText("Hello $Wo$ $smile$", dictionary));
  }
}
