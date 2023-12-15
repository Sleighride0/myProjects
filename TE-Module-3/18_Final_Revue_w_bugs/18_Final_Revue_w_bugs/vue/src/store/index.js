import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      matchStartingPlayer: {},
      opposingPlayer: 'player1',
      matchWinner: '',
      userGameStats: [],
      matchData: {
          gamePlayId: 0,
          matchWinnerId: 0,
          matchSecondWinnerId: 0
      },
      gamePlayId: 0
    },
    mutations: {
      SET_GAME_PLAY_ID(state, id){
        state.gamePlayId = id
      },
      SET_USER_GAME_STATS(state, stats) {
        if (state.userGameStats.length === 0) {
            state.userGameStats = stats;
        } else {
            state.userGameStats.push(stats);
        }
    },
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      SET_MATCH_STARTING_PLAYER(state){

        if(state.matchStartingPlayer === ''){
          const randomValue = Math.floor(Math.random() * 2);
          console.log(randomValue)
          if (randomValue === 1) {
            state.matchStartingPlayer = state.opposingPlayer;
          } else {
            state.matchStartingPlayer = state.user.username;
          }
        }
        if(state.matchStartingPlayer === state.user.username){
          state.matchStartingPlayer = state.opposingPlayer;
        }else{
          state.matchStartingPlayer = state.user.username;
        }
    
      },
      SET_WINNER(state, playerClassName){
        state.matchWinner = playerClassName;
    },
    },
  });
  return store;
}
