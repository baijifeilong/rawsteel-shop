<template>
  <form class="md-layout md-alignment-center">
    <md-card class="md-layout-item md-size-50 md-small-size-100">
      <md-card-header>
        <div class="md-title">{{$t('login.login')}}</div>
      </md-card-header>
      <md-card-content>
        <md-field>
          <label>{{$t('login.username')}}</label>
          <md-input v-model="form.username"/>
        </md-field>
        <md-field>
          <label>{{$t('login.password')}}</label>
          <md-input v-model="form.password"/>
        </md-field>
      </md-card-content>
      <md-card-actions>
        <md-button class="md-primary">{{$t('login.login')}}</md-button>
      </md-card-actions>
    </md-card>
  </form>
</template>

<script lang="ts">
  export default {
    name: "Login",
    data: () => ({
      form: {
        username: '',
        password: ''
      }
    })
  }
</script>

<style scoped lang="less">
</style>
