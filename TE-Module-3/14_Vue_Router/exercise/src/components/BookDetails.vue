<template>
  <div class="book-details">
    <book-card :book="book" />
      </div>
</template>

<script>
import BookCard from '../components/BookCard.vue';

export default {
  components: {
    BookCard,
  },
  computed: {
    book() {
      let bookId = this.$route.params.isbn;
      return this.$store.state.books.find((b) => b.isbn === bookId) || {};
    },
  },
};
</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>