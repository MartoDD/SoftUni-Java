function solve (num1,num2,num3){

    function sum(num1,num2){
        return num1+num2;
    }

    function subtract(num1,num2,num3){
        return sum(num1,num2)-num3;
    }

    return subtract(num1,num2,num3);

}

console.log(solve(1,
    17,
    30))