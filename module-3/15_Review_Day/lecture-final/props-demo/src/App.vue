<template>
  <div id="app">
    <props-demo v-bind:parameter1="2" v-bind:parameter2="5" />

    <user-list></user-list>
  </div>
</template>

<script>
import PropsDemo from "./components/PropsDemo.vue";
import UserList from "./components/UserList.vue";

export default {
  name: "app",
  components: {
    PropsDemo,
    UserList
  },
  computed: {
    onePlusOne() {
      return 1 + 1;
    }
  }
};
</script>
