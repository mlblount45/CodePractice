package com.blountmarquis.HackerRank;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by mlblount on 3/9/2016.
 */
public class JavaBitSet {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();

    BitSet bitSet1 = new BitSet(m);
    BitSet bitSet2 = new BitSet(m);
    for (int i = 0; i < n; i++) {
      in.nextLine();
      manipulateBits(in, bitSet1, bitSet2);
      printSetBits(bitSet1, bitSet2);
    }
  }

  private static void manipulateBits(Scanner in, BitSet bitSet1, BitSet bitSet2) {
    String operand = in.next();
    int leftOperand = in.nextInt();
    int rightOperand = in.nextInt();

    if (isAndOrXorOperand(operand)) {
      if (leftOperand == 1) {
        andOrXorOperationBitManipulation(operand, bitSet1, bitSet2);
      } else {
        andOrXorOperationBitManipulation(operand, bitSet2, bitSet1);
      }
    } else {
      if (leftOperand == 1) {
        flipSetBitManipulation(operand, rightOperand, bitSet1);
      } else {
        flipSetBitManipulation(operand, rightOperand, bitSet2);
      }
    }
  }

  private static boolean isAndOrXorOperand(String operand) {
    return operand.equals("AND") || operand.equals("OR") || operand.equals("XOR");
  }

  private static void andOrXorOperationBitManipulation(String operand, BitSet leftOperand,
      BitSet rightOperand) {
    switch (operand) {
      case "AND": {
        leftOperand.and(rightOperand);
        break;
      }
      case "OR": {
        leftOperand.or(rightOperand);
        break;
      }
      case "XOR": {
        leftOperand.xor(rightOperand);
        break;
      }
      default:
        break;
    }
  }

  private static void flipSetBitManipulation(String operand, int index, BitSet set) {
    switch (operand) {
      case "FLIP": {
        set.flip(index);
        break;
      }
      case "SET": {
        set.set(index);
        break;
      }
      default:
        break;
    }
  }

  private static void printSetBits(BitSet bitSet1, BitSet bitSet2) {
    System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
  }
}
