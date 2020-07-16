import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import UserLogin from '../views/UserLogin.vue'
import UserRegistration from '../views/UserRegistration.vue'
import Buscar from '../views/Buscar.vue'
import UserUpdate from '../views/UserUpdate.vue'
import UserUpload from '../views/UserUpload'

import prueba from '../views/prueba'
import previsualizar from '../views/previsualizar'
import previsualizarUser from '../views/previsualizarUser'
import Myplaylists from '../views/Myplaylists'

import Playlist from '../views/Playlist.vue'


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
    path: '/buscar',
    name: 'mainpage',
    component: Buscar
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
   },
   {
     path:"/prueba/:id",
     name:'prueba',
     component:prueba,
     params: true
   },
   {
    path:"/previsualizar/:id",
    name:'previsualizar',
    component:previsualizar,
    params: true
  },
  {
    path:"/previsualizarUser/:id",
    name:'previsualizarUser',
    component:previsualizarUser,
    params: true
  },

  {
    path:"/mainpage",
    name:'Myplaylists',
    component: Myplaylists,
    
  },
  
  {

    path:"/Playlist",
    name:'Playlist',
    component: Playlist,
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
