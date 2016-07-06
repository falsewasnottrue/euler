package euler;

import util.Primes;

import java.util.Iterator;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
public class Prob010 {

    public static void main(String... args) {
        final int limit = 2000000;
        long result = 0;

        final Iterator<Integer> primes = Primes.stream().iterator();
        int prime = primes.next();
        while (prime < limit) {
            result += prime;
            prime = primes.next();
        }

        System.out.println(result);
        // 142913828922
    }
}
