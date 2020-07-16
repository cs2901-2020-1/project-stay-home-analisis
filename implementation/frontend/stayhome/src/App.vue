<template>
  <v-app>
    <v-app-bar app color=#009688 >
      <v-toolbar-title class="headline text-uppercase">
                 <v-btn  class="white--text" text to ="/" >STAYHOME  </v-btn>

      </v-toolbar-title>
      <div>
        <v-img src="../public/img/Logo_stay.png"
         max-width="50"
         max-height="50"
        ></v-img>
      </div>
      <v-spacer></v-spacer>
      <div v-if="currentUser.username">
         <v-menu
        bottom
        offset-y
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            class="white--text"
            v-bind="attrs"
            v-on="on"
            dark
          >{{currentUser.username}}</v-btn>
        </template>
        <v-list>
          <v-list-item
            @click="inicio"
            v-if="currentUser.admin==false"
          >
            <v-list-item-title>Inicio</v-list-item-title>
          </v-list-item>
           <v-list-item
            @click="buscar"
            v-if="currentUser.admin==true"
          >
            <v-list-item-title>Solicitudes</v-list-item-title>
          </v-list-item>

          <v-list-item
            @click="admin"
            v-if="currentUser.admin == false"
          >
            <v-list-item-title> Administrar Perfil </v-list-item-title>
          </v-list-item>

          <v-list-item
            @click="upload"
            v-if="currentUser.admin == false"
          >
          <v-list-item-title>Subir Artículos</v-list-item-title>
           </v-list-item>

           <v-list-item
            @click="buscar"
            v-if="currentUser.admin == false"
          >
          <v-list-item-title>Buscar Artículos</v-list-item-title>
           </v-list-item>

           <v-list-item
            @click="logoutUser"
          >
          <v-list-item-title>Cerrar sesión</v-list-item-title>
           </v-list-item>

        </v-list>
      </v-menu>

      </div>
      <div v-else>
         <v-btn  class="white--text" text to="/login">Iniciar sesión</v-btn>
         <v-btn  class="white--text" text to="/registration">Registrarse</v-btn>
      </div>
    </v-app-bar>
    <v-content>
      <router-view />
    </v-content>
    <v-footer
    dark
    padless
  >
    <v-card
      class="flex"
      flat
      tile
    >
      <v-card-title class="teal">
        <v-btn class="subheading">¡Contáctanos!</v-btn>

        <v-spacer></v-spacer>

        <v-btn  class="white--text" > ©Copyright </v-btn>
      </v-card-title>

      <v-card-text class="py-2 white--text text-center">
        {{ new Date().getFullYear() }} — <strong>StayHome</strong>
      </v-card-text>
    </v-card>
  </v-footer>
  </v-app>
</template>

<script>

import {mapState} from 'vuex';

export default {
  name: 'App',
  components: {
  },
  computed: {
    ...mapState(['currentUser'])
  },
  methods: {
    logoutUser(){
      this.$store.dispatch("logoutUser");
      alert('Vuelva Pronto');
      this.$router.push('/');
    },
    inicio(){
      this.$router.push("/myplaylists")
    },
    admin(){
      this.$router.push("/update")
    },
    upload(){
      this.$router.push("/upload")
    },
    buscar(){
      this.$router.push("/buscar")
    }
  },

  data: () => ({
  }),


};
</script>
