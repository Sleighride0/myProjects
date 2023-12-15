// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
const groceries = ['apple', 'candy', 'test', 'fig', 'fish','pop','soda', 'sugar', 'nuts','tacos'];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  document.getElementById('title').innerText = pageTitle;
  
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  let placement = document.getElementById('groceries');
  console.log(placement)
  groceries.forEach((item)=>{
    console.log(item);
    let item2 = document.createElement('li');
    //make an li element
    item2.innerText = item;
    placement.appendChild(item2);
  })
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  let placement = document.getElementById('groceries');
  for(i = 0; i < placement.children.length; i++){
    let current = placement.children[i];
    current.setAttribute('class', 'completed')
  }
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
