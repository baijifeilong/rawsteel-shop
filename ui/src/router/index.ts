import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home.vue'
import NotFound from '@/components/NotFound.vue'
import Login from '@/components/Login.vue'
import Logout from '@/components/Logout.vue'
import Foo from '@/components/Foo.vue'
import Bar from '@/components/Bar.vue'
import Baz from '@/components/Baz.vue'
import Root from '@/components/Root.vue'
import Me from '@/components/Me.vue'
import * as globals from '../common/globals'

Vue.use(Router);

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      name: 'login',
      component: Login
    }, {
      path: '/logout',
      name: 'logout',
      component: Logout
    }, {
      path: '/404',
      name: 'notFound',
      component: NotFound
    }, {
      path: '*',
      redirect: '/404'
    }, {
      path: '/',
      name: 'root',
      component: Root,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'home',
          component: Home
        }, {
          path: '/foo',
          name: 'foo',
          component: Foo
        }, {
          path: '/bar',
          name: 'bar',
          component: Bar
        }, {
          path: '/baz',
          name: 'baz',
          component: Baz
        }, {
          path: '/me',
          name: 'me',
          component: Me
        }
      ]
    }
  ]
});

router.beforeEach((to, from, next) => {
  const online: boolean = globals.getUser().online;
  const accessLoginUrl = to.name === 'login';
  const accessProtectedUrl = !accessLoginUrl;
  if (!online && accessProtectedUrl) {
    console.log("Offline and access protected url");
    router.push({name: 'login'})
  } else if (online && accessLoginUrl) {
    console.log("Online and access login url");
    router.push({name: 'home'})
  }
  next();
});

export default router;
