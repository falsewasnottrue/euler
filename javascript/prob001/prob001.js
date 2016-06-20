"use strict"

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
var divisible = function(n, k) {
	return n % k == 0;
}

// trivial solution
var limit = 1000;
var sum = 0;

for (var i=0; i<limit; i++) {
	if (divisible(i,3) || divisible(i,5)) {
		sum += i;
	}
}

console.log(sum);
// 233168

// more fp solution
var N = 1000; 
var result = Array.apply(null, {length: N}).map(Number.call, Number)
	.filter(function(n) {
		return divisible(n,3) || divisible(n,5);
	}).reduce(function(acc, curr) {
		return acc + curr;
	}, 0);

console.log(result);