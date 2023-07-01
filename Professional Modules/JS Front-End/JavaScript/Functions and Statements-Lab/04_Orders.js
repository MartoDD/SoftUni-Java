function orders(type,quantity){

    let totalPrice=0;

    switch(type){

        case `coffee`:
            totalPrice=1.5*quantity;
            break;
        case `water`:
            totalPrice=quantity;
            break;
        case `coke`:
            totalPrice=1.4*quantity;
            break;
        case `snacks`:
            totalPrice=2*quantity;
            break;
    }

    console.log(totalPrice.toFixed(2))

}

orders("water", 5)