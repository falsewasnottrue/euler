package euler;

import util.Primes;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
public class Prob007 {

    public static void main(final String... args) {
        final int n = 10001;

        Primes.stream().skip(n-1).limit(1).forEach(System.out::println);
        // -> 104743
    }

}
