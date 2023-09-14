const todoInputName= document.querySelector(".name");
const todoInputDescription= document.querySelector(".description");
const todoInputDate= document.querySelector(".date");
const todoInputCategory= document.querySelector(".category");
const todoInputPriority= document.querySelector(".priority");
const todoInputStatus= document.querySelector(".status");
const todoInputAlarmActive= document.querySelector(".alarmActive");
const card = document.querySelector(".card")



const todoButton = document.querySelector(".todo-button");
const todoList = document.querySelector(".todo-list");
const filterOption = document.querySelector(".filter-todo");

document.addEventListener("DOMContentLoaded", getLocalTodos);
todoButton.addEventListener("click", addTodo);
todoList.addEventListener("click", deleteCheck);
filterOption.addEventListener("change", filterTodo);

//template string



function addTodo(event) {
   
    
    const todoAllInputs = { name : todoInputName.value , description : todoInputDescription.value, date : todoInputDate.value, priority: todoInputPriority.value, category: todoInputCategory.value, status : todoInputStatus.value, alarmActive: todoInputAlarmActive.value}


    // const newTodo = document.createElement("li");
    const newTodo = `
    <li>
    <div class="card">
    <div class="card-header">
      ${todoAllInputs.name}
    </div>
    <div class="card-body">
      <blockquote class="blockquote mb-0">
        <p>Description: ${todoAllInputs.description}</p>

        <div class="" style="text-align: end;
        display: flow;">

            <button type="button" class="btn btn-light" data-bs-toggle="modal">
             delete
              <i class="material-symbols-outlined">delete</i>
            </button>

            <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#ModalEdit">
              Edit
               <i class="material-symbols-outlined">edit</i>
             </button>
        </div>
        
        <footer class="blockquote-footer">Date: <cite title="Source Title">${todoAllInputs.date}</cite></footer>
      </blockquote>
    </div>
  </div>
  <li>`

    console.log(todoAllInputs)
    console.log(newTodo)
  
    //ADDING TO LOCAL STORAGE 
    saveLocalTodos(newTodo); //confere 
    console.log(todoAllInputs)
    
   
   
   todoList += newTodo
   
}

function reload(event){
    location.reload(true)
}




function saveLocalTodos(todo) {
    let todos;
    if(localStorage.getItem("todos") === null) {
        todos = [];
    } else {
        todos = JSON.parse(localStorage.getItem("todos"));
    }
    todos.push(todo);
    localStorage.setItem("todos", JSON.stringify(todos));
}

function getLocalTodos() {
    let todos;
    if(localStorage.getItem("todos") === null) {
        todos = [];
    } else {
        todos = JSON.parse(localStorage.getItem("todos"));
    }
    todos.forEach(function(todo) {
       
       
        // newTodo.innerText = todo;
        // newTodo.classList.add("todo-item");
        const newTodo = todo
        console.log(newTodo)
      

        todoList.innerHTML += newTodo


        
    });
}


function deleteCheck(e) {
    const item = e.target;
    console.log(item)

    if(item.classList[0] === "trash-btn") {
        const todo = item.parentElement;
        todo.classList.add("slide");

        removeLocalTodos(todo);
        todo.addEventListener("transitionend", function() {
            todo.remove();
        });
    }

    if(item.classList[0] === "complete-btn") {
        const todo = item.parentElement;
        todo.classList.toggle("completed");
    }
}

function filterTodo(e) {
    const todos = todoList.childNodes;
    console.log(todoList)
    todos.forEach(function(todo) {
        switch(e.target.value) {
            case "all": 
                todo.style.display = "flex";
                break;
            case "completed": 
                if(todo.classList.contains("completed")) {
                    todo.style.display = "flex";
                } else {
                    todo.style.display = "none";
                }
                break;
            case "incomplete":
                if(!todo.classList.contains("completed")) {
                    todo.style.display = "flex";
                } else {
                    todo.style.display = "none";
                }
                break;
        }
    });
}

function removeLocalTodos(todo) {
    let todos;
    if(localStorage.getItem("todos") === null) {
        todos = [];
    } else {
        todos = JSON.parse(localStorage.getItem("todos"));
    }

    const todoIndex = todo.children[0].innerText;
    todos.splice(todos.indexOf(todoIndex), 1);
    localStorage.setItem("todos", JSON.stringify(todos));
}