import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    quiz: {
      title: 'Quiz 1',
      questions: [
        {
          id: 1,
          question: 'Who wins the Men\'s Final Four?',
          correctAnswer: 'Duke',
          answerOptions: ['Duke', 'North Carolina', 'Kansas', 'Villanova'],
        },

        {
          id: 2,
          question: 'Who wins the Women\'s Final Four?',
          correctAnswer: 'Connecticut',
          answerOptions: ['Connecticut', 'South Carolina', 'Louisville', 'Stanford'],
        }
      ]
    },
    result: {
      numberCorrect: 0,
      totalQuestionsAnswered: 0
    }
  },
  mutations: {
    SUBMIT_ANSWER(state, isCorrect) {
      if(isCorrect) state.result.numberCorrect++;

      state.result.totalQuestionsAnswered++;
    },

    TRY_AGAIN(state) {
      state.result = {
        numberCorrect: 0,
        totalQuestionsAnswered: 0
      };
    }
  },
  actions: {
  },
  modules: {
  }
})
