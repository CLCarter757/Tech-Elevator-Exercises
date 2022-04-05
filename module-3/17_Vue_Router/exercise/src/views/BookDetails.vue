<template>
  <div>
      <book-details :book="book"></book-details>
  </div>
</template>

<script>
import BookDetails from '../components/BookDetails.vue';

export default {
    components: {
        BookDetails
    },
    computed: {
        book() {
        return this.$store.state.books.find((book) => {
         return book.isbn == this.$route.params.isbn;
        });
        }      
    }
}
</script>

<style>

</style>