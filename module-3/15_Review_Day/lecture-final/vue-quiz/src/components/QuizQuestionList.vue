<template>
  <div>
    <header>
      <h1>{{ $store.state.quiz.title }}</h1>
    </header>

    <main>
      <quiz-question 
        v-for="q in $store.state.quiz.questions" 
        v-bind:key="q.id"
        v-bind:quizQuestion="q" />
    </main>
  </div>
</template>

<script>
import QuizQuestion from './QuizQuestion.vue';

export default {
  components: {
    QuizQuestion
  }
}
</script>

<style>

</style>