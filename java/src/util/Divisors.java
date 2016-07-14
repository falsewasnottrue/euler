package util;

import java.util.ArrayList;
import java.util.List;

public class Divisors {

    // naive implementation for now
    public static List<Long> divisors(final long n) {
        final List<Long> result = new ArrayList<>();
        for (long i=1; i<=n; i++) {
            if (n % i == 0) {
                result.add(i);
            }
        }

        return result;
    }
}
