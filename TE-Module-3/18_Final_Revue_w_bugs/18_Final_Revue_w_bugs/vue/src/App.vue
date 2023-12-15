<template>
  <div id="capstone-app">
    <div id="nav">
      <div id="links-container">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>

      <div id="avatar">
        <img v-bind:src="$store.state.user.avatarImgURL" alt="avatar">
      </div>
    </div>
    <div id="mainDisplay">
    <router-view />
    <player-stats></player-stats>
  </div>
  </div>
</template>

<script>
import PlayerStats from './components/PlayerStats.vue';
export default{
  components: {
    PlayerStats
  }
}
</script>

<style>
*{
  font-family: Arial, Helvetica, sans-serif;
}
#nav {
  background-color: #333;
  padding: 10px;
  color: whitesmoke;
  text-align: center;
  display: flex;
  justify-content: space-between;
  align-content: center;
  border-radius: 4px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); 
}

#links-container {
    display: flex;
    align-items: center;
  }

#nav div > a {
  color: whitesmoke;
  text-decoration: none;
}

#avatar {
  height: 50px;
  width: 50px;
  border-radius: 50%;
  background-color: whitesmoke;
  display: flex;
  align-items: center;
  justify-content: center;

}

#avatar>img {
  height: 50%;
  margin: auto;
}

#mainDisplay{
  display: flex;
}

#mainDisplay > div{
  flex-grow: 3;
}
/* #mainDisplay :nth-child(2){
  flex-grow: 1;
} */
</style>