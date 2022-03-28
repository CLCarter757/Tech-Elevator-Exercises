<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png"> -->
    <product-reviews />
  </div>
</template>

<script>
import ProductReviews from './components/ProductReviews.vue';

export default {
  name: 'App',
  components: {
    ProductReviews
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px auto 0 auto;
  max-width: 800px;
}
</style>
