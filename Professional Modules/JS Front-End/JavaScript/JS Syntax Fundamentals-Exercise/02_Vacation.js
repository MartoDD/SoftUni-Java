function solve(people,type,day){

    let price;

    switch (day){
        case `Friday`:
            switch (type){
                case `Students`:
                    price=8.45 * people;
                    if (people>=30){
                        price=price*0.85;
                    }
                    break;
                case `Business`:
                    price=10.90*people;
                    if(people>=100){
                        price=price - 10.90*10;
                    }
                    break;
                case `Regular`:
                    price=15*people;
                    if(people>=10 && people<=20){
                        price=price*0.95;
                    }
                    break;
            }
            break;

        case `Saturday`:
            switch (type){
                case `Students`:
                    price=9.80 * people;
                    if (people>=30){
                        price=price*0.85;
                    }
                    break;
                case `Business`:
                    price=15.60*people;
                    if(people>=100){
                        price=price - 10.90*10;
                    }
                    break;
                case `Regular`:
                    price=20*people;
                    if(people>=10 && people<=20){
                        price=price*0.95;
                    }
                    break;
            }
            break;

        case `Sunday`:
            switch (type){
                case `Students`:
                    price=10.46 * people;
                    if (people>=30){
                        price=price*0.85;
                    }
                    break;
                case `Business`:
                    price=16*people;
                    if(people>=100){
                        price=price - 10.90*10;
                    }
                    break;
                case `Regular`:
                    price=22.50*people;
                    if(people>=10 && people<=20){
                        price=price*0.95;
                    }
                    break;
            }
            break;

    }

    console.log(`Total price: ${price.toFixed(2)} `)

}

solve(40,
    "Regular",
    "Saturday")