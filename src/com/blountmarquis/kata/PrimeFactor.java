package com.blountmarquis.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MLBlount on 1/21/2016.
 */
public class PrimeFactor {

    public static List<Integer> generate(int num) {
        List<Integer> primes = new ArrayList<>();
        if (num < 2) return primes;
        int currentPrime = 2;
        while (num > 1) {
            while(num % currentPrime == 0){
                primes.add(currentPrime);
                num /= currentPrime;
            }
            currentPrime++;
        }

        return primes;
    }
}
