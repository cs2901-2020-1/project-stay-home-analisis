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
        <v-btn  class="white--text" text to="/mainpage" > {{currentUser.username}} </v-btn>
        <v-btn  class="white--text" text @click="logoutUser">Logout</v-btn>
      </div>
      <div v-else>
         <v-btn  class="white--text" text to="/login">Login</v-btn>
         <v-btn  class="white--text" text to="/registration">Register</v-btn>
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
    }
  },

  data: () => ({
  }),





};
</script>
