<template>
  <div>
    <header>
      <h1>{{ $store.state.quiz.title }}</h1>
    </header>

    <main>
      <quiz-question 
        v-if="hasNextQuestion" 
        v-bind:quizQuestion="currentQuestion" 
        v-bind:key="currentQuestion.id" /> <!-- key will re-render the question when it changes, thus resetting the internal state of quiz-question -->
      <section v-else>
        <p>Quiz is complete</p>
        <button @click="tryAgain">Try again</button>
      </section>
    </main>
  </div>
</template>

<script>
import QuizQuestion from './QuizQuestion.vue';

export default {
  components: {
    QuizQuestion
  },

  methods: {
      tryAgain() {
          this.$store.commit('TRY_AGAIN');
      }
  },

  computed: {
      hasNextQuestion() {
          return this.$store.state.result.totalQuestionsAnswered < this.$store.state.quiz.questions.length;
      },
      currentQuestion() {
          const questionIndex = this.$store.state.result.totalQuestionsAnswered;
          return this.$store.state.quiz.questions[questionIndex];
      }
  }
}
</script>

<style>

</style>