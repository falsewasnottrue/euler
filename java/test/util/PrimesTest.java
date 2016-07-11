package util;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class PrimesTest {

    @Test
    public void testDivisors() {
        assertEquals(new HashSet<>(Arrays.asList(1)), Primes.divisors(1));
        assertEquals(new HashSet<>(Arrays.asList(1,3)), Primes.divisors(3));
        assertEquals(new HashSet<>(Arrays.asList(1,2,3,6)), Primes.divisors(6));
        assertEquals(new HashSet<>(Arrays.asList(1,2,5,10)), Primes.divisors(10));
        assertEquals(new HashSet<>(Arrays.asList(1,3,5,15)), Primes.divisors(15));
        assertEquals(new HashSet<>(Arrays.asList(1,3,7,21)), Primes.divisors(21));
        assertEquals(new HashSet<>(Arrays.asList(1,2,4,7,14,28)), Primes.divisors(28));
    }
}
