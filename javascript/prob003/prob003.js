"use strict";

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */

// 1. Prime-Stream

var isPrime = function(n) {
	if (n < 2) {
		return false;
	}
	for (var i = 2; i<=Math.sqrt(n); i++) {
		// console.log(i);
		if (n % i == 0) {
			return false;
		}
	}
	return true;
}

// console.log(isPrime(1));
// console.log(isPrime(2));
// console.log(isPrime(4));
// console.log(isPrime(79));

var nextPrime = function(n) {
	if (isPrime(n+1)) {
		return n+1;
	} else {
		return nextPrime(n+1);
	}
}

// console.log(nextPrime(0));
// console.log(nextPrime(2));
// console.log(nextPrime(3));
// console.log(nextPrime(93));

// 2. find prime factors for n
var primeFactors = function(n, fs) {
	if (n == 1) {
		return fs;
	}
	for (var i = 2; i<=Math.sqrt(n); i++) { 
  		// console.log(i);
		if (isPrime(i) && n % i == 0) {
      		fs.push(i);
			return primeFactors(n/i, fs);
		}
	}
	fs.push(n);
	return fs;
}

// console.log(primeFactors(2, []));
// console.log(primeFactors(3, []));
// console.log(primeFactors(4, []));
// console.log(primeFactors(93, []));
// console.log(primeFactors(13195, []));

// 3. result for 600851475143