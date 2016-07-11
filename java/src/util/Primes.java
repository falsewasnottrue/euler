package util;

import java.util.*;
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

    public static Set<Integer> divisors(final long n) {
        final List<Integer> factors = factorize(n);
        final Set<Integer> result = new HashSet<>(factors);
        result.add(1);
        for (List<Integer> subset : subsets(factors)) {
            int divisor = subset.stream().reduce(1, (acc, i) -> acc * i);
            result.add(divisor);
        }

        return result;
    }

    private static <T> List<List<T>> subsets(final List<T> is) {
        List<List<T>> result = new ArrayList<>();
        if (is.isEmpty()) {
            result.add(new ArrayList<>());
        } else {
            for (int pos = 0; pos<is.size(); pos++) {
                final T i = is.get(pos);
                final List<T> others = listWithout(is, pos);

                final List<List<T>> otherSubsets = subsets(others);

                for (List<T> otherSubset : otherSubsets) {
                    result.add(otherSubset);

                    final List<T> withSubset = new ArrayList<T>();
                    withSubset.addAll(otherSubset);
                    withSubset.add(i);
                    result.add(withSubset);
                }
            }
        }

        return result;
    }

    private static <T> List<T> listWithout(final List<T> original, int pos) {
        final List<T> result = new ArrayList<T>();
        result.addAll(original.subList(0, pos));
        result.addAll(original.subList(pos+1, original.size()));

        return result;
    }
}
