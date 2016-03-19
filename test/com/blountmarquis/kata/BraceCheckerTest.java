package com.blountmarquis.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mlblount on 1/23/2016.
 */
public class BraceCheckerTest {

    @Test
    public void whenSingleValidParenthesThenReturnTrue() {
        assertEquals(true, isBracesValid("()"));
    }

    @Test
    public void whenSingleValidBracketsThenReturnTrue() {
        assertEquals(true, isBracesValid("[]"));
    }


    @Test
    public void whenSingleInvalidParentheGivenThenReturnTrue() {
        assertEquals(false, isBracesValid("(()"));
    }

    @Test
    public void whenDoubleValidParentheGivenThenReturnTrue() {
        assertEquals(true, isBracesValid("()()"));
    }

    @Test
    public void whenDoubleValidBracketsGivenThenReturnTrue() {
        assertEquals(true, isBracesValid("[][]"));
    }

    @Test
    public void whenDoubleValidParentheEnclosedInParentheseThenReturnTrue() {
        assertEquals(true, isBracesValid("(()())"));
    }

    @Test
    public void whenDoubleValidParentheEnclosedInBracketsThenReturnTrue() {
        assertEquals(true, isBracesValid("[()()]"));
    }

    @Test
    public void whenInValidParentheEnclosedInMultipleParentheseThenReturnTrue() {
        assertEquals(false, isBracesValid("(((()()))"));
    }

    @Test
    public void whenValidCurlyBracesEnclosedInCurlyBracesThenReturnTrue() {
        assertEquals(true, isBracesValid("{{}{}}"));
    }

    @Test
    public void whenAllAllowedBracesValidThenReturnTrue() {
        assertEquals(true, isBracesValid("[]{}()"));
    }

    @Test
    public void whenBracesEnclosedInsideOfOtherThenReturnTrue() {
        assertEquals(true, isBracesValid("([{}])"));
    }

    @Test
    public void whenInvalidSinglePairThenReturnFalse() {
        assertEquals(false, isBracesValid("{)"));
    }

    @Test
    public void whenMultipleNonClosedThenReturnFalse() {
        assertEquals(false, isBracesValid("[(])"));
    }

    @Test
    public void whenMultipleClosedThenReturnTrue() {
        assertEquals(true, isBracesValid("([{}({})[]])"));
    }

    @Test
    public void whenSingleBraceThenReturnFalse(){
        assertEquals(false,isBracesValid("{"));
    }

    @Test
    public void whenExclusivelyEnclosedValidBracesThenReturnTrue() {
        assertEquals(true,isBracesValid("({})[({})]"));
    }

    private boolean isBracesValid(String par) {return BraceChecker.isValid(par);}


}
