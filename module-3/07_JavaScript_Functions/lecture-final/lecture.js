/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
function multiplyNoUndefined(firstParameter=0, secondParameter = 0) {
  return firstParameter * secondParameter;
}


function multiplyAllParameters(firstParameter=0, secondParameter=0, ...theRest) {
  let result = firstParameter * secondParameter;

  for(const element of theRest) {
    result = result * element;
  }

  return result;
}

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter === 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    let inScopeInScopeTest = false; // can redeclare, will create a copy that exists within the block

    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;

    console.log(inScopeInScopeTest);
  }

  console.log(inScopeInScopeTest);

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

// array = ['x', 'y', 'z]   -> array.join('|') -> 'x|y|z'
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {

  // let sum = 0;

  // for(const num of numbersToSum) {
  //   sum += num;
  // }

  // return sum;

  // [ 1, 2, 3, 4, 5 ] -> 1 + 2 + 3 + 4 + 5 = 15
  /*
    accumulator current
      0           1
      1           2
      3           3
      6           4
      10          5
      15
  */

  return numbersToSum.reduce((accumulator, current) => {
    return accumulator + current;
  }, 0);
}


// [ 1, 5, 2, 5, 1, 6 ] -> [ 1, 5, 2, 6 ] 
/*   ^

    accumulator   current
    []             1
    [1]            5
    [1, 5]         2
    [1, 5, 2]      5
    [1, 5, 2]      1
    [1, 5, 2]      6
    [1, 5, 2, 6] 
*/

function returnOneOfEach(numbers) {

  return numbers.reduce((accumulator, current) => {
    if( !accumulator.includes(current) ) {
      accumulator.push(number);
    }

    return accumulator;
    // is current in our array (accumulator) ?
    // if it is not -> add it
    // return the next accumulator
  }, []);

}

/*
  'Britt'
  'Dan'
  'Ty'
  'Lana'
  'Chris'
*/

function returnLongestLength(strings) {

  return strings.reduce(longest, current => {
    if(current.length > longest.length ) {
      return current;
    }

    return longest;
  })
}


/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3.
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {

  // const isDivisibleByThree = function (num) {
  //   return num % 3 === 0;
  // };

  const result = numbersToFilter.filter(num => num % 3 === 0);

  return result;

  // const result = [];

  // for(const num of numbersToFilter) {
  //   if(num % 3 === 0) {
  //     result.push(num);
  //   }
  // }

  // return result;

}


/**
 * Takes an array and returns true if all numbers are divisible by 3.
 *
 * @param {number[]} numbers array of numbers
 * @returns {boolean} true if all numbers are divisible by 3
 */
function areAllDivisibleByThree(numbers) {
  const isTrue = numbers.every(num => num % 3 === 0);
  return isTrue;
}



/**
 * Takes an array of objects and returns true if any object 
 * contains the first name Robert.
 *
 * @param {object[]} people array of people
 * @returns {boolean} true if any object has the first name Robert
 */
function hasARobert(people) {
  // return people.some((person) => {
  //   if (person.firstName === 'Robert') {
  //     return true;
  //   }

  //   return false;
  // });

  return people.some(person => person.firstName === 'Robert');
}

/**
 * Takes an array of numbers and formats them as money.
 *
 * @param {number[]} numbers array of numbers
 * @returns {number[]} an array of numbers formatted as currency $x.xx
 * 
 * 
 * [ 1, 5, 25.2 ] -> [ '$1.00', '$5.00', '$25.20' ]
 */
function toMoney(numbers) {

  // Callback functions that are provided to array methods supply more than just 
  // the first parameter that represents the element at the current iteration.
  // They also supply the index and the original array.
  numbers.map((num, index, originalArray) => {
    console.log('num: ' + num);
    console.log('index: ' + index);
    console.log(originalArray);
  })


  const moneyNumbers = numbers.map(num => '$' + num.toFixed(2));
  return moneyNumbers;
}

// method chaining

function isDivisibleByThree(num) {
  return num % 3 === 0;
}
function doubleNumber(num) {
  return num * 2;
}

function methodChaining(numbers) {

  const newArray = numbers.filter(isDivisibleByThree).map(doubleNumber);

}