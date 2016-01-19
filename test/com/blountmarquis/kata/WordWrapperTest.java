package com.blountmarquis.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by MLBlount on 1/19/2016.
 */
public class WordWrapperTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenInputTextIsNullThenThrowIllegalArgumentException(){
        assertEquals("", WordWrapper.wrap(null, 0));
    }

    @Test
    public void whenInputTextIsEmptyThenReturnEmptyText(){
        assertEquals("", WordWrapper.wrap("", 0));
    }

    @Test
    public void whenInputLengthLessThanColumnMaxThenReturnInput(){
        assertEquals("aaa", WordWrapper.wrap("aaa", 100));
    }

    @Test
    public void whenInputTextEachWordSizeOfColoumnThenReturnTextWithLineBreakAfterEachWord(){
        assertEquals("a\na\na", WordWrapper.wrap("a a a", 2));
    }

    @Test
    public void whenMultipleWordsFitOnSingleLineThenReturnTextWithLineBreaksAfterMaxSize(){
        assertEquals("a a\na", WordWrapper.wrap("a a a", 3));
    }
}
