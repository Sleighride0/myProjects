<template>
  <div class="home">
    <h1>Home</h1>
    <p>{{ $store.state.user }}</p>
    <div class="'gameCard" v-for="game in games" v-bind:key="game.gameTitleId">
      <span>{{ game.gameName }}</span>
      <router-link :to="{ name: game.gameName.toLowerCase().replace(' ', '') }">
        <img v-bind:src="game.gameImgURL" alt="">
      </router-link>

    </div>
    {{ games }}
  </div>
</template>

<script>
import gameService from '../services/GameService'
export default {
  data() {
    return {
      games: []
    }
  },
  created() {
    gameService.getGameTitles()
      .then(response => {
        this.games = response.data;
      })
  }
};

</script>
