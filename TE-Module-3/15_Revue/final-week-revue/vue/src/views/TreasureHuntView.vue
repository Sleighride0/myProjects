<template>
    <button v-on:click="addGamePlay">Play Now!!</button>
    <p v-if="isPlaying">Game Started</p>
    <treasure-hunt></treasure-hunt>
</template>

<script>
import GameService from "../services/GameService.js";
import TreasureHunt from "../components/TreasureHunt.vue"
export default {
    data() {
        return {
            gamePlayData: {
                "opponentId": 0,
                "gameTitleId": 1
            },
            isPlaying: false
        }
    },
    components:{
        TreasureHunt
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