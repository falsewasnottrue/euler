package euler;

import util.Primes;

import java.util.HashSet;
import java.util.Set;

/**
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * Let us list the factors of the first seven triangle numbers:
 *
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 * We can see that 28 is the first triangle number to have over five divisors.
 *
 * What is the value of the first triangle number to have over five hundred divisors?
 */
public class Prob012 {

    public static void main(final String... args) {

        final int divCount = 100;
        boolean found = false;
        long current = 1;
        long step = 2;
        int max = 0;

        while (!found) {
            long now = System.currentTimeMillis();
            int divisors = Primes.divisors(current).size();
            long duration = System.currentTimeMillis() - now;

            if (divisors > max) {
                max = divisors;
                System.out.println("new max: " + max);
            }

            if (divisors >= divCount) {
                found = true;
                System.out.println(current + ": " + divisors);
            }

            current += step;
            step += 1;

            if (step % 100 == 0) {
                System.out.println("current: " + current);
                System.out.println(" divisors duration: " + duration);
            }
        }
    }
}