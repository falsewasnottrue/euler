package util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DivisorsTest {

    @Test
    public void testDivisors() {
        assertEquals(Arrays.asList(1L,2L,3L,4L,6L,12L), Divisors.divisors(12));
    }
}
