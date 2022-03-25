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

/*
  1) The element to listen for the event on
  2) The type of event
  3) The function to run when the event occurs
*/
const button = document.getElementById('toggleAll');
// button.addEventListener('click', displayGroceries);
button.addEventListener('click', function (event) {
  console.log(event);
  // displayGroceries();
});

// button.addEventListener('click', (event) => {
//   displayGroceries();
// });



document.addEventListener('DOMContentLoaded', () => {

  // find the button (Mark All Completed)
  // attach event listener to the button
  // call a function

  // the function on click of the button

  /*
    find all of the list items
    iterate over them
    for each one, 
      - add the class completed to the li
      - find the icon, add the class completed to it

    change the button text to Mark All Incomplete
    flip the boolean allItemsIncomplete = false


    find all of the list items
    iterate over them
    for each one, 
      - remove the class completed to the li
      - find the icon, remove the class completed to it

    change the button text to Mark All Complete
    flip the boolean allItemsIncomplete = true
  */

});