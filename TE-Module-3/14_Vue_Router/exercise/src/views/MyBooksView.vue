<template>
    <reading-list></reading-list>
    <router-link v-bind:to="{name: 'bookForm'}">Add Book to Reading List</router-link>
    </template>
    <script>
    import ReadingList from '../components/ReadingList.vue'
    export default{
        components:{
            ReadingList
        }
    }
    </script>
    <style></style>