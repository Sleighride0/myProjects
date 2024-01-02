<template>
  <div class="home">
    <h1>Quiz Home Page</h1>
    <p>You must be authenticated to see this!</p>
    <div>
      <Christmas></Christmas>
    </div>
  </div>
</template>

<script>
import Christmas from '../components/Christmas.vue';
export default {
  components:{
    Christmas,
  }
};
</script>
<style>

</style>
