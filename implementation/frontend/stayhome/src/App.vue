<template>
  <v-app>
    <v-app-bar app color=#01579B >
      <v-toolbar-title class="headline text-uppercase">
                 <v-btn  class="white--text" text to="/" >STAYHOME  </v-btn>

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
        <v-list dark>
          <v-list-item
            @click="inicio"
            v-if="currentUser.admin==false"
          >
            <v-list-item-title> <v-icon> mdi-account-circle    </v-icon> Inicio   </v-list-item-title>
          </v-list-item>
           <v-list-item
            @click="buscar"
            v-if="currentUser.admin==true"
          >
            <v-list-item-title> <v-icon>mdi-account-alert</v-icon>Solicitudes</v-list-item-title>
          </v-list-item>

          <v-list-item
            @click="admin"
            v-if="currentUser.admin == false"
            
          >
            <v-list-item-title><v-icon > mdi-account-settings </v-icon> Administrar Perfil </v-list-item-title>
          </v-list-item>

          <v-list-item
            @click="upload"
            v-if="currentUser.admin == false"
          >
          <v-list-item-title><v-icon>mdi-folder-upload </v-icon>Subir StayFiles</v-list-item-title>
           </v-list-item>

           <v-list-item
            @click="buscar"
            v-if="currentUser.admin == false"
          >
          <v-list-item-title> <v-icon>mdi-file-search </v-icon>Buscar StayFiles</v-list-item-title>
           </v-list-item>

           <v-list-item
            @click="logoutUser"
          >
          <v-list-item-title> <v-icon>mdi-exit-to-app</v-icon>Cerrar Sesión</v-list-item-title>
           </v-list-item>

        </v-list>
      </v-menu>

      </div>
      <div v-else>
         <v-btn  class="white--text" text to="/login">Iniciar sesión</v-btn>
         <v-btn  class="white--text" text to="/registration">Registrarse</v-btn>
      </div>
    </v-app-bar>
    <v-content class="estiloFondo">
      <router-view />
    </v-content>
    
    <v-footer
    color=#01579B
  >
    <v-card
      class="flex"
      flat
      color=#01579B
    >
      <v-card-title color=#01579B >

        <v-btn class="subheading" color="dark" dark @click="contacto" >¡Contáctanos!</v-btn>

        <v-spacer></v-spacer>

        <v-btn  class="white--text" dark color="dark" href="https://www.indecopi.gob.pe/" > ©Copyright </v-btn>
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
    },
    contacto(){
      this.$router.push("/contactanos")
    },
    
  },

  data: () => ({
  }),


};
</script>

<style scoped>

.estiloFondo{
    background-color: #E0E0E0;
  } 
</style>