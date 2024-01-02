import axios from 'axios';

export default {

  getNormalQuiz() {
    return axios.get('/quiz/normal')
  },
}