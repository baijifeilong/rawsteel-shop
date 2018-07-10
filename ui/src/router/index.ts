import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello.vue'
import NotFound from '@/components/NotFound.vue'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/404',
      name: 'NotFound',
      component: NotFound
    }
  ]
})
