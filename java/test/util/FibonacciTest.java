package util;

import org.junit.Test;
import util.Fibonacci;

import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

public class FibonacciTest {

    @Test
    public void testStream() {
        Stream<Long> fibs = Fibonacci.stream();
        assertArrayEquals(new Long[] {1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L}, fibs.limit(10).toArray());
    }
}
