<template>

<v-container >

    <div class="text-center">
        <div  v-for="articlepack in articlepacks" :key="articlepack.articlepack_id">
        {{articlepack.articlepack_id}}    
        {{articlepack.name}}
        {{articlepack.user.username}}
        {{articlepack.user.user_id}}
        </div>

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
        <v-card v-model="valid">
          <v-card-title
            class="headline grey lighten-2"
            primary-title
          >
          Paquete de artículos
          </v-card-title>

          <v-card-text>
             <v-text-field v-model="playlist.name" label="Nombre del paquete" :rules="nombreRules" > Ingresa el nombre del paquete de artículos</v-text-field>
          </v-card-text>

          <v-divider></v-divider>

          <v-card-actions>
            <v-btn
              color="primary"
              text
              @click="addarticle"
              :disabled="!valid"
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
    

    </v-container>
</template>



<script>
import { mapState } from 'vuex';


export default {

   data () {
      return {
        dialog: false,

        nombreRules: [
            v => !!v || 'Nombre requirido',
            v => (v && v.length <= 20) || 'El nombre tiene que tener menos de 20 caracteres',
        ],
        playlist: { 
            name:'',
            user:[]
        },
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

        this.playlist.user = this.currentUser;
        console.log(this.playlist);
        let reponse_articlepack = await this.$store.dispatch('addArticlepack',this.playlist);
        if(reponse_articlepack.error){
          alert(reponse_articlepack.error);
        }else{
          alert('El paquete ' + reponse_articlepack.name + ' se ha creado correctamente');
            this.$router.go(0);//MAGIA//
        }
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