package euler;

import util.MultiSet;
import util.Primes;

import java.util.ArrayList;
import java.util.List;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Prob005 {

    public static void main(String... args) {
        final int N = 20;

        final List<Integer> is = new ArrayList<>();
        for (int i=0; i<N; i++) {
            is.add(i);
        }

        final MultiSet<Integer> factors = is.stream().
                map(Primes::factorize).
                map(MultiSet<Integer>::new).
                reduce(new MultiSet<>(), (a,b) -> a.union(b, Math::max));

        Integer result = 1;
        for (final Integer factor : factors.elements()) {
            result *= (int)Math.pow(factor, factors.get(factor));
        }

        System.out.println(result);
        // -> 232792560
    }
}
