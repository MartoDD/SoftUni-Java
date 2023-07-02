function solve(num) {

    function findOddSum(num) {

        let oddSum=0;

        let numberAsLetter = num.toString();

        for (let i = 0; i < numberAsLetter.length; i++) {

            if (Number(numberAsLetter.charAt(i)) % 2 !== 0) {
                oddSum += Number(numberAsLetter.charAt(i));
            }

        }

        return oddSum;

    }

    function findEvenSum(num) {

        let evenSum=0;

        let numberAsLetter = num.toString();

        for (let i = 0; i < numberAsLetter.length; i++) {

            if (Number(numberAsLetter.charAt(i)) % 2 === 0) {
                evenSum += Number(numberAsLetter.charAt(i));
            }

        }

        return evenSum;

    }

    console.log(`Odd sum = ${findOddSum(num)}, Even sum = ${findEvenSum(num)}`)

}

solve(3495892137259234)