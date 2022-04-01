<template>
  <section>
    <header>
      <p>{{ quizQuestion.question }}</p>
    </header>

    <div v-for="(answerOption, index) in quizQuestion.answerOptions" :key="'quizQuestion' + quizQuestion.id + 'answer' + index">
      <input 
        type="radio" 
        v-bind:id="'quizQuestion' + quizQuestion.id + 'answer' + index"
        v-bind:name="'quizQuestion' + quizQuestion.id"
        v-bind:value="answerOption"
        v-model="userChoice"
        v-bind:disabled="isAnswerSubmitted">

      <label v-bind:for="'quizQuestion' + quizQuestion.id + 'answer' + index">{{ answerOption }}</label>
    </div>

    <footer>
      <p v-if="isAnswerSubmitted && isCorrectAnswer">
        Correct!
      </p>
      <p v-if="isAnswerSubmitted && !isCorrectAnswer">
        Incorrect!
      </p>

      <button v-if="!isAnswerSubmitted" :disabled="userChoice === null" @click="userChoice = null">Reset Input</button>
      <button v-if="!isAnswerSubmitted" :disabled="userChoice === null" @click="submitAnswer">Submit Answer</button>
    </footer>
  </section>
</template>

<script>
export default {
  props: {
    quizQuestion: {
      type: Object,
      required: true
    }
  },

  data() {
    return {
      isAnswerSubmitted: false,
      userChoice: null
    }
  },

  methods: {
    submitAnswer() {
      this.isAnswerSubmitted = true;
      this.$store.commit('SUBMIT_ANSWER', this.isCorrectAnswer);
    }
  },

  computed: {
    isCorrectAnswer() {
      return this.userChoice === this.quizQuestion.correctAnswer;
    }
  }
}
</script>

<style>

</style>