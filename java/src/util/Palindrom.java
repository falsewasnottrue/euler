package util;

public class Palindrom {

    public static boolean isPalindrom(int n) {
        String s = String.valueOf(n);
        String r = new StringBuilder(s).reverse().toString();
        return s.equals(r);
    }
}
