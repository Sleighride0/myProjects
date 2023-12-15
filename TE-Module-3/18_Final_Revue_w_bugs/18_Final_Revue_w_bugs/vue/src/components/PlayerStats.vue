<template>
    <div>
      <div v-for="stat in stats" :key="stat.gamePlayId" class="game-stat-item">
        <h3 style="color: blue;">{{ stat.gameName }}</h3>
        <p style="font-weight: bold;">Opponent: {{ stat.opponentUsername }}</p>
        <p :class="{ 'win-text': stat.gameWinner, 'lose-text': !stat.gameWinner }">
          Result: {{ stat.gameWinner ? 'Win' : 'Lose' }}
        </p>
      </div>
    </div>
  </template>

<script>
import gameService from '../services/GameService.js';

export default{
    data(){
        return {
            stats:[]
        }
    },
  
    created(){
        gameService.getUserGameStats().then(response =>{
        
            const userStats = response.data
     
            this.$store.commit('SET_USER_GAME_STATS', userStats)

            this.stats = userStats;
        })
    }
}

</script>


<style>
  .game-stat-item {
    border: 1px solid #ccc;
    margin-bottom: 10px;
    padding: 10px;
  }

  .win-text {
    color: green;
  }

  .lose-text {
    color: red;
  }
</style>
