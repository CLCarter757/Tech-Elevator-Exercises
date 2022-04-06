<template>
  <div>
      <h2 class="book-title">{{ book.title }}</h2>
      <h3 class="book-author">{{ book.author }}</h3>
      <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
      <p>{{book.read ? 'I have read this book' : 'I have not read this book'}}</p>
  </div>
</template>

<script>
export default {
    name: "book-details",
    props: ["book"],

}
</script>

<style>

</style>