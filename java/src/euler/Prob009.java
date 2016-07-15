package euler;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Prob009 {

    public static void main(final String... args) {
        for (int a=1; a<=1000; a++) {
            for (int b=a; b<=1000-a; b++) {
                int c = 1000 - a - b;

                if (a*a + b*b == c*c) {
                    System.out.println(a + ", " + b + ", " + c);
                }
            }
        }
        // 200, 375, 425
    }
}
