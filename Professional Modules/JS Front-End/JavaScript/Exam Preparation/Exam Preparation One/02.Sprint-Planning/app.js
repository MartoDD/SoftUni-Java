window.addEventListener('load', solve);

function solve() {
    const tasks={};
    
 const selectors={
    title:document.querySelector(`#title`),
    description:document.querySelector(`#description`),
    label:document.querySelector(`#label`),
    points:document.querySelector(`#points`),
    assignee:document.querySelector(`#assignee`)
 }

 const buttonSelectors={
    createButton: document.querySelector(`#create-task-btn`),
    taskSection:document.querySelector(`#tasks-section`),

 };

 buttonSelectors.createButton.addEventListener("click",createTask);

 function createTask(e){
 
   if(Object.values(selectors).some((selecor)=>selecor.value===``)){
    return;
   }

   const task={
    id:`task-${Object.values(tasks).length+1}`,
    title:selectors.title.value,
    description:selectors.description.value,
    label:selectors.label.value,
    points:Number(selectors.points.value),
    assignee:selectors.assignee.value
   };

   tasks[task.id]=task;

   const article = createElement(`article`,null,[`task-card`],task.id);
   createElement(`div`,task.label,[`task-card-label`,task.label],null,article);
   createElement(`h3`,task.title,[`task-card-title`],null,article);
   createElement(`p`,task.description,[`task-card-description`],null,article);
   createElement(`div`,task.points,[`task-card-points`],null,article);
   createElement(`div`,task.assignee,[`task-card-assignee`],null,article);

   buttonSelectors.taskSection.appendChild(article);
}

   function createElement(type,content,classes,id,parent){

    const element=document.createElement(type);

    if (content){
        element.textContent=content;
    }

    if(classes.length>0){
        element.classList.add(...classes);
    }

    if (id){
        element.setAttribute(`id`,id);
    }

    if(parent){
        parent.appendChild(element);
    }

    return element;

   }

 }
