

function solve(arr){

    class Cat{

        constructor(name,age){
            this.name=name;
            this.age=age;
        }
    
        meow(){
            console.log(`${this.name}, age ${this.age} says Meow`)
        }
    
    }

    arr.forEach((line) => {

        const [name,age]=line.split(` `);
        const cat=new Cat(name,age);
        cat.meow()
    });

}

solve(['Mellow 2', 'Tom 5'])