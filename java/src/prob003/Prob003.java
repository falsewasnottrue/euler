package prob003;

import util.Primes;

import java.util.List;
import java.util.stream.Stream;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Prob003 {

    public static void main(String... args) {
        Stream<Integer> primes = Primes.stream();
        primes.limit(10).forEach(System.out::println);

        List<Integer> fs = Primes.factorize(600851475143l);
        System.out.println(fs);
        // -> 6857
    }
}
