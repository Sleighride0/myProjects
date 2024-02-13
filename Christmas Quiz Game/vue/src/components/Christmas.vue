<template>
  <div>
    <div v-if="quizQuestions.length === 0">
      <p>Loading quiz questions...</p>
    </div>
    <div v-else>
      <h2 class="question-text">Christmas Quiz</h2>
      <p>Type your answer: A,B,C,or D</p>
      <p>Score: {{ score }}</p>
      <ul class="quiz-list">
        <li v-for="(question, index) in quizQuestions" :key="index" class="quiz-item">
          <div class="question-box">
            <p class="question-text">{{ question.questionPosed }}</p>
            <ul class="choices-list">
              <li v-for="(choice, choiceKey) in ['A', 'B', 'C', 'D']" :key="choiceKey" class="choice-item">
                {{ `${choice}: ${question['choice' + choice]}` }}
              </li>
            </ul>
            <input type="text" v-model="question.userAnswer" placeholder="Your answer" class="user-answer">
            <button @click="revealAnswer(question)">Check Answer</button>
            <p v-if="question.showAnswer" class="answer-text">Correct Answer: {{ question.correctAnswer }}</p>
            <p v-if="question.showAnswer && !question.isCorrect" class="answer-message">
              Incorrect
            </p>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>
  
<script>
import QuizService from '../services/QuizService';

export default {
  data() {
    return {
      quizQuestions: [],
      score: 0,
    };
  },
  mounted() {
    this.getNormalQuiz();
  },
  methods: {
    getNormalQuiz() {
      QuizService.getNormalQuiz()
        .then((response) => {
          this.quizQuestions = response.data.map((question) => ({
            ...question,
            showAnswer: false,
            userAnswer: '',
            isCorrect: false,
          }));
        })
        .catch((error) => {
          console.error('Error fetching quiz questions:', error);
        });
    },
    revealAnswer(question) {
      question.showAnswer = true;

      if (question.userAnswer.trim().toLowerCase() === question.correctAnswer.trim().toLowerCase()) {
        this.score++;
        question.isCorrect = true;
      } else {
        question.isCorrect = false;
      }
      
    },
  },
};
</script>
  
<style scoped>
.quiz-list {
  list-style: none;
  padding: 0;
}

.quiz-item {
  margin-bottom: 20px;
}

.question-box {
  border: 2px solid #c0c0c0;
  padding: 15px;
  background-color: #f0f8ff;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.question-text {
  font-size: 18px;
  font-weight: bold;
  color: #006400;
  margin-bottom: 10px;
}

.choices-list {
  list-style: none;
  padding: 0;
}

.choice-item {
  font-size: 16px;
  margin-bottom: 5px;
}

button {
  background-color: #dc143c;
  color: #ffffff;
  padding: 8px 16px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 10px;
}

.answer-text {
  margin-top: 10px;
  font-weight: bold;
  color: #008080;
}
</style>
  