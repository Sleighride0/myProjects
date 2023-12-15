<template>
  <div class="home">
    <h1>Welcome to Our Games</h1>
    <div class="gameCard" v-for="game in games" :key="game.gameTitleId">
      <router-link :to="{ name: game.gameName.toLowerCase().replace(' ', '') }">
        <img :src="game.gameImgURL" alt="">
      </router-link>
      <div class="gameInfo">
        <span class="gameName">{{ game.gameName }}</span>
      </div>
    </div>
  </div>
</template>

<script>
import gameService from '../services/GameService.js';

export default {
  data() {
    return {
      games: []
    };
  },
  created() {
    gameService.getGameTitles().then(response => {
      this.games = response.data;
    });
  }
};
</script>

<style scoped>
.home {
  text-align: center;
}

.gameCard {
  margin: 20px;
  padding: 15px;
  border: 1px solid #ccc;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease-in-out;
}

.gameCard:hover {
  transform: scale(1.05);
}

img {
  max-width: 100%;
  height: auto;
  border-radius: 8px;
}

.gameInfo {
  margin-top: 10px;
}

.gameName {
  font-size: 1.2em;
  font-weight: bold;
  color: #333;
}
</style>