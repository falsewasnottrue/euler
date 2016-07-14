package euler;

import util.Divisors;

import java.util.ArrayList;
import java.util.List;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant
 * numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two
 * abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest
 * number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class Prob023 {

    public static void main(final String... args) {
        // Ideen
        // 1. Algorithmus Divisors
        // 2. Algorithmus deficient, abundant, perfect
        System.out.println(isAbundant(11));
        System.out.println(isAbundant(12));
        // 3. Tabelle aller abundant-Zahlen (bis N=28123)
        final int N = 28123;
        final List<Integer> abundants = new ArrayList<>();
        long duration = System.currentTimeMillis();
        for (int i=12; i<=N; i++) {
            if (isAbundant(i)) {
                abundants.add(i);
            }
        }
        duration = System.currentTimeMillis() - duration;

        System.out.println(abundants.size() + " abundants");
        System.out.println("took " + duration + " ms");

        // 4. Tabelle aller Zahlen die NICHT Summe 2. abundant Zahlen sind bis N
        final List<Integer> sums = new ArrayList<>();
        duration = System.currentTimeMillis();
//        for (int a : abundants) {
//            for (int b : abundants) {
//                if (a+b<N) {
//                    sums.add(a+b);
//                }
//            }
//        }
        for (int i=1; i<=N; i++) {
            if (notSumOfAbundants(i, abundants)) {
                sums.add(i);
            }
        }
        duration = System.currentTimeMillis() - duration;
        System.out.println("sums: " + sums.size());
        System.out.println("took " + duration + " ms");
        // 5. Summe bilden
        long sum = sums.stream().reduce(0, (a,b) -> a+b);
        System.out.println("sum: " + sum);
    }

    private static boolean isAbundant(final long n) {
        final long sum = Divisors.divisors(n).stream().reduce(0L, (acc, curr) -> acc + curr) - n;
        return sum > n;
    }

    private static boolean notSumOfAbundants(final int i, final List<Integer> abundants) {
        if (i% 1000 == 0) {
            System.out.println(i);
        }

        for (int i1 = 0; i1 < abundants.size(); i1++) {
            final int a  = abundants.get(i1);
            if (a >= i) {
                return true;
            }
            for (int i2 = i1; i2 < abundants.size(); i2++) {
                final int b = abundants.get(i2);

                if (a+b == i) {
                    return false;
                }
                if (a+b > i) {
                    continue;
                }
            }
        }
        return false;
    }
    // -> 4179871

}
