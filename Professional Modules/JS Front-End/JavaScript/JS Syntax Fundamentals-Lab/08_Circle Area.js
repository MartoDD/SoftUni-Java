function solve(argument){
let inputType=typeof(argument);
    if(inputType==='number'){
        let result=Math.PI * Math.pow(argument,2)
        console.log(result.toFixed(2));

    }else{
        console.log(`We can not calculate the circle area, because we receive a ${inputType}.`);
    }

}

solve(`name`);