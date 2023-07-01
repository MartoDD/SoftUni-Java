const multiply = (a,b)=> a * b;
const divide = (a,b)=> a / b;
const add = (a,b)=> a + b;
const subtract = (a,b)=> a - b;


function simpleCalculator(num1,num2,operator){

let result;

switch (operator){
    case `multiply`:
        result= multiply(num1,num2);
        break;
    case `divide`:
        result= mdivide(num1,num2);
        break;
    case `add`:
        result= madd(num1,num2);
        break;
    case `subtract`:
        result= msubtract(num1,num2);
        break;
}

console.log(result)

}

simpleCalculator(5,
    5,
    'multiply');