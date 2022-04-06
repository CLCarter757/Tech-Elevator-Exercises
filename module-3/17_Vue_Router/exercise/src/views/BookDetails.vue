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
            if( this.$store.state.books.filter(book => book.isbn == this.$route.params.isbn).length > 0) {
                return this.$store.state.books.find((book) => {
                    return book.isbn == this.$route.params.isbn});
            } else {
                return this.$store.state.popularBooks.find((book) => {
                    return book.isbn == this.$route.params.isbn});
            }
        }      
    }
}
</script>

<style>

</style>