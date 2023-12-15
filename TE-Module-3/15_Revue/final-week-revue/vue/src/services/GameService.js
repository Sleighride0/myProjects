import axios from 'axios';

export default {

    getGameTitles() {
        return axios.get('/games')
    },
    addGamePlay(gamePlayData){
        return axios.post('/games', gamePlayData);
    }
}
