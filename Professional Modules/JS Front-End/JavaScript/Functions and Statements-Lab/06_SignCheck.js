function signCheck(num){

    if(num<0){
        return `Negative`;
    }else{
        return `Positive`;
    }

}

function solve(num1,num2,num3){

return signCheck(num1) && signCheck(num2) && signCheck (num3);


}

console.log(solve(-1,
    -2,
    -3))