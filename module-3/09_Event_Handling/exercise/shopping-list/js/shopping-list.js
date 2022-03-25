let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}

function itemComplete() {
   this.classList.add('completed');
   this.firstElementChild.classList.add('completed');
  // const item = document.querySelector('li');
  // this.item.classList.add('completed');
  // const listChecks = document.querySelector('i');
  // this.listChecks.classList.add('completed');
}

function itemIncomplete() {
  this.classList.remove('completed');
  this.firstElementChild.classList.remove('completed');
}

function toggleAllComplete() {
  const listItems = document.querySelectorAll('li');
  const listChecks = document.querySelectorAll('i');
  const text = document.getElementById('toggleAll');
  if(text.innerText === 'MARK ALL COMPLETE') {
    listItems.forEach(item => {
      item.classList.add('completed');
    });
    listChecks.forEach(check => {
      check.classList.add('completed');
    });
    text.innerText = 'Mark All Incomplete';
  } else {
    listItems.forEach(item => {
      item.classList.remove('completed');
    });
    listChecks.forEach(check => {
      check.classList.remove('completed');
    });
    text.innerText = 'Mark All Complete';
  }
}

document.addEventListener('DOMContentLoaded', setPageTitle);
document.addEventListener('DOMContentLoaded', displayGroceries);

document.addEventListener('DOMContentLoaded', () => {
  const button = document.querySelector('.btn');
  button.addEventListener('click', toggleAllComplete);
});
document.addEventListener('DOMContentLoaded', () => {
  const item = document.querySelectorAll('li');
  item.forEach(item => item.addEventListener('click', itemComplete));
});
document.addEventListener('DOMContentLoaded', () => {
  const item = document.querySelectorAll('li');
  item.forEach(item => item.addEventListener('dblclick', itemIncomplete));
});
