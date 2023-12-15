<template>
  <h1>Logout</h1>
</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  }
};
</script>

<style scoped>
.logout-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.logout-title {
  font-size: 2em;
  color: #333;
}
</style>
