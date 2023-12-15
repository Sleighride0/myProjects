<template>
    <button v-on:click="addGamePlay">Play Now!!</button>
    <p v-if="isPlaying">Game Started</p>
    <tic-tac-toe></tic-tac-toe>
</template>

<script>
import GameService from "../services/GameService.js";
import TicTacToe from "../components/TicTacToe.vue"
export default {
    data() {
        return {
            gamePlayData: {
                "opponentId": 3,
                "gameTitleId": 2
            },
            isPlaying: false
        }
    },
    components: {
        TicTacToe
    },
    methods: {
        addGamePlay() {
            GameService.addGamePlay(this.gamePlayData).then(response =>{
                if(response.status === 200){
                    this.isPlaying = true;
                }
            })
        }
    }
}
</script>
<style></style>