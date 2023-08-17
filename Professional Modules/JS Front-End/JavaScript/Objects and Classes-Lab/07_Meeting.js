function meetings(arr){

const daysAndNames = arr.reduce((acc,curr)=>{

 const[day,name]=curr.split(" ");
 
 if (acc.hasOwnProperty(day)){
    console.log(`Conflict on ${day}!`)
 }else{
    acc[day]=name;
    console.log(`Scheduled for ${day}`)
 }

 return acc;

}, {})

Object.entries(daysAndNames).forEach(([key,value]) => {
    console.log(`${key} -> ${value}`)
});

}

meetings(['Friday Bob',
'Saturday Ted',
'Monday Bill',
'Monday John',
'Wednesday George']);