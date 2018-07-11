<template>

  <div>
    <h1>Foo</h1>
    <button @click="click">click me</button>
  </div>
</template>

<script lang="ts">
  import userApi from '../api/userApi'


  export default {
    name: "Foo",
    methods: {
      click() {
        console.log("clicked");
        userApi.login('apple', 'apple').then(user => {
          userApi.current().then(console.log)
        });
      }
    }
  }
</script>

<style scoped>

</style>
