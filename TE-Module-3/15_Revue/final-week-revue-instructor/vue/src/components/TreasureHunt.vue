
<template>
    <div>
        <section id="huntSection">
            <h1 class="announce">Welcome</h1>
            <div class="buttonContainer"><button id="resetButton" v-on:click="resetGame">Reset Game</button></div>
            <div ref="frameRef" id="frame" tabindex="0" @keydown="handleKeyDown">
            </div>
        </section>
    </div>
</template>

<script>
export default {
    data() {
        return {
            obstacles: ['pirate', 'iceberg'],
            directions: ['up', 'right', 'down', 'left'],
        }
    },
    methods: {
        focusFrame() {
            this.$refs.frameRef.focus();
        },
        handleKeyDown(event) {
            console.log(event)
            if (event.key === 'ArrowRight') {
                this.moveShipRight();
            }
            if (event.key === 'ArrowLeft') {
                this.moveShipLeft();
            }
            if (event.key === 'ArrowDown') {
                this.moveShipDown();
            }
            if (event.key === 'ArrowUp') {
                this.moveShipUp();
            }
        },
        moveShipRight() {
            const ship = this.getShipLocation();
            const rightNeighbor = ship.nextElementSibling;
            if (rightNeighbor != null && !rightNeighbor.classList.contains('pirate')) {
                ship.classList.remove('boat');
                rightNeighbor.classList.add('boat');
            }

        },
        moveShipLeft() {
            const ship = this.getShipLocation();
            const leftNeighbor = ship.previousElementSibling;
            if (leftNeighbor != null && !leftNeighbor.classList.contains('pirate')) {
                ship.classList.remove('boat');
                leftNeighbor.classList.add('boat');
            }
        },

        moveShipDown() {
            const ship = this.getShipLocation();
            const shipCurrentIndex = Array.from(ship.parentNode.children).indexOf(ship);
            //get ref to ship's parent's next element sibling
            const nextRowFromShip = ship.parentNode.nextElementSibling;
            if (nextRowFromShip != null) {
                const newLocation = nextRowFromShip.children[shipCurrentIndex];

                if (newLocation != null && !newLocation.classList.contains('pirate')) {
                    ship.classList.remove('boat');
                    newLocation.classList.add('boat');
                }
            }


        },

        moveShipUp() {
            const ship = this.getShipLocation();
            const shipCurrentIndex = Array.from(ship.parentNode.children).indexOf(ship);
            const previousRowFromShip = ship.parentNode.previousElementSibling;
            if (previousRowFromShip != null) {
                const newLocation = previousRowFromShip.childNodes[shipCurrentIndex];

                if (newLocation != null && !newLocation.classList.contains('pirate')) {
                    ship.classList.remove('boat');
                    newLocation.classList.add('boat');
                }
            }
        },
        createGrid() {
            // Get the reference to the frame element
            const frame = this.$refs.frameRef;

            // Remove all child nodes from the frame element
            while (frame.firstChild) {
                frame.removeChild(frame.firstChild);
            }
            const frameRef = document.getElementById('frame');
            for (let i = 0; i < 10; i++) {
                this.buildRow(frameRef)
            }
        },
        buildRow(frame) {
            const rowRef = document.createElement('div');
            rowRef.setAttribute('class', 'row');
            frame.appendChild(rowRef)
            for (let i = 0; i < 10; i++) {
                this.buildSquare(rowRef);
            }
        },
        buildSquare(row) {
            const sqrRef = document.createElement('div');
            sqrRef.setAttribute('class', 'square');
            row.appendChild(sqrRef)
        },
        resetGame() {
            this.createGrid();
            if (this.getShipLocation() !== null) {
                const boat = this.getShipLocation();
                boat.classList.remove('boat');
            }
            this.createObstacles();
            const container = document.getElementById('frame');
            const startingCell = container.children[0].children[0];
            startingCell.classList.add('boat');
            const lastCell = container.children[9].children[9];
            lastCell.classList.add('treasure');
            //set focus on the frame for event handling with arrows
            this.focusFrame();
        },
        getShipLocation() {
            // Get the return the current location of the ship
            return document.getElementById('frame').querySelector('.boat')
        },
        createObstacles() {
            const rows = document.querySelectorAll('.row');
            const rowsArray = Array.from(rows);
            rowsArray.forEach((currentRow, rowIndex) => {
                const cells = currentRow.querySelectorAll('.square');
                const cellsArray = Array.from(cells);
                cellsArray.forEach((cell, cellIndex) => {
                    if ((cellIndex !== 0 && rowIndex !== 0) && (cellIndex !== 9 && rowIndex !== 9)) {
                        this.addObstacles(cell)
                    }

                })
            })
        },
        addObstacles(cell) {
            // remove any existing pirates or icebergs
            cell.classList.remove('pirate');
            cell.classList.remove('iceberg');

            const rand = this.getRandomNumber(100, false);

            // if (rand > 85) {
            //     // Add iceberg here
            //     cell.classList.add('iceberg')
            // } else 
            if (rand > 80) {
                // Add pirates here
                cell.classList.add('pirate')
            }
        },
        getRandomNumber(top, zeroBased) {
            let randNumber = (Math.floor(Math.random() * top) + 1);
            return zeroBased ? randNumber - 1 : randNumber;
        }
    }
}

</script>

<style>
#huntSection {
    width: 650px;
    height: 710px;
    background-color: darkblue;
}

#frame {
    border: 5px solid red;
    background-image: url("../assets/waves.jpg");
    width: 600px;
    height: 600px;
    margin-left: 25px;
    margin-top: 10px;
    padding: 0px;
}

#frame div.row {
    border: 3px dotted black;
    width: 99%;
    height: 9%;
    margin: 0px;
}

.square {
    border: 1px dotted black;
    width: 9.6%;
    height: 98%;
    margin: 0px;
    display: inline-block;
}


.boat {
    background-image: url("../assets/boat-on-waves.jpg");
    background-size: 100% 100%;
    background-repeat: no-repeat;
}

.treasure {
    background-image: url('../assets/treasure.jpg');
    background-size: 100% 100%;
    background-repeat: no-repeat;
}

.pirate {
    background-image: url('../assets/flag-on-waves.jpg');
    background-size: 100% 100%;
    background-repeat: no-repeat;
}

.announce {
    color: white;
    text-align: center;
}

.buttonContainer {
    width: 90%;
    margin: 0px;
    display: flex;
    justify-content: flex-end;
}

.winText {
    color: red;
}
</style>