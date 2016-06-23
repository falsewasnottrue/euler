package prob002;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Fibonacci {

    public static Stream<Long> stream() {
        return Stream.generate(new Supplier<Long>() {
            private long n1 = 1;
            private long n2 = 2;

            @Override
            public Long get() {
                final long fib = n1;
                final long n3 = n1 + n2;
                n1 = n2;
                n2 = n3;

                return fib;
            }
        });
    }
}
