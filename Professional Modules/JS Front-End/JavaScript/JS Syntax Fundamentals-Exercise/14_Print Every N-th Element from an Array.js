function solve(arr,number){

    let output=[];
    let target=0;
    for(i=0; i<arr.length; i+=number){

    output.push(arr[i]);

    }

    return output;
}

console.log(solve(['dsa',
'asd',
'test',
'tset'],
2) )
