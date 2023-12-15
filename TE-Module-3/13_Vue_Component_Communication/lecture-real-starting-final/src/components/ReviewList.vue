<template>
    <review-display v-for="review in filteredReviews" v-bind:key="review.id" v-bind:review="review"></review-display>
</template>
<script>
import ReviewDisplay from './ReviewDisplay.vue';

export default {
    components: {
        ReviewDisplay
    },
    computed: {
        filteredReviews() {
            const reviews = this.$store.state.reviews;
            return reviews.filter(review => {
                return this.$store.state.filter === 0 || this.$store.state.filter === review.rating;
            });
        }
    }
}

</script>

<style></style>