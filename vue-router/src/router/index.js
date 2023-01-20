import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHashHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
      // redirect: { name: 'session'}
      alias: ['/home']
    },
    {
      path: '/session',
      name: 'session',
      component: () => import('../views/SessionView.vue'),
      children: [
        {
          path: '/',
          components: {
            default: () => import('../views/LoginView.vue'),
            register: () => import('../views/RegisterView.vue'),
          }
        }
      ]
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/chats',
      name: 'chats',
      component: () => import('../views/ChatsView.vue'),
      children: [
        {
          path: ':id',
          name: 'chat',
          component: () => import('../views/ChatView.vue'),
          props: (route) => ({
            id: route.params.id
          })
        }
      ]
    }    
  ]
})

router.beforeEach((to, from) => {
  console.log(to, from)

  if(to.path === '/') return { name: 'about'}
  return true
})

export default router
