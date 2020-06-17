<template>
  <v-app>
    <v-app-bar app color="grey">
      <v-toolbar-title class="headline text-uppercase">
        <v-btn text to="/">StayHome</v-btn>
      </v-toolbar-title>
      <div>
        <v-img src="../public/img/StayHome.png"
         max-width="50"
         max-height="45"
        ></v-img>
      </div>
      <v-spacer></v-spacer>
      <div v-if="currentUser.username">
        {{currentUser.username}}
        <v-btn text class="mr-2" @click="logoutUser">Logout</v-btn>
      </div>
      <div v-else>
        <v-btn text class="mr-2" to="/login">Login</v-btn>
        <v-btn text class="mr-2" to="/registration">Register</v-btn>
      </div>
    </v-app-bar>
    <v-content>
      <router-view />
    </v-content>
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
    //
  }),
};
</script>
