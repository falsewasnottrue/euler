package prob004;

import util.Palindrom;

public class Prob004 {

    /**
     * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
     * Find the largest palindrome made from the product of two 3-digit numbers.
     */
    public static void main(String... args) {

        int max = 0;
        for (int i=100; i<1000; i++) {
            for (int j=100; j<1000; j++) {
                int k = i*j;
                if (k > max && Palindrom.isPalindrom(k)) {
                    System.out.println(i + " * " + j + " = " +k);
                    max = k;
                }
            }
        }

        // 913 * 993 = 906609
    }
}
