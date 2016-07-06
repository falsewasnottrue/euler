package util;

public class Palindrom {

    public static boolean isPalindrom(int n) {
        return isPalindrom(String.valueOf(n));
    }

    public static boolean isPalindrom(final String s) {
        String r = new StringBuilder(s).reverse().toString();
        return s.equals(r);
    }
}
