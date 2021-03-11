import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify';



import VueVideoPlayer from 'vue-video-player'

import 'video.js/dist/video-js.css'

Vue.use(VueVideoPlayer, /* {
  options: global default options,
  events: global videojs events
} */)


import BootstrapVue from "bootstrap-vue"

Vue.use(BootstrapVue)

import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap-vue/dist/bootstrap-vue.css"


Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')