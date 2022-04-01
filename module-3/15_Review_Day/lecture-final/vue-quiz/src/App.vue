<template>
  <div id="app">
    <quiz-summary />
    <quiz-question-list />    
  </div>
</template>

<script>
import QuizSummary from './components/QuizSummary.vue';
import QuizQuestionList from './components/QuizQuestionQueue.vue';

export default {
  name: 'App',
  components: {
    QuizSummary,
    QuizQuestionList,
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
