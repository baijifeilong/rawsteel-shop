<template>
  <div class="my-not-found">
    <h1>404 Not Found</h1>
    <div class="my-container">
      <md-content class="my-box md-elevation-5" :key="item" v-for="item in [1,2,3,4,5]">{{item}}</md-content>
    </div>

    <div class="md-layout md-gutter">
      <div class="md-layout-item">item</div>
      <div class="md-layout-item">item</div>
      <div class="md-layout-item">item</div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "NotFound"
  }
</script>

<style scoped lang="less">

  .my-not-found {
    .my-container {
      display: flex;
      flex-wrap: wrap;
      padding: 16px;
      .my-box {
        width: 100px;
        height: 100px;
        background: yellowgreen;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 24px;
      }
    }
  }

  .md-layout-item {
    border: 1px solid beige;
    height: 120px;
    background: aliceblue;
  }

</style>
