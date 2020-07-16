import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '../views/Home.vue'
import UserLogin from '../views/UserLogin.vue'
import UserRegistration from '../views/UserRegistration.vue'
import Buscar from '../views/Buscar.vue'
import UserUpdate from '../views/UserUpdate.vue'
import UserUpload from '../views/UserUpload.vue'
import Previsualizar from '../views/previsualizar.vue'
import PrevisualizarUser from '../views/previsualizarUser.vue'
import Myplaylists from '../views/Myplaylists.vue'
import Playlist from '../views/Playlist.vue'
import previsualizarMyArticle from '../views/previsualizarMyArticle.vue'
import contactanos from '../views/contactanos.vue'


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
    name: 'articulos',
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
    path:"/previsualizar/:id",
    name:'previsualizar',
    component: Previsualizar,
    params: true
  },

  {
    path:"/previsualizarUser/:id",
    name:'previsualizarUser',
    component: PrevisualizarUser,
    params: true
  },

  {
    path:"/myplaylists",
    name:'Myplaylists',
    component: Myplaylists,
    
  },
  
  {
    path:"/playlist/:id",
    name:'Playlist',
    component: Playlist,
    params: true
  },

  {
    path:"/previsualizarMyArticle/:id",
    name:'previsualizarMyArticle',
    component: previsualizarMyArticle,
    params: true
  },

  {
    path:"/contactanos",
    name:'contactanos',
    component: contactanos,
   
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
