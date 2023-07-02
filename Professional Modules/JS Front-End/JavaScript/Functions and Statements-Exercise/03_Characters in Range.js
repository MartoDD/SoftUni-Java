function charactersInRange(char1,char2){

    let output="";

    function findSmallestChar(char1,char2){
        
        let firstValue=char1.charCodeAt(0);
        let secondValue=char2.charCodeAt(0);

        return Math.min(firstValue,secondValue);
    }

    
    function findBiggertChar(char1,char2){
        
        let firstValue=char1.charCodeAt(0);
        let secondValue=char2.charCodeAt(0);

        return Math.max(firstValue,secondValue);
    }

    let firstChar=findSmallestChar(char1,char2);
    let secondChar=findBiggertChar(char1,char2);

    for (let i=firstChar+1; i<secondChar; i++){

        output=output.concat(String.fromCharCode(i) + " ");

    }

    return output;

}

console.log(charactersInRange('#',
':'))