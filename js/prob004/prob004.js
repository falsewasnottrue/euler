"use strict";

/**
  A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
  Find the largest palindrome made from the product of two 3-digit numbers.
*/

String.prototype.reverse = function () {
    return this.split("").reverse().join("");
}

var isPalindrom = function(n, k) {
	// Optimierungsidee: n+k % (1)lange von k == 0
	// z.B. 123 + 321 = 444 % 111 == 0
	var s = n.toString();
	return s === s.reverse();
}

var max = 0;
for (var i=100; i<1000; i++) {
	for (var j=100; j<1000; j++) {
		var k = i*j;
		if (k > max && isPalindrom(k)) {
			console.log(i + " * " + j + " = " + k);
			max = k;
		}
	}
}
// -> 913 * 993 = 906609