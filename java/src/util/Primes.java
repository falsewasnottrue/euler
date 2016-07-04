package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Primes {

    public static boolean isPrime(final int n) {
        for (int i=2; i<= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static Stream<Integer> stream() {
        return Stream.generate(new Supplier<Integer>() {
            private int curr = 2;
            @Override
            public Integer get() {
                int result = curr;
                do {
                    curr++;
                } while (!isPrime(curr));
                return result;
            }
        });
    }

    public static List<Integer> factorize(final long n) {
        final List<Integer> result = new ArrayList<>();
        final Iterator<Integer> primes = stream().iterator();
        long rest = n;

        while (rest > 1) {
            int prime = primes.next();
            while (rest % prime == 0) {
                rest = rest / prime;
                result.add(prime);
            }
        }
        return result;
    }
}
