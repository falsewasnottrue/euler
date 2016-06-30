"use strict"

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
var isPrime = function(n) {
	for (var i=2; i<=Math.sqrt(n); i++) {
		if (n % i == 0) {
			return false;
		}
	}
	return true;
}

function Sieve() {
	this.capacity = 1000;
	this.position = 1;
	this.sieve = [];
	for (var i=0; i<this.capacity; i++) {
		this.sieve[i] = true;
	}
}
Sieve.prototype.next = function() {
	do {
		this.position++;
		// TODO check capacity, resieve
	} while (!this.sieve[this.position])

	for (var i = 2 * this.position; i<this.capacity; i += this.position) {
		this.sieve[i] = false;
	}
  
	return this.position;
}

var sieve = new Sieve();
var N = 3;

for (var i=0; i<N; i++) {
	console.log(sieve.next());
}
