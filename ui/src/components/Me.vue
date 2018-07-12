<template>
  <div>
    <md-card style="margin: 0;">
      <md-card-header>
        <md-card-header-text>
          <div class="md-title">{{ currentUser.nickname }}</div>
          <div class="md-subhead">{{ currentUser.username }}</div>
        </md-card-header-text>
        <md-card-media>
          <img :src="currentUser.avatarUrl"/>
        </md-card-media>
      </md-card-header>
    </md-card>
    <md-list class="md-double-line">
      <template v-for="item in ['lorem', 'ipsum', 'dolor', 'sit', 'amet', 'consectetur', 'adipisicing']">
        <md-list-item href="#">
          <md-icon class="md-primary">label</md-icon>
          <div class="md-list-item-text">{{item}}</div>
        </md-list-item>
        <md-divider/>
      </template>
      <md-list-item to="/logout">
        <md-icon class="md-primary">motorcycle</md-icon>
        <div class="md-list-item-text">Logout</div>
      </md-list-item>
    </md-list>
  </div>
</template>

<script>
  export default {
    name: "Me"
  }
</script>

<style scoped>
  .md-list {
    /*width: 100%;*/
  }

</style>
