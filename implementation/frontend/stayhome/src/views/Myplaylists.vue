<template>

<v-container >

    <div class="text-center">
        <div  v-for="articlepack in articlepacks" :key="articlepack.articlepack_id">
        {{articlepack.articlepack_id}}    
        {{articlepack.name}}
        </div>

  </div>
    

    </v-container>
</template>



<script>
import { mapState } from 'vuex';


export default {

   data () {
      return {
       
    }
   },
      
 computed: {

        ...mapState(['currentUser']),
        ...mapState(['articles']),
        ...mapState(['users']),
        ...mapState(['articlepacks']),

      
    },

    mounted(){

    this.$store.dispatch("loadAll");
    this.$store.dispatch("loadAllArticles");
    this.$store.dispatch("loadAllArticlepacks");

   
    },

    methods: {

    }
    

}



</script>

<style scoped>

.estilo {
        font-size:40px;
    }

.estiloP {
        font-size: 15px;
        font-family: "Lucida Console", Courier, monospace;
    }
 .estiloT{
   font-size: 25px;
 }   


</style>