<template>
  <div style="margin: -16px;">
    <el-carousel :interval="100000">
      <el-carousel-item v-for="(item, index) in banners" :key="index">
        <img :src="item['imageUrl']" style="height: 100%; width: 100%;"/>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
  import homeApi from '../api/homeApi'

  export default {
    name: "Home",
    data: () => ({
      home: []
    }),
    mounted: function () {
      homeApi.index().then(data => this.home = data)
    },
    computed: {
      banners: function () {
        if (this.home.length > 0) {
          return this.home[0]['content']
        } else {
          return []
        }
      }
    }
  }
</script>

<style scoped lang="less">
  .el-carousel__container {
    height: 100%;

    .el-carousel__item {
      background: lightgrey;
    }
  }
</style>
