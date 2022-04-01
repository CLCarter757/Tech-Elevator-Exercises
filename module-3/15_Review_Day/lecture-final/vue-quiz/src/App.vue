<template>
  <div id="app">
    <quiz-summary />
    <quiz-question-queue />    
    <!-- <quiz-question-list />     -->
  </div>
</template>

<script>
import QuizSummary from './components/QuizSummary.vue';
import QuizQuestionQueue from './components/QuizQuestionQueue.vue';
// import QuizQuestionList from './components/QuizQuestionList.vue';

export default {
  name: 'App',
  components: {
    QuizSummary,
    QuizQuestionQueue
    // QuizQuestionList,
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
