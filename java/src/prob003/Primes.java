package prob003;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Primes {

    public static boolean isPrime(final Integer n) {
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
}
