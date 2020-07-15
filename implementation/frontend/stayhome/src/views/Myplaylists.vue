<template>

<v-container >

    <div class="text-center">
        <div  v-for="articlepack in articlepacks" :key="articlepack.articlepack_id">    
        {{articlepack.name}}
    <v-dialog
      v-model="dialog"
      width="500"
    >
      <template v-slot:activator="{ on, attrs }">

             

        <v-btn
          color="red lighten-2"
          dark
          v-bind="attrs"
          v-on="on"
        >
          Crear paquete de artículos
        </v-btn>
      </template>

      <v-card>
 
        <v-card-title
          class="headline grey lighten-2"
          primary-title
        >
          Paquete de artículos
        </v-card-title>

        <v-card-text>
             <v-text-field v-model="playlist.name" > Ingresa el nombre del paquete de artículos</v-text-field>
            
        </v-card-text>

        <v-divider></v-divider>

        <v-card-actions>
        <v-btn
            color="primary"
            text
            @click="addarticle"
          >
            Crear
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn
            color="primary"
            text
            @click="dialog = false"
          >
            Cerrar
          </v-btn>
        </v-card-actions>
      </v-card>
   
    </v-dialog> 
            </div>

  </div>
    

    </v-container>
</template>



<script>
import { mapState } from 'vuex';


export default {

   data () {
      return {
        dialog: false,

      playlist: { 
          name:'',
      }
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

        async addarticle(){

            console.log(this.name)
             let reponse_articlepack = await this.$store.dispatch('addArticlepack',this.playlist);
             console.log(reponse_articlepack)

        }

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