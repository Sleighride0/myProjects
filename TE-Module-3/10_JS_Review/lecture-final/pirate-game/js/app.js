/*
* Add Events and functions to move the Ship and Win the game
*/
const obstacles = ['pirate', 'iceberg'];
const directions = ['up','right','down', 'left'];
let clock;

// Creates the Grid -- this should only occur after the DOM loads

document.addEventListener('DOMContentLoaded', ()=>{
    createGrid();
    
    document.querySelector('body').addEventListener('keyup', (event)=>{
        if(event.key === 'ArrowRight'){
            moveShipRight();
        }
        if(event.key === 'ArrowLeft'){
            moveShipLeft();
        }
        if(event.key === 'ArrowDown'){
            moveShipDown();
        }
        if(event.key === 'ArrowUp'){
            moveShipUp();
        }
    })

    const resetBtnRef = document.getElementById('resetButton');
    resetBtnRef.addEventListener('click', resetGame);
})

/*
  Move the Ship 
*/
function moveShipRight() {
    const ship = getShipLocation();
    const rightNeighbor = ship.nextElementSibling;
    if(rightNeighbor != null && !rightNeighbor.classList.contains('pirate')){
        ship.classList.remove('boat');
        rightNeighbor.classList.add('boat');
    }
   
}

function moveShipLeft() {
    const ship = getShipLocation();
    const leftNeighbor = ship.previousElementSibling;
    if(leftNeighbor != null && !leftNeighbor.classList.contains('pirate')){
        ship.classList.remove('boat');
        leftNeighbor.classList.add('boat');
    }
}

function moveShipDown() {
    const ship = getShipLocation();
    const shipCurrentIndex = Array.from(ship.parentNode.children).indexOf(ship);
    //get ref to ship's parent's next element sibling
    const nextRowFromShip = ship.parentNode.nextElementSibling;
    if(nextRowFromShip != null){
        const newLocation = nextRowFromShip.children[shipCurrentIndex];
  
        if(newLocation != null && !newLocation.classList.contains('pirate')){
            ship.classList.remove('boat');
            newLocation.classList.add('boat');
        }
    }
   

}

function moveShipUp() {
    const ship = getShipLocation();
    const shipCurrentIndex = Array.from(ship.parentNode.children).indexOf(ship);
    const previousRowFromShip = ship.parentNode.previousElementSibling;
    if(previousRowFromShip != null){
        const newLocation = previousRowFromShip.childNodes[shipCurrentIndex];
        
        if(newLocation != null && !newLocation.classList.contains('pirate')){
            ship.classList.remove('boat');
            newLocation.classList.add('boat');
        }
    }
}


function getShipLocation() {
    // Get the return the current location of the ship
    return document.getElementById('frame').querySelector('.boat')
}


/*
  Win Conditions
*/


/*
    Loss Conditions
*/

/**
 * Reset the Game
 */
function resetGame() {
    if(getShipLocation() !== null){
        const boat = getShipLocation();
        boat.classList.remove('boat');
    }
    createObstacles();
    const container = document.getElementById('frame');
   
    const startingCell = container.children[0].children[0];
    startingCell.classList.add('boat');
    const lastCell = container.children[9].children[9];
    lastCell.classList.add('treasure');
}


/*
    Setup the Game
*/
/**
 * Creates the game grid with 10 rows appended to the element with id = 'main'
 */
function createGrid(){
    const frameRef = document.getElementById('frame');
    for(let i = 0; i < 10; i++){
        buildRow(frameRef)
    }
}


/**
 * Builds a grid row made of 10 squares using buildSquare() and sets the class row to it,
 * then appends the created row to frame
 * @param {HTMLElement} frame 
 */
function buildRow(frame) {
    const rowRef = document.createElement('div');
    rowRef.setAttribute('class', 'row');

    frame.appendChild(rowRef)

    for(let i = 0; i < 10; i++){
        buildSquare(rowRef);
        }
}



/**
 * Builds the grid squares by creating a div and setting its class to square
 * then appends to the end of the given row
 * @param {HTMLElement} row 
 * 
 */
function buildSquare(row) {
    const sqrRef = document.createElement('div');
    sqrRef.setAttribute('class', 'square');
    row.appendChild(sqrRef)
}

function createObstacles(){
    const rows = document.querySelectorAll('.row');
    const rowsArray = Array.from(rows);
    rowsArray.forEach((currentRow, rowIndex)=>{
       const cells = currentRow.querySelectorAll('.square');
       const cellsArray = Array.from(cells);
       cellsArray.forEach((cell, cellIndex)=>{
        if((cellIndex !== 0 && rowIndex !== 0) && (cellIndex !== 9 && rowIndex !== 9)){
            addObstacles(cell)
        }
        
       })
    })
}


/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs
    cell.classList.remove('pirate');
    cell.classList.remove('iceberg');

    const rand = getRandomNumber(100, false);

    // if (rand > 85) {
    //     // Add iceberg here
    //     cell.classList.add('iceberg')
    // } else 
    if (rand > 80) {
        // Add pirates here
        cell.classList.add('pirate')
    } 
}


/*
  Move the Pirates
*/



function getRandomNumber(top, zeroBased) {
    let randNumber = (Math.floor(Math.random() * top) + 1);
    return zeroBased ? randNumber - 1: randNumber;
}
