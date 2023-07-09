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

function addTodo(todo) {
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

  todosDiv.appendChild(todoTemplateClone);
}

function createTodo(event) {
  if (event.code === 'Enter') {
    let todoName = event.target.value;
    const todo = { "val": todoName };

    addTodo(todo);
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
      addTodo(item);
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
      addToListAndCut(item);
    } else {
      addToList(item);
    }
    addTodo(item);
  });
}

window.addEventListener("keyup", (event) => {
  if (event.code === 'Slash') {
    addTodoInput.focus();
  }
});

