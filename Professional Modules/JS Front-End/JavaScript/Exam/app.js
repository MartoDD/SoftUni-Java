window.addEventListener("load", solve);

function solve() {
    

    const score={};

    const selectors={
      playerName:document.querySelector(`#player`),
      score:document.querySelector(`#score`),
      round:document.querySelector(`#round`),
   }

   const buttonAdd=document.querySelector(`#add-btn`)
   buttonAdd.addEventListener(`click`,add)
   const buttonClear=document.querySelector(`.btn.clear`)
   buttonClear.addEventListener(`click`,clearBoard)
   
   function clearBoard(){
    const scoreBoard=document.getElementById(`scoreboard-list`);
    scoreBoard.innerHTML = '';
   }

   function add(){

    const sureList = document.getElementById(`sure-list`);
    sureList.innerHTML = '';
    
    if(Object.values(selectors).some((selecor)=>selecor.value===``)){
      return;
     }  
     
     const playerName=document.querySelector(`#player`).value;
     const playerScore=document.querySelector(`#score`).value;
     const playerRound=document.querySelector(`#round`).value;  



     const paragraphName=document.createElement(`p`)
     paragraphName.textContent=playerName;

     const paragraphScore=document.createElement(`p`)
     paragraphScore.textContent=`Score: ${playerScore}`

     const paragraphRound=document.createElement(`p`)
     paragraphRound.textContent= `Round: ${playerRound}`;

     const article=document.createElement(`article`)
     article.appendChild(paragraphName);
     article.appendChild(paragraphScore);
     article.appendChild(paragraphRound);


     const buttonEdit=document.createElement(`button`)
     buttonEdit.className=`btn edit`
     buttonEdit.textContent=`edit`

     const buttonOk=document.createElement(`button`)
     buttonOk.className=`btn ok`
     buttonOk.textContent=`ok`

     const list=document.createElement(`li`);
     list.className=`dart-item`
     list.appendChild(article)
     list.appendChild(buttonEdit)
     list.appendChild(buttonOk)


    
     sureList.appendChild(list)
    
    buttonEdit.addEventListener(`click`,()=>{

      const clonedParagraphs = list.querySelectorAll("p");
    const clonedName = clonedParagraphs[0].textContent;
    const clonedScore = clonedParagraphs[1].textContent.replace("Score: ", "");
    const clonedRound = clonedParagraphs[2].textContent.replace("Round: ", "");

      document.querySelector(`#player`).value=clonedName;
     document.querySelector(`#score`).value=clonedScore;
     document.querySelector(`#round`).value=clonedRound; 
     sureList.innerHTML = '';
    })

    buttonOk.addEventListener(`click`, ()=>{
      const scoreBoard = document.getElementById(`scoreboard-list`);
        const clonedList = list.cloneNode(true);
        
      
        const clonedButtonOk = clonedList.querySelector('.btn.ok');
        const clonedButtonEdit = clonedList.querySelector('.btn.edit');
        if (clonedButtonOk) {
            clonedList.removeChild(clonedButtonOk);
        }
        if (clonedButtonEdit) {
            clonedList.removeChild(clonedButtonEdit);
        }

        scoreBoard.appendChild(clonedList);
        sureList.innerHTML = '';
    })
  
    document.querySelector(`#player`).value="";
    document.querySelector(`#score`).value="";
    document.querySelector(`#round`).value="";  

   }

   

  }
  