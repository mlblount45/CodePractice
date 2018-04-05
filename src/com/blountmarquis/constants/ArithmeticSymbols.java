package com.blountmarquis.constants;

/**
 * Created by MLBlount on 3/6/2015.
 */
public class ArithmeticSymbols {

  public enum Operands {
    addition("+"),
    subtraction("-"),
    division("/"),
    multiplication("*");

    public final String operand;

    Operands(String s) {
      operand = s;
    }

  }
}
