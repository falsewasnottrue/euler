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
	this.sieve[0] = false;
	this.sieve[1] = false;
}
Sieve.prototype.next = function() {
	do {
		this.position++;
		if (this.position == this.capacity) {
			this.resieve();
		}
	} while (!this.sieve[this.position])

	for (var i = 2 * this.position; i<this.capacity; i += this.position) {
		this.sieve[i] = false;
	}
  
	return this.position;
}
Sieve.prototype.resieve = function() {
	var newCapacity = 2 * this.capacity;
	
	for (var i=this.capacity; i<newCapacity; i++) {
		this.sieve[i] = true;
	}
	for (var i=2; i<this.capacity; i++) {
		if (this.sieve[i]) {
			for (var j=2*i; j<newCapacity; j+=i) {
				this.sieve[j] = false;
			}
		}
	}

	this.capacity = newCapacity;
}

var sieve = new Sieve();
var N = 10001;

for (var i=0; i<N; i++) {
	console.log(sieve.next());
}
// -> 104743
