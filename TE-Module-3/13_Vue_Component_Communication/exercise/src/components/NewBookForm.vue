<template>
    
        <form class="new-book-form" v-on:submit.prevent="addNewForm">
            <div>
                <label for="title">Title</label>
                <input class="title-input" type="text" />
                <label for="title">Author</label>
                <input class="author-input" type="text" />
                <label for="title">ISBN</label>
                <input class="isbn-input" type="text" />
            
            <input type="submit" value="Save">
        </div>
        </form>
    
</template>

<script></script>
<style></style>