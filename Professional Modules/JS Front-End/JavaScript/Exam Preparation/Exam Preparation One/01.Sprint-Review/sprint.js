function solve(arr){

const n=arr.shift();
const tickets=arr.slice(0,n);
const commands=arr.slice(n);

const boards=tickets.reduce((acc,curr)=>{

const[assignee,ticketID,title,status,points]=curr.split(":");

if(!acc.hasOwnProperty(assignee)){
    acc[assignee]=[];
}

acc[assignee].push({ticketID,title,status,points: Number(points)})

return acc;

},{})

const commandRunner ={
    "Add New":addNewTask,
    "Change Status": changeTaskStatus,
    "Remove Task": removeTask
};

commands.forEach(command => {
    const [commandName, ...rest]= command.split(`:`)
    commandRunner[commandName](...rest);
});

const toDoPoints=calculatePoints(`ToDo`);
const inProgressPoints=calculatePoints(`In Progress`);
const codeReviewPoints=calculatePoints(`Code Review`);
const donePoints=calculatePoints(`Done`);

console.log(`ToDo: ${toDoPoints}pts`)
console.log(`In Progress: ${inProgressPoints}pts`)
console.log(`Code Review: ${codeReviewPoints}pts`)
console.log(`Done Points: ${donePoints}pts`)

if(donePoints>= toDoPoints+inProgressPoints+codeReviewPoints){
console.log(`Sprint was successful!`)
}else{
    console.log(`Sprint was unsuccessful...!`)
}


function addNewTask(assignee,taskId,title,status,points){

    if(!boards.hasOwnProperty(assignee)){
        console.log(`Assignee ${assignee} does not exist on the board!`)
        return
    }

boards[assignee].push({taskId,title,status,points:Number(points)})

}

function changeTaskStatus(assignee,taskId,status){

    if(!boards.hasOwnProperty(assignee)){
        console.log(`Assignee ${assignee} does not exist on the board!`)
        return
    }

    const task=boards[assignee].find((t)=>t.taskId===taskId);

    if(!task){
        console.log(`Task with ID ${taskId} does not exist for ${assignee}!`)
        return
    }

    task.status=status;

}

function removeTask(assignee,index){

    if(!boards.hasOwnProperty(assignee)){
        console.log(`Assignee ${assignee} does not exist on the board!`)
        return
    }

    if(index<0 || index>=boards[assignee].length){
        console.log(`Index is out of range!`)
    }

    boards[assignee].splice(index,1)

}

function calculatePoints(status){
   return Object.values(boards).reduce((acc,curr)=>{

        const boardTotal=curr
        .filter((t)=>t.status===status)
        .reduce((total,task)=>total+task.points,0);

        return acc+boardTotal;
    }, 0)
}


}

solve([
    `4
    Kiril:BOP-1213:Fix Typo:Done:1
    Peter:BOP-1214:New Products Page:In Progress:2
    Mariya:BOP-1215:Setup Routing:ToDo:8
    Georgi:BOP-1216:Add Business Card:Code Review:3
    Add New:Sam:BOP-1237:Testing Home Page:Done:3
    Change Status:Georgi:BOP-1216:Done
    Change Status:Will:BOP-1212:In Progress
    Remove Task:Georgi:3
    Change Status:Mariya:BOP-1215:Done`
])