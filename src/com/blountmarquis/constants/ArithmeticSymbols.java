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

        Operands(String s) {
            operand = s;
        }

        public final String operand;

    }
}
