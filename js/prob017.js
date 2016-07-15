"use strict"

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 */

var points = {};
points["1"] = "one"
points["2"] = "two"
points["3"] = "three"
points["4"] = "four"
points["5"] = "five"
points["6"] = "six"
points["7"] = "seven"
points["8"] = "eight"
points["9"] = "nine"
points["10"] = "ten"
points["11"] = "eleven"
points["12"] = "twelve"
points["13"] = "thirteen"
points["14"] = "fourteen"
points["15"] = "fifteen"
points["16"] = "sixteen"
points["17"] = "seventeen"
points["18"] = "eighteen"
points["19"] = "nineteen"
points["20"] = "twenty"
points["30"] = "thirty"
points["40"] = "forty"
points["50"] = "fifty"
points["60"] = "sixty"
points["70"] = "seventy"
points["80"] = "eighty"
points["90"] = "ninety"
points["100"] = "hundred"


function text(n) { 
  if (n==1000) {
    return "one thousand";
  } else {
    var hundreds = Math.floor(n / 100);
    var tens = Math.floor((n-hundreds*100) / 10);
    var ones = (n-hundreds*100-tens*10);

    console.log(n + " -> " + hundreds + ", " + tens + ", " + ones);

    var result = "";
    if (hundreds > 0) {
    	result += points[hundreds] + points["100"] + "and"
    }

    if (tens > 1) {
    	result += points[tens * 10] + points[ones]
    } else if (tens == 1) {
    	result += points[tens * 10 + ones];
    } else if (tens == 0) {
    	result += points[ones];
    }

    return result;
  }
}

console.log(text(231));
console.log(text(17));
console.log(text(2));
console.log(text(181));
console.log(text(413));