import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueMaterial from 'vue-material'
import VueI18n from 'vue-i18n'

import 'vue-material/dist/vue-material.min.css'
import 'vue-material/dist/theme/default.css'

Vue.config.productionTip = false;
Vue.use(VueMaterial);
Vue.use(VueI18n);

const i18n = new VueI18n({
  locale: 'zh',
  messages: {
    en: {
      'login.login': 'Login',
      'login.username': 'Username',
      'login.password': 'Password',
    },
    zh: {
      'login.login': '登录',
      'login.username': '用户名',
      'login.password': '密码',
    }
  }
});

new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: {App},
  i18n
});
