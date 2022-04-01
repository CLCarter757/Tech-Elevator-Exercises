<template>
  <div>
      <p>The value of parameter 1 is {{ parameter1 }}</p>
      <p>The value of parameter 2 is {{ parameter2 }}</p>
      <p>The value of sumParameters is {{ sumParameters }}</p>
  </div>
</template>

<script>
export default {
    // props: ["parameter1", "parameter2"],

    props: {
        parameter1: {
            type: Number,
            required: false,
            default: 1
        },
        parameter2: {
            type: Number,
            required: false,
            default: 4
        },
    },

    computed: {
        sumParameters() {
            return this.parameter1 + this.parameter2;
        }
    }
}
</script>

