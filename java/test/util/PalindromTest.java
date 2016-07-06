package util;

import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromTest {

    @Test
    public void testTrue()  {
        assertTrue(Palindrom.isPalindrom(0));
        assertTrue(Palindrom.isPalindrom(11));
        assertTrue(Palindrom.isPalindrom(1001));
        assertTrue(Palindrom.isPalindrom(10001));
        assertTrue(Palindrom.isPalindrom(1234554321));
    }

    @Test
    public void testFalse()  {
        assertFalse(Palindrom.isPalindrom(12));
        assertFalse(Palindrom.isPalindrom(1002));
        assertFalse(Palindrom.isPalindrom(10011));
        assertFalse(Palindrom.isPalindrom(1234564321));
    }
}
