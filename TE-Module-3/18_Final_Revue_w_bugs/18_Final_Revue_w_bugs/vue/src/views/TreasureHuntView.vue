<template>
    <div class="game-container">
      <button v-on:click="addGamePlay" class="play-button">Play Now!!</button>
      <p v-if="isPlaying" class="game-status">Game Started</p>
      <treasure-hunt class="treasure-hunt-component"></treasure-hunt>
    </div>
  </template>

<script>
import TreasureHunt from '../components/TreasureHunt.vue';
import gameService from '../services/GameService.js';

export default {
    data(){
        return{
            gamePlayData:{
                "opponentId": 0,
                "gameTitleId": 1
            },
            isPlaying: false
        }
     
    },
    components: {
        TreasureHunt
    },
    methods:{
        addGamePlay(){
            gameService.addGamePlay(this.gamePlayData).then(response =>{
                if(response.status === 200){
                    this.isPlaying = true;
                }
            })
        }
    }
}
</script>

<style scoped>
.game-container {
  text-align: center;
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

.treasure-hunt-component {
  margin-top: 20px;
}
</style>