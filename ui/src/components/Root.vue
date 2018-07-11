<template>
  <div class="page-container">
    <md-app md-waterfall md-mode="reveal">
      <md-app-toolbar class="md-primary">
        <md-button class="md-icon-button" @click="menuVisible=!menuVisible">
          <md-icon>menu</md-icon>
        </md-button>
        <span class="md-title">My Title</span>
      </md-app-toolbar>
      <md-app-drawer :md-active.sync="menuVisible">
        <md-toolbar class="md-transparent" md-elevation="0">Navigation</md-toolbar>
        <md-list>
          <md-list-item>
            <md-icon>move_to_inbox</md-icon>
            <span class="md-list-item-text">Inbox</span>
          </md-list-item>
          <md-list-item>
            <md-icon>send</md-icon>
            <span class="md-list-item-text">SendMail</span>
          </md-list-item>
          <md-list-item>
            <md-icon>delete</md-icon>
            <span class="md-list-item-text">Trash</span>
          </md-list-item>
          <md-list-item>
            <md-icon>error</md-icon>
            <span class="md-list-item-text">Spam</span>
          </md-list-item>
        </md-list>
      </md-app-drawer>
      <md-app-content>
        <router-view/>
      </md-app-content>
    </md-app>
    <div class="phone-viewport">
      <md-bottom-bar class="md-accent">
        <md-bottom-bar-item md-label="Home" md-icon="home"></md-bottom-bar-item>
        <md-bottom-bar-item md-label="Home" md-icon="error"></md-bottom-bar-item>
        <md-bottom-bar-item md-label="Home" md-icon="favorite"></md-bottom-bar-item>
        <md-bottom-bar-item md-label="Home" md-icon="favorite"></md-bottom-bar-item>
      </md-bottom-bar>
    </div>
  </div>
</template>

<script lang="ts">
  export default {
    name: "AppLayout",
    data: () => ({
      menuVisible: false
    }),
  }
</script>

<style scoped lang="less">
  .page-container {
    height: 100%;
    display: flex;
    flex-direction: column;

    .md-app {
      flex-grow: 1;
      border-bottom: 1px solid darkgray;

      .md-drawer {
        width: 180px;
      }
    }
  }
</style>
