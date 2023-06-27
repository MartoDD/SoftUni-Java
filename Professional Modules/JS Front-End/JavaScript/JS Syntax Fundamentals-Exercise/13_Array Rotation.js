function solve(arr,number){    

    for(let i=0; i<number; i++){
        
        let firstElement=arr.shift();
        arr.push(firstElement);

    }
    let print=arr.join(" ");
    console.log(print)

}

solve([51,47, 32, 61, 21], 2)