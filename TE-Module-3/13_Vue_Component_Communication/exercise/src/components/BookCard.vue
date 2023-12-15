<template>
  <div class="card" :class="{'read' : book.read === true}">
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="book-author">{{ book.author }}</h3>
    <img class="book-image" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'">
      <button :class="{ 'mark-unread': book.read === true, 'mark-read': book.read === false }" v-on:click="toggleStatus(book)">{{book.read === true ? 'Mark Unread' : 'Mark Read'}}</button>
  </div>
</template>

<script>
export default {
props: ['book'],
methods:{
  toggleStatus(book){
    this.$store.commit('TOGGLE_STATUS',book)
    
  }

}

}
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
  position: relative;
}

.card.read {
  background-color: lightgray;
}

.card .book-title {
  font-size: 1.5rem;
}

.card .book-author {
  font-size: 1rem;
}

.book-image {
  width: 80%;
}

.mark-read, .mark-unread {
  display: block;
  position: absolute;
  bottom: 40px;
  width: 80%;
  left: 10%;
  font-size: 1rem;
}
</style>