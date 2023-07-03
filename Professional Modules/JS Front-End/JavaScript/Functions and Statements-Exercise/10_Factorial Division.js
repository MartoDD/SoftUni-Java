function factorial(num1,num2){

function calculateFactorial(num){

    let result=1;

    for (let i=num; i>0; i--){
        result=result*i;
    }

    return result;
}
let output=calculateFactorial(num1)/calculateFactorial(num2)
console.log(output.toFixed(2))

}

factorial(6,2)