function solve(speed,area){

    function typeSpeeding(overSpeed){
        let typeSpeeding;
    if(overSpeed<=20){
        typeSpeeding=`speeding`;
    }else if (overSpeed<=40){
        typeSpeeding =`excessive speeding`;
    }else{
        typeSpeeding=`reckless driving`;
    }
    return typeSpeeding;
    }

    
    switch(area){
        case `city`:
            if(speed<=50){
                console.log(`Driving ${speed} km/h in a 50 zone`)
            }else{
                let overSpeed=speed-50;

                console.log(`The speed is ${overSpeed} km/h faster than the allowed speed of 50 - ${typeSpeeding(overSpeed)}`);
            }
            break;
        case `motorway`:
            if(speed<=130){
                console.log(`Driving ${speed} km/h in a 130 zone`)
            }else{
                let overSpeed=speed-130;
                                    
                console.log(`The speed is ${overSpeed} km/h faster than the allowed speed of 130 - ${typeSpeeding(overSpeed)}`);
            }
            break;
        case `interstate`:
            if(speed<=90){
                console.log(`Driving ${speed} km/h in a 90 zone`)
            }else{
                let overSpeed=speed-90;
                                    
                console.log(`The speed is ${overSpeed} km/h faster than the allowed speed of 90 - ${typeSpeeding(overSpeed)}`);
            }
            break;
        case `residential`:
            if(speed<=20){
                console.log(`Driving ${speed} km/h in a 20 zone`)
            }else{
                let overSpeed=speed-20;
                                    
                console.log(`The speed is ${overSpeed} km/h faster than the allowed speed of 20 - ${typeSpeeding(overSpeed)}`);
            }
            break;
    }
   
}

solve(21, 'residential');