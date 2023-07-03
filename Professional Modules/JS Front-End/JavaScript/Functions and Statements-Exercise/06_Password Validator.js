function solve(input){

    function checkLength(input){
        return input.length>=6 && input.length<=10
    }

    function checkLetters(input){

        let hasOnlyLetters=true;

        for (let i=0;i<input.length; i++){
            if((!/[a-zA-Z0-9]/.test(input[i]))){
                return false;
            }
        }

        return hasOnlyLetters;
    }

    function checkNumberOfDigits(input){

        let countOfDigits=0;

        for (let i=0;i<input.length; i++){
            if(/\d/.test(input[i])){
                countOfDigits++;
            }
        }

        return countOfDigits >= 2;
    }

    if(checkLetters(input) && checkNumberOfDigits(input) && checkLength(input)){
        console.log(`Password is valid`)
    }else {
        if (!checkLength(input)){
            console.log(`Password must be between 6 and 10 characters`)
        }
        if (!checkLetters(input)){
            console.log(`Password must consist only of letters and digits`)
        }
        if (!checkNumberOfDigits(input)){
            console.log(`Password must have at least 2 digits`)
        }
    }


}

solve('MyPass123')