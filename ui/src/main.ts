import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueMaterial from 'vue-material'
import VueI18n from 'vue-i18n'
import VeeValidate from 'vee-validate';
import messages from './i18n/messages'
import 'vue-material/dist/vue-material.min.css'
import 'vue-material/dist/theme/default.css'

Vue.config.productionTip = false;
Vue.use(VueMaterial);
Vue.use(VueI18n);
Vue.use(VeeValidate);

const i18n = new VueI18n({
  locale: 'zh',
  messages
});

new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: {App},
  i18n
});
