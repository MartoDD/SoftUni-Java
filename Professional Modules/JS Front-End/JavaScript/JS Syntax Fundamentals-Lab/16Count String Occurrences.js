function solve(string,keyword){
    let words=string.split(" ");
    let counter=0;
    for (let word of words){
        if(word===keyword){
            counter++;
        }
    }
    console.log(counter);
}

solve('softuni is great place for learning new programming languages', 'softuni')