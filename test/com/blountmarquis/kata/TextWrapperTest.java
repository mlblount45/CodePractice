package com.blountmarquis.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mlblount on 1/19/2016.
 */
public class TextWrapperTest {

    @Test
    public void whenTextIsEmptyThenReturnBlankText(){
        assertEquals("", TextWrapper.wrap("", 0));
    }

    @Test
    public void whenTextShorterThenColumnThenReturnText(){
        assertEquals("abc", TextWrapper.wrap("abc", 5));
    }

    @Test
    public void whenNonSpaceTextLongerThanColumnThenSplitAtColumnLength(){
        assertEquals("ab\nc", TextWrapper.wrap("abc", 2));
    }

    @Test
    public void whenTextLongerThanColumnThenSplitTextMultipleTimes(){
        assertEquals("ab\nca\nbc", TextWrapper.wrap("abcabc", 2));
    }

    @Test
    public void whenSpaceAtColumnMaxThenReplaceSpaceWithLineBreak(){
        assertEquals("ab\nc", TextWrapper.wrap("ab c", 2));
    }

    @Test
    public void whenSpaceBeforeColumnThenBreakAtPreviousSpace(){
        assertEquals("abc\nbca", TextWrapper.wrap("abc bca", 5));
    }

    @Test
    public void whenSpaceAfterNewLineBreakThenIgnoreStartingSpaceOneNewLIne(){
        assertEquals("abc\nd\nbca", TextWrapper.wrap("abcd bca", 3));
    }

}
