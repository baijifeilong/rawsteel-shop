<template>
  <form class="md-layout md-alignment-center" @submit.prevent="doLogin">
    <md-card class="md-layout-item md-size-50 md-small-size-100">
      <md-card-header>
        <div class="md-title">{{$t('login.login')}}</div>
      </md-card-header>
      <md-card-content>
        <md-field :class="errors.has('username')?'md-invalid': ''">
          <label>{{$t('login.username')}}</label>
          <md-input v-model="form.username" v-validate="'required|min:4'" name="username"/>
          <span class="md-error">{{ errors.first('username') }}</span>
        </md-field>
        <md-field :class="errors.has('password')?'md-invalid': ''">
          <label>{{$t('login.password')}}</label>
          <md-input v-model="form.password" v-validate="'required|min:4'" name="password"/>
          <span class="md-error">{{ errors.first('password') }}</span>
        </md-field>
      </md-card-content>
      <md-card-actions>
        <md-button type="submit" class="md-primary">{{$t('login.login')}}</md-button>
      </md-card-actions>
    </md-card>
  </form>
</template>

<script lang="ts">
  import userApi from '../api/userApi'
  import * as globals from '../common/globals'

  export default {
    name: "Login",
    data: () => ({
      form: {
        username: '',
        password: ''
      }
    }),
    methods: {
      doLogin() {
        console.log("doLogin");
        userApi.login(this.form.username, this.form.password).then(user => {
          globals.setUser(user);
          this.$router.push({name: 'home'})
        })
      }
    }
  }
</script>

<style scoped lang="less">
</style>
