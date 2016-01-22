package com.blountmarquis.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mlblount on 1/19/2016.
 */
public class CodeBreakerMarkerTest {

    @Test
    public void whenCodeOrGuessEmptyReturnEmptyMarker(){
        assertEquals("", CodeBreakerMarker.getMarker("rbgy", ""));
    }

    @Test
    public void whenOneColorMatchedInWrongPlaceMentThenReturnW(){
        assertEquals("w", CodeBreakerMarker.getMarker("rbgy", "yccc"));
    }

    @Test
    public void whenTwoColorMatchedInWrongPlaceMentThenReturnWW(){
        assertEquals("ww", CodeBreakerMarker.getMarker("rbgy", "ygcc"));
    }
    @Test
    public void whenThreeColorMatchedInWrongPlaceMentThenReturnWWW(){
        assertEquals("www", CodeBreakerMarker.getMarker("rbgy", "ygbc"));
    }

    @Test
    public void whenFourColorMatchedInWrongPlaceMentThenReturnWWWW(){
        assertEquals("wwww", CodeBreakerMarker.getMarker("rbgy", "ygbr"));
    }

    @Test
    public void whenOneColorMatchedInCorrectPlaceMentThenReturnB(){
        assertEquals("b", CodeBreakerMarker.getMarker("rbgy", "rccc"));
    }

    @Test
    public void whenTwoColorMatchedInCorrectPlacementThenReturnBB(){
        assertEquals("bb", CodeBreakerMarker.getMarker("rbgy", "rbcc"));
    }

    @Test
    public void whenThreeColorMatchedInCorrectPlacementThenReturnBBB(){
        assertEquals("bbb", CodeBreakerMarker.getMarker("rbgy", "rbgc"));
    }

    @Test
    public void whenFourColorMatchedInCorrectPlacementThenReturnBBBB(){
        assertEquals("bbbb", CodeBreakerMarker.getMarker("rbgy", "rbgy"));
    }

    @Test
    public void whenTwoMatchedCorrectlyAndTwoIncorrectlyThenReturnBBWW(){
        assertEquals("bbww", CodeBreakerMarker.getMarker("rbgy", "ybgr"));
    }
}
