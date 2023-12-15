<template>
  <div class="book-container">
    <book-card v-for="book in showBookList" v-bind:key="book.id" v-bind:book="book"></book-card>
  </div>
</template>

<script>
import BookCard from './BookCard.vue'
export default {
  components:{
    BookCard
  },
  computed:{
  showBookList(){
    const bookList = this.$store.state.books
    return bookList
  }
}
}
</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>