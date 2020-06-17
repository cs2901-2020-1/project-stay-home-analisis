<template>
    <v-container>
      <h1>HOME</h1>
      <div v-for="user in users" :key ="user.user_id">
            <h1>
              USERNAME: {{user.username}}
              <v-btn x-small @click="loginUser(user)">Login</v-btn>
            </h1>
      </div>

    </v-container>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: 'Home',
  computed: {
    ...mapState(['users'])
  },
  mounted(){
    this.$store.dispatch("loadAll")
  },
  methods: {
    loginUser(user){
      this.$store.dispatch('loginUser',user);
    }
  },
}
</script>