// console output div
// console.log = (function (old_function, div_log) { 
//     return function (text) {
//         old_function(text);
//         div_log.textContent += text;
//     };
// } (console.log.bind(console), document.getElementById("debugDiv")));



const TODOS_LOCAL_KEY = 'todos';
const todosDiv = document.getElementById("todos");
const addTodoInput = document.getElementById("addTodo");

function getTodos() {
  let todosLocal = localStorage.getItem(TODOS_LOCAL_KEY);
  let todos = [];
  if (todosLocal) {
    try {
       todos = JSON.parse(todosLocal);
    } catch (error) {
      console.error("Error while parsing todo list: ", error);
    }
  }

  return todos;
}

function saveTodo(todo) {
  let todos = getTodos();
  todos.push(todo);

  try {
    localStorage.setItem(TODOS_LOCAL_KEY, JSON.stringify(todos));
  } catch (error) {
    console.error("Error while parsing todo: ", error);
  }
}

function addToListAndCut(todo) {
  let todoTemplate = document.getElementById("todoTemplate");
  todoTemplate.content.getElementById("todo").innerHTML = todo.val;

  const todoTemplateClone = todoTemplate.content.cloneNode(true);
  todoTemplateClone.children[0].removeAttribute('id');
  todoTemplateClone.children[0].getElementsByClassName('todoName')[0].classList.add('crossText');

  todosDiv.appendChild(todoTemplateClone);
}

function addToList(todo) {
  let todoTemplate = document.getElementById("todoTemplate");
  todoTemplate.content.getElementById("todo").innerHTML = todo.val;

  const todoTemplateClone = todoTemplate.content.cloneNode(true);
  todoTemplateClone.children[0].removeAttribute('id');
  if (todo.comp) {
    todoTemplateClone.children[0].getElementsByClassName('todoName')[0].classList.add('crossText');
  } else {
    todoTemplateClone.children[0].getElementsByClassName('todoName')[0].classList.remove('crossText');
  }

  todosDiv.appendChild(todoTemplateClone);
}

function createTodo(event) {
  if (event.code === 'Enter' || event.keyCode === 13) {
    let todoName = event.target.value;
    const todo = { "val": todoName };

    saveTodo(todo);
    addToList(todo);
  }
}

function init() {
  let todos = getTodos();

  todosDiv.innerHTML = '';
  todos.forEach((item) => {
    addToList(item);
  });
}

init();

function removeFromTodos(element) {
  const nameOfTodo = element.parentElement.parentElement.getElementsByClassName('todoName')[0].innerHTML;
  let todos = getTodos();

  todosDiv.innerHTML = '';
  localStorage.removeItem(TODOS_LOCAL_KEY);

  todos.forEach((item) => {
    if (item.val !== nameOfTodo) {
      addToList(item);
      saveTodo(item);
    }
  });
}

function crossFromTodos(element) {
  const nameOfTodo = element.parentElement.parentElement.getElementsByClassName('todoName')[0].innerHTML;
  let todos = getTodos();

  todosDiv.innerHTML = '';
  localStorage.removeItem(TODOS_LOCAL_KEY);

  todos.forEach((item) => {
    if (item.val === nameOfTodo) {
      // console.log(item.comp);
      if (item.comp) {
        item.comp = false;
      } else {
        item.comp = true;
      }
      // console.log(item.comp);
      addToList(item);
    } else {
      addToList(item);
    }
    saveTodo(item);
  });
}

window.addEventListener("keyup", (event) => {
  if (event.code === 'Slash') {
    addTodoInput.focus();
  }
});

