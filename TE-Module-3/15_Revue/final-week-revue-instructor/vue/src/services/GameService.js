import axios from 'axios';

export default {

  getGameTitles() {
    return axios.get('/games')
  }


}