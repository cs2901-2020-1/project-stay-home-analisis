import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import UserLogin from '../views/UserLogin.vue'
import UserRegistration from '../views/UserRegistration.vue'
import StayHome from '../components/StayHome.vue'
import UserUpdate from '../views/UserUpdate.vue'
import UserUpload from '../views/UserUpload'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
   path: '/login',
   name: 'user-login',
   component: UserLogin
  },
  {
    path: '/registration',
    name: 'user-registration',
    component: UserRegistration
   },
   {
    path: '/mainpage',
    name: 'mainpage',
    component: StayHome
   },
   {
    path: '/update',
    name: 'user-update',
    component: UserUpdate
   },
   {
    path: '/upload',
    name: 'user-upload',
    component: UserUpload
   }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
