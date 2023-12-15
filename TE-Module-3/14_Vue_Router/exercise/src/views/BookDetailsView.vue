<template>
    <book-details :book="book"></book-details>
  </template>
  
  <script>
  import BookDetails from '../components/BookDetails.vue';
  
  export default {
    components: {
      BookDetails,
    },
    computed: {
      book() {
        let bookId = this.$route.params.isbn;
        let book = this.$store.state.books.find((b) => b.isbn === bookId);
        return book
    }}
  };
  </script>
  
  <style></style>