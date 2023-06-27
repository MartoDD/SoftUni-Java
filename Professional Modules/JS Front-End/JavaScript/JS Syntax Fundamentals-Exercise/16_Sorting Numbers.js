function solve(arr){


    let sortedArray=arr.sort((a,b)=> a-b);
    let lengthOfArray=sortedArray.length;
    let output=[];
    for(let i=0; i<lengthOfArray; i++){

        if(i%2!==0){
            output.push(sortedArray.pop());
        }else{
            output.push(sortedArray.shift());
        }
    }

    return output;

}

console.log(solve([1,
    65, 3, 52, 48, 63, 31, -3, 18, 56]))