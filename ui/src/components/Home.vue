<template>
  <div>
    <h1>Home</h1>
    <span>
    This is {{ home }}
    </span>
  </div>
</template>

<script>
  import homeApi from '../api/homeApi'

  export default {
    name: "Home",
    data: () => ({
      home: 'nothing'
    }),
    mounted: function () {
      homeApi.index().then(data => this.home = data)
    }
  }
</script>

<style scoped>

</style>
