<template>
    <div class="game-container">
      <button v-on:click="addGamePlay" class="play-button">Play Now!!</button>
      <p v-if="isPlaying" class="game-status">Game Started</p>
      <tic-tac-toe></tic-tac-toe>
    </div>
  </template>

<script>
import TicTacToe from '../components/TicTacToe.vue';
import gameService from '../services/GameService.js';

export default {
    data(){
        return{
            gamePlayData:{
                "opponentId": 3,
                "gameTitleId": 2
            },
            isPlaying: false,
            gamePlayId: 0
        }
     
    },
    components: {
        TicTacToe
    },
    methods:{
        addGamePlay(){
            gameService.addGamePlay(this.gamePlayData).then(response =>{
                if(response.status === 200){
                    this.isPlaying = true;
                    this.gamePlayId = response.data;
                    this.$store.commit('SET_GAME_PLAY_ID', this.gamePlayId)
                }
            })
        }
    }
}
</script>
<style scoped>
.game-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  min-height: 100vh; /* Ensure at least full height of the viewport */
  margin-top: 20px;
}
.play-button {
  background-color: #3498db;
  color: white;
  padding: 10px 20px;
  font-size: 1em;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.play-button:hover {
  background-color: #2980b9;
}

.game-status {
  font-weight: bold;
  color: #27ae60;
  margin-top: 10px;
}


</style>