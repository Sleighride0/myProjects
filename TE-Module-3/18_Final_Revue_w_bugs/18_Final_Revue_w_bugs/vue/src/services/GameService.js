import axios from 'axios';

export default {

  getGameTitles() {
    return axios.get('/games')
  },

  addGamePlay(gamePlayData){
    return axios.post('/games', gamePlayData)
  },

  getUserGameStats(){
    return axios.get('/games/stats')
  },

  addMatchForGame(matchData){
    return axios.post(`/games/${matchData.gamePlayId}`, matchData)
  }

}