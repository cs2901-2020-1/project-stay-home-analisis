<template>

  <div >

    <h1>Videos: </h1>
    <v-container></v-container>


<div v-for="user in currentUser" :key="user.user_id">
        <v-text>hola</v-text>

</div>
</div>
  
  
  


</template>

<script>

  import {mapState} from 'vuex';

  export default {

    computed: {
            ...mapState(['currentUser']),
            ...mapState(['articles']),

        },
        mounted(){
            this.$store.dispatch("loadAll")
            this.$store.dispatch("loadAllArticles")
        },

  }

</script>