function repeatString(str,num){

    let concat="";

    for (let i=0; i<num; i++){

        concat=concat.concat(str)

    }

    return concat;

}

console.log(repeatString("abc", 3))