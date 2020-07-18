<template>

<v-container v-if="currentUser.admin == false" >

<v-row>

    <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <v-text class="estiloT" color="grey"> Inicio </v-text> 
  
</v-row>

<div class="text-center" >

  <v-row>
    <v-col>
      <v-text class="estilo">Mis paquetes de artículos</v-text>
    </v-col>
    
    <v-col>
        <div>
          <v-dialog
            v-model="dialog"
            width="500"
            
          >
            <template v-slot:activator="{ on, attrs }">     
              <v-btn
                color="dark"
                dark
                v-bind="attrs"
                v-on="on"
                large
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
              <v-container></v-container>
              <v-card-text>
                <v-text-field v-model="playlist.name" label="Nombre del paquete" :rules="nombreRules" ></v-text-field>
                <v-text-field v-model="playlist.descripcion" label="Descripcion" :rules="descripcionRules"></v-text-field>
              </v-card-text>
              <v-divider></v-divider>
              <v-card-actions>
                <v-btn
                  dark
                  color="dark"
                  
                  @click="addarticle"
                  :disabled="!valid"
                >
                Crear
                </v-btn>
                <v-spacer></v-spacer>
                <v-btn
                  dark
                  color="dark"
                  
                  @click="dialog = false"
                >
                Cerrar
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog> 
        </div>
        </v-col>
        </v-row>
  </div>

<v-container></v-container>


<v-card
    max-width="920"
    class="mx-auto"
    dark
>

<v-container>

<v-item-group  >
     
     <v-row >
        <v-col
          v-for="articlepack in articlepacks" :key="articlepack.articlepack_id"
          cols="12"
            md="6"
        >
        <div v-if="articlepack.user.user_id == currentUser.user_id">
          <v-item class="estiloC" 
          >

            <v-card
              class="d-inline-block mx-auto"
              dark
              height="150"
              width="430"
              
              
            >

            <v-container></v-container>
            <v-row justify="center" >
              <v-text class="estiloT" > {{articlepack.name}} </v-text>
            </v-row>
            <v-row justify="center">
              <v-text class="estiloP" > {{articlepack.descripcion}} </v-text>
            </v-row>
            <v-row justify="center">
              <v-text class="estiloP" > Contador: {{articlepack.contador}} </v-text>
            </v-row>
            
            <v-container></v-container>

              <v-row justify="center" >
                
                <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                  medium 
                > 
                <v-icon left  large > mdi-folder-google-drive </v-icon> 
                <router-link class="white--text" :to="{ name: 'Playlist', params:{ id: articlepack.articlepack_id}}"> <v-text color="white">Ver </v-text> </router-link></v-btn>
                <v-btn @click="eliminarArticlepack(articlepack)">Eliminar</v-btn>
              </v-row>
            </v-card>
            
          </v-item>
        <v-container></v-container>
        
          </div>
        </v-col>
        </v-row>
  </v-item-group>
</v-container>
</v-card>

</v-container>
</template>



<script>
import { mapState } from 'vuex';


export default {

   data () {
      return {
        dialog: false,
        valid: false,

        nombreRules: [
            v => !!v || 'Nombre requirido',
            v => (v && v.length <= 20) || 'El nombre tiene que tener menos de 20 caracteres',
        ],
        descripcionRules: [
            v => !!v || 'Descripcion requirida',
            v => (v && v.length <= 1000) || 'La descripcion tiene que tener menos de 1000 caracteres',
        ],
        playlist: { 
            name:'',
            descripcion:'',
            contador: 0,
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
      },

      async eliminarArticlepack(articlepack){
        let response = confirm(`${this.currentUser.username} ¿Estás seguro que deseas eliminar ${articlepack.name}?`);
        if(response){
          let id = articlepack.articlepack_id;
          console.log(id);
          let rpta = await this.$store.dispatch('deleteArticlepack',id);
          if(rpta.error){
              alert(rpta.error);
            }else{
              alert("Se ha eliminado correctamente el paquete de articulos");
              this.$router.push("/myplaylists");
            }
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
 .estiloC{

        background-color: #00897B;

 }  





</style>