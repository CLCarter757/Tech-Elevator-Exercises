<template>
  <div class="book-container">
  <book-card v-for="book in this.$store.state.books" :key="book.isbn" :book="book"/>
  </div>
</template>

<script>

import BookCard from "./BookCard.vue"

export default {
    name: 'reading-list',
    components: {
      BookCard
    }
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>