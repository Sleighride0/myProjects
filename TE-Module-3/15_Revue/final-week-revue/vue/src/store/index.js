import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      matchStartingPlayer: '',
      opposingPlayer: 'opposing player',
      matchWinner:''
    },
    mutations: {
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
    SET_MATCH_STARTING_PLAYER(state) {
      if (state.matchStartingPlayer === '') {
        const randomValue = Math.floor(Math.random() * 2);
        if (randomValue === 1) {
          state.matchStartingPlayer = state.opposingPlayer;
        } else {
          state.matchStartingPlayer = state.user.username;
        }
      }
      if (state.matchStartingPlayer === state.user.username) {
        state.matchStartingPlayer = state.opposingPlayer;
      } else {
        state.matchStartingPlayer = state.user.username;
      }
    }
  }
  });
  return store;
}
