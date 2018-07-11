<template>

</template>

<script>
  import * as globals from '../common/globals'

  export default {
    name: "Logout",
    mounted() {
      globals.unsetUser();
      this.$router.push("/login")
    }
  }
</script>

<style scoped>

</style>
