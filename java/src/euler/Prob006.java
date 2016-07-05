package euler;

import java.math.BigInteger;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Prob006 {

    public static void main(String... args) {
        final int N = 100;

        BigInteger sumOfSquares = BigInteger.ZERO;
        for (int i=1; i<=N; i++) {
            sumOfSquares = sumOfSquares.add(BigInteger.valueOf(i*i));
        }

        BigInteger squareOfSums = BigInteger.ZERO;
        for (int i=1; i<=N; i++) {
            squareOfSums = squareOfSums.add(BigInteger.valueOf(i));
        }
        squareOfSums = squareOfSums.multiply(squareOfSums);

        final BigInteger result = squareOfSums.subtract(sumOfSquares);
        System.out.println(result);
        // -> 25164150
    }
}
