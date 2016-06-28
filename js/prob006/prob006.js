"use strict";

/*
The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

var N = 10;
var sumOfSquares = 0;

for (var i=1; i<=N; i++) {
	sumOfSquares += i*i
}
console.log(sumOfSquares);

var squaredSum = Math.pow(((N+1) * N) / 2, 2);
console.log(squaredSum);

var result = squaredSum - sumOfSquares;
console.log(result);
// -> 25164150