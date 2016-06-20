use "strict"

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
var divisible = function(n, k) {
	return n % k == 0;
}

var limit = 10;
var sum = 0;

for (var i=0; i<limit; i++) {
	if (divisible(i,3) || divisible(i,5)) {
		sum += i;
	}
}

console.log(sum);