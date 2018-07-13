<template>
  <div style="margin: -16px">
    <div v-for="section in home">
      <el-carousel v-if="section['type'] === 'BANNERS'" :interval="5000" height="100%">
        <el-carousel-item v-for="(item, index) in section['content']" :key="index">
          <img :src="item['imageUrl']" style="height: 100%; width: 100%;"/>
        </el-carousel-item>
      </el-carousel>
      <div v-else-if="section['type'] === 'HTML'" v-html="section['content']"></div>
      <div v-else-if="section['type'] === 'GOODS'">
        <h1>{{ section['content']['title'] }}</h1>
        <div style="display: flex; flex-wrap: wrap;">
          <el-card v-for="item in section['content']['goodsItems']" style="width: 50%;">
            <img :src="item['imageUrl']">
            <div style="padding: 14px;">
              <span class="md-title">{{ item["title"] }}</span>
            </div>
          </el-card>
        </div>
      </div>
      <h1 v-else>Unsupported content</h1>
    </div>
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
  .el-carousel {
    /*width: 100vw;*/
    height: calc(100vw * 9 / 16);
    .el-carousel__container {
      .el-carousel__item {
        background: lightgrey;
      }
    }
  }
</style>
