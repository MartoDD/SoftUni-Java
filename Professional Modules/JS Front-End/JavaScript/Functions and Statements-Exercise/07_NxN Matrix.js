function solve(num){

    function line(num){

        let str="";

        for(let i=0; i<num; i++){
            str=str.concat(num + " ")
        }

        return str;
    }

    for(let i=0; i<num; i++){
        console.log(line(num))
    }

}

solve(3)