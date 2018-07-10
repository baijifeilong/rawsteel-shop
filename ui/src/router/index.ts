import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello.vue'
import NotFound from '@/components/NotFound.vue'
import Login from '@/components/Login.vue'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      component: Login
    },
    {
      path: '/404',
      name: 'NotFound',
      component: NotFound
    }, {
      path: '*',
      redirect: '/404'
    },
    {
      path: '/',
      name: 'Hello',
      component: Hello
    }
  ]
})
