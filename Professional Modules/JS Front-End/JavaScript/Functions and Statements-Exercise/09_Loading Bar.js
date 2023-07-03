function loadingBar(number){

    let output="[";

    for(let i=1; i<=10; i++){
        
        if(number/10>=i){
            output=output.concat(`%`)
        }else{
            output=output.concat(`.`)
        }

        if(i===10){
            output=output.concat(`]`)
        }
    }

    if(number!==100){
        console.log(`${number}% ${output}`)
        console.log(`Still loading...`)
    }else{
        console.log(`100% Complete!`)
    }

}

loadingBar(100)