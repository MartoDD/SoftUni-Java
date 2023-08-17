function solve(arr){

    const addressBook=arr.reduce((acc,curr)=>{


        const [name,address]=curr.split(":");

        acc[name]=address;

        return acc;
    }, {})

    const sorted=Object.entries(addressBook).sort(([nameA],[nameB])=>{
        return nameA.localeCompare(nameB)
    })

    sorted.forEach(([key,value])=>{
        console.log(`${key} -> ${value}`)
    })

}

solve(['Bob:Huxley Rd',
'John:Milwaukee Crossing',
'Peter:Fordem Ave',
'Bob:Redwing Ave',
'George:Mesta Crossing',
'Ted:Gateway Way',
'Bill:Gateway Way',
'John:Grover Rd',
'Peter:Huxley Rd',
'Jeff:Gateway Way',
'Jeff:Huxley Rd'])