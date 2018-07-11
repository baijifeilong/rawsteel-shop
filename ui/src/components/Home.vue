<template>
  <div>
    <h1>Home</h1>
    <span>
    This is {{ user }}
    </span>
  </div>
</template>

<script>
  import * as globals from '../common/globals'

  export default {
    name: "Home",
    data: () => ({
      user: globals.getUser()
    })
  }
</script>

<style scoped>

</style>
