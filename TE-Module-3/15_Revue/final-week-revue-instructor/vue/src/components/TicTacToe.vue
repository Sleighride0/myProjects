<template>
    <h1>{{ $store.state.matchWinner }}</h1>
    <div id="game-board" v-on:click="squareClick">
        <section class="tttsquare" id="1"></section>
        <section class="tttsquare" id="2"></section>
        <section class="tttsquare" id="3"></section>
        <section class="tttsquare" id="4"></section>
        <section class="tttsquare" id="5"></section>
        <section class="tttsquare" id="6"></section>
        <section class="tttsquare" id="7"></section>
        <section class="tttsquare" id="8"></section>
        <section class="tttsquare" id="9"></section>
    </div>
</template>

<script>
export default {
    data() {
        return {
            currentPlayer: {
                name: "",
                className: ""
            },
            player1: {
                className: "p1"
            },
            player2: {
                className: "p2"
            },

            row1: [1, 2, 3],
            row2: [4, 5, 6],
            row3: [7, 8, 9],
            col1: [1, 4, 7],
            col2: [2, 5, 8],
            col3: [3, 6, 9],
            dia1: [1, 5, 9],
            dia2: [3, 5, 7],
        }
    },
    created() {
        this.$store.commit('SET_MATCH_STARTING_PLAYER');
        this.setCurrentPlayer();
    },
    methods: {
        setCurrentPlayer() {
            this.currentPlayer.name = this.$store.state.matchStartingPlayer;
            if (this.currentPlayer.name === this.$store.state.user.username) {
                this.currentPlayer.className = 'p1';
            } else {
                this.currentPlayer.className = 'p2';
            }
        },
        squareClick(event) {
            const clickedSquare = event.target;

            if (clickedSquare.classList.contains('tttsquare') &&
                !clickedSquare.classList.contains(this.player1.className) &&
                !clickedSquare.classList.contains(this.player2.className) && this.$store.state.matchWinner == ''
            ) {
                clickedSquare.classList.add(this.currentPlayer.className);
                this.determineWinner(this.currentPlayer);
                this.currentPlayer.className =
                    this.currentPlayer.className === this.player2.className
                        ? this.player1.className
                        : this.player2.className;
            }
        },
        determineWinner(player) {
            const scoringSets = [
                this.row1,
                this.row2,
                this.row3,
                this.col1,
                this.col2,
                this.col3,
                this.dia1,
                this.dia2,
            ];
            scoringSets.forEach((set) => {
                let scoreCounter = 0;
                set.forEach((id) => {
                    let scoredSquare = document.getElementById(id);
                    if (scoredSquare.classList.contains(player.className)) {
                        scoreCounter++;
                    }
                });
                if (scoreCounter > 2) {
                    //need store to update the winner property in the state
                    this.$store.commit("SET_WINNER", player.className);
                }
            });
        }
    }
}
</script>

<style>
#game-board {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    height: 400px;
    width: 400px;
    border: 4px rgb(126, 67, 13) groove;
    border-radius: 10px;
    background-color: rgb(0, 139, 23);
}

.tttsquare {
    height: 75px;
    width: 75px;
    border: 2px rgb(173, 94, 19) inset;
    margin: auto;
    border-radius: 90px;
    background-repeat: no-repeat;
    background-position: center;
    background-size: 180px;
    background-color: floralwhite;
}

.p1 {
    background-image: url("../assets/samwise.png");
}

.p2 {
    background-image: url("../assets/frodo.png");
}
</style>