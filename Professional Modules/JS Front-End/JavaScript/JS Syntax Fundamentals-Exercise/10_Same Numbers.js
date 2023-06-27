function solve(number){
    let string=number.toString();
    let isTheSame=true;
    let sum=Number(string[0]);
    for(let i=1; i<string.length; i++){

        if(string[i]!==string[i-1]){
            isTheSame=false;
        }
    sum+=Number(string[i])
    }

    console.log(isTheSame)
    console.log(sum)

}

solve(1234)