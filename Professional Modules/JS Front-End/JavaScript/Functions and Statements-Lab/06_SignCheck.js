function signCheck(num){

    if(num<0){
        return `Negative`;
    }else{
        return `Positive`;
    }

}

function solve(num1,num2,num3){

if(num1*num2*num3<0){
    return `Negative`;
}else{
    return `Positive`
}

}

console.log(solve(-1,
    -2,
    -3))