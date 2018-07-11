<template>
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
