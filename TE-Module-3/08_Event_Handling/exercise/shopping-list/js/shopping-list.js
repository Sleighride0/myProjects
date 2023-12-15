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
document.addEventListener('DOMContentLoaded', () => {
  setPageTitle();
  displayGroceries();


  const itemListRef = document.querySelectorAll('li')
  itemListRef.forEach((item) => {
    item.addEventListener('click', (event) => {
      markComplete(event.target);
    })

    item.addEventListener('dblclick', (event) => {
      markIncomplete(event.target);
    })
  })
  const buttonRef = document.getElementById('toggleAll');
  buttonRef.addEventListener('click', (event) => {
    // event.preventDefault()
    toggleButton();

  })

  function toggleButton() {
  
    if (buttonRef.innerText.toUpperCase() === 'MARK ALL COMPLETE') {
      console.log('test')
      
      itemListRef.forEach((item) => {
        const checkCircle = item.querySelector('i')
        item.classList.add('class', 'completed');
        checkCircle.classList.add('class', 'completed')
        buttonRef.innerText = 'Mark All Incomplete'
        allItemsIncomplete = false;
      })
    } else {
      itemListRef.forEach((item) => {
        const checkCircle = item.querySelector('i')
        item.classList.remove('completed')
        checkCircle.classList.remove('completed')
        buttonRef.innerText = 'Mark All Complete'
        allItemsIncomplete = true;
      })
    }
  }

  function markComplete(item) {
    const checkCircle = item.querySelector('i')
    if (!item.classList.contains('completed')) {
    
      item.classList.add('class', 'completed')
      checkCircle.classList.add('class', 'completed')

    }
  }
  function markIncomplete(item) {
    const checkCircle = item.querySelector('i')
    if (item.classList.contains('completed')) {
      // if (item.innerText.includes('Oatmeal')) {
      item.classList.remove('completed')
      checkCircle.classList.remove('completed')
    }
  }
})