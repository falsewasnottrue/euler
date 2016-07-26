package euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class Prob032 {

    // Idee:
    // Iterieren über x, y bis N=100 ?
    // Prüfen ob Pandigital
    // Ergebnisse sortieren und in HashMap abspeichern
    public static void main(final String... args) {


        final Set<Integer> prods = new HashSet<>();
        final int N = 2000;
        for (int i=1; i<=N; i++) {
            for (int j=i; j<=N; j++) {
                if (testPandigital(i,j)) {
                    int p = i*j;
                    prods.add(p);
                    System.out.println(i + "*" + j + "=" + p);
                }
            }
        }
        //        4*1738=6952
        //        4*1963=7852
        //        12*483=5796
        //        18*297=5346
        //        27*198=5346
        //        28*157=4396
        //        39*186=7254
        //        42*138=5796
        //        48*159=7632

        int sum = prods.stream().reduce(0, (i, j) -> i+j);
        System.out.println(sum);
        // -> 45228
    }

    public static boolean testPandigital(int i, int j) {
        final int p = i*j;
        final List<Integer> values = new ArrayList<>();

        toValues(i, values);
        toValues(j, values);
        toValues(p, values);

        return values.size() == 9 && isPandigital(values);
    }

    public static boolean isPandigital(final List<Integer> values) {
        for (int i=1; i<=values.size(); i++) {
            if (!(values.contains(i))) {
                return false;
            }
        }
        return true;
    }

    public static void toValues(int value, List<Integer> values) {
        while (value != 0) {
            values.add(value % 10);
            value = value / 10;
        }
    }
}
