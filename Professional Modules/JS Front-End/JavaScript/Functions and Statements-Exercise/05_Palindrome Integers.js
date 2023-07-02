function solve(arr){

function checkIfNumberIsPalindrome(num){

    let numberAsString=num.toString();
    
    let reversedNumber=numberAsString.split("").reverse().join("");

    if(numberAsString===reversedNumber){
        return true;
    }else{
        return false;
    }

}

for(let i=0; i<arr.length; i++){

    console.log(checkIfNumberIsPalindrome(arr[i]));
}

}

solve([123,323,421,121])