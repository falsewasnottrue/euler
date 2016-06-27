
 "use strict";

/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

// Prime helpers
var isPrime = function(n) {
	if (n < 2) {
		return false;
	}
	for (var i = 2; i<=Math.sqrt(n); i++) {
		if (n % i == 0) {
			return false;
		}
	}
	return true;
}


var nextPrime = function(n) {
	if (isPrime(n+1)) {
		return n+1;
	} else {
		return nextPrime(n+1);
	}
}

var primeFactors = function(n, fs) {
	if (n == 1) {
		return fs;
	}
	for (var i = 2; i<=Math.sqrt(n); i++) { 
  		if (isPrime(i) && n % i == 0) {
      		fs.push(i);
			return primeFactors(n/i, fs);
		}
	}
	fs.push(n);
	return fs;
}

var counts = function(arr) {
	var result = {};
	for (var i=0; i<arr.length; i++) {
		var num = arr[i];
		result[num] = result[num] ? result[num]+1 : 1;
	}

	return result;
}

var merge = function(cs1, cs2) {
	var result = {};
	for (var attr in cs1) {
		if (cs1.hasOwnProperty(attr)) {
			result[attr] = result[attr] ? Math.max(result[attr], cs1[attr]) : cs1[attr]
		}
	}
	for (var attr in cs2) {
		if (cs2.hasOwnProperty(attr)) {
			result[attr] = result[attr] ? Math.max(result[attr], cs2[attr]) : cs2[attr]
		}
	}

	return result;
}

var N = 20;
var maps = [];

// determine prime factors
for (var i=2; i<=N; i++) {
	var pfs = primeFactors(i, []);

	// build map [prime -> #count]
	var m = counts(pfs);

	maps.push(m);
}

// create map with maximum count of prime factors
var maxUnion = maps.reduce(function(acc, m) {
	return merge(acc, m);
}, {});

// multiply primefactors
var result = Object.keys(maxUnion).reduce(function(acc, key) {
	var count = maxUnion[key]
	return acc * Math.pow(key, count);
}, 1);
console.log(result);
// -> 232792560

