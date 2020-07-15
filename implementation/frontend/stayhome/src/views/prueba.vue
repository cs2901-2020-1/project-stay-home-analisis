<template>

  <div >

    <h1>Videos: </h1>
    <v-container></v-container>


<div v-for="user in users" :key="user.user_id">
       

</div>
<h1> {{this.$route.params.id}}</h1>


</div>
  
  
  


</template>

<script>

  import {mapState} from 'vuex';

  export default {

    data(){
      return {
      }

    },

    computed: {
            ...mapState(['currentUser']),
            ...mapState(['articles']),
            ...mapState(['users']),

        },
        mounted(){
            this.$store.dispatch("loadAll")
            this.$store.dispatch("loadAllArticles")
        },

  }

</script>