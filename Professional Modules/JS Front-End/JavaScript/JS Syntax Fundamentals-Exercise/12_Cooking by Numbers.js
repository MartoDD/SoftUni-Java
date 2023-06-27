function solve (num,list1,list2,list3,list4,list5){

    let number=Number(num);
    let commands=[list1,list2,list3,list4,list5];

    for(let i=0; i<5; i++){

        switch(commands[i]){
            case `chop`:
                number/=2;
                console.log(number);
                break;
            case `dice`:
                number=Math.sqrt(number);
                console.log(number);
                break;
            case `spice`:
                number+=1;
                console.log(number);
                break;
            case `bake`:
                number*=3;
                console.log(number);
                break;
            case `fillet`:
                number*=0.80;
                console.log(number.toFixed(1));
                break;

        }
    }
}

solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet')