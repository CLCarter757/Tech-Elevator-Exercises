<template>
    <div>
        <form class="new-book-form" v-on:submit.prevent="addBook">
            <div>
                <label for="title">Title</label>
                <input type="text" class="title-input" id="title" v-model="newBook.title"/>
            </div>
            <div>
                <label for="author">Author</label>
                <input type="text" class="author-input" id="author" v-model="newBook.author"/>
            </div>
            <div>
                <label for="isbn">ISBN</label>
                <input type="text" class="isbn-input" id="isbn" v-model="newBook.isbn"/>
            </div>
            <button type="submit">Add Book</button>
        </form>
    </div>
</template>

<script>
export default {
    name: "new-book-form",
    data() {
        return {
            newBook: {
                title: "",
                author: "",
                read: false,
                isbn: ""
            }
        };
    },
    methods: {
        addBook() {
            this.$store.commit("ADD_BOOK", this.newBook);
            this.resetForm();
        },
        resetForm() {
            this.newBook = {
                title: "",
                author: "",
                read: false,
                isbn: ""
            };
        } 
    }

}
</script>

<style>

</style>