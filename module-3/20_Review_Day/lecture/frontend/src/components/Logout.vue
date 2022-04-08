<template>
  <a href="javascript:void(null)" @click.prevent="logout" class="logout-link">Logout</a>
</template>

<script>
export default {
  methods: {
    logout() {
      this.$store.commit("LOGOUT");
    }
  }
};
</script>

<style>
  .logout-link {
    width: 100%;
    display: inline-block;
    text-align: right;
  }
</style>