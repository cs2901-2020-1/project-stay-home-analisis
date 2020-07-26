<template>

<v-container v-if="currentUser.admin == false" >

<v-row>

    <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <v-text class="estiloT" color="grey"> Inicio </v-text> 
  
</v-row>

<v-container/>



<div class="text-center" >

  <v-row>
    <v-col>
      <v-text class="estilo">Mis StayPacks</v-text>
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
              <v-icon color="white">
               mdi-package-up
              </v-icon>
              Crea un StayPack
              </v-btn>
            </template>

            <v-card v-model="valid" class="estiloinCard">
            
            <v-container/>
            <v-container/>
            <v-card-text>
                  <v-card class="estiloSubCard" height="100px" width="800px">
                    <v-row justify="center">
                      <div class="display-4">
                        <v-avatar tile color=#01579B>
                          <v-icon x-large color=#FFFFFF>mdi-account</v-icon>
                        </v-avatar>
                      </div>
                      <v-col justify="center" md="8">
                        <v-text-field v-model="playlist.name" label="Nombre del StayPack" :rules="nombreRules"/>
                      </v-col>
                    </v-row>
                    <v-container/>
                  </v-card>
                  <v-container/>
                  <v-card class="estiloSubCard" height="100px" width="800px">
                    <v-row justify="center">
                      <div class="display-4">
                        <v-avatar tile color=#01579B>
                          <v-icon x-large color=#FFFFFF>mdi-lock</v-icon>
                        </v-avatar>
                      </div>
                      <v-col justify="center" md="8">
                        <v-text-field v-model="playlist.descripcion" label="Descripción" :rules="descripcionRules"
                          
                        />
                      </v-col>
                    </v-row>
                    <v-container/>
                  </v-card>
                </v-card-text>

              <v-container></v-container>
             
              <v-divider></v-divider>
              <v-card-actions>
                <v-btn
                  dark
                  color="dark"
                  small
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

<v-row justify="center">

<v-card class="estiloinCard" color=#FFC400 >
<v-slide-group
        v-model="model"
         class="pa-4"
        prev-icon="mdi-minus"
        next-icon="mdi-plus"
        show-arrows
        dark
    >
     
        <div v-for="articlepack in articlepacks" :key="articlepack.articlepack_id">
        <div v-if="articlepack.user.user_id == currentUser.user_id">
         <v-slide-item >
        
        <v-col >
          
           <v-card  class="estiloinCardin"
                     height="450"
                    width="400"
                     color=#E53935
                              >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >

        <v-text class="estiloTexto" align="center">  

               <v-icon large>mdi-package</v-icon><v-text class="estiloTexto"> {{articlepack.name}} </v-text>
              
              </v-text> 

              <v-container/>

        
              <v-card max-width="400"
                      flat
                     color=#E53935 >
              <v-text class="estiloTexto" > {{articlepack.descripcion}} </v-text>  
              </v-card>


              <v-container/>

              <v-text class="estiloTexto"> #StayFiles: {{articlepack.contador}} </v-text>

              <v-container/>

              

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
                
                <v-container/>
                <v-btn large @click="eliminarArticlepack(articlepack)">Eliminar</v-btn>

              </v-row>




            
          </v-row>
        </v-card>
        </v-col>
      </v-slide-item>

        </div>
        </div>
    </v-slide-group>
</v-card>
</v-row>

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
            v => (v && v.length <= 280) || 'La descripcion tiene que tener menos de 280 caracteres',
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
        console.log( this.currentUser.contador_articlepack);
        let a =  this.currentUser.contador_articlepack + 1;
        this.currentUser.contador_articlepack = a;
        console.log( this.currentUser.contador_articlepack);
        let rpta = await this.$store.dispatch('updateUser',this.currentUser);
        console.log(rpta);
        this.playlist.user = this.currentUser;
        console.log(this.playlist);
        let reponse_articlepack = await this.$store.dispatch('addArticlepack',this.playlist);
        if(reponse_articlepack.error){
          alert(reponse_articlepack.error);
        }else{
          alert('El StayPack ' + reponse_articlepack.name + ' se ha creado correctamente');
            this.$router.go(0);//MAGIA//
        }
      },
      async eliminarArticlepack(articlepack){
        let response = confirm(`${this.currentUser.username} ¿Estás seguro que deseas eliminar ${articlepack.name}?`);
        if(response){

          let a =  this.currentUser.contador_articlepack - 1;
          this.currentUser.contador_articlepack = a;
          console.log( this.currentUser.contador_articlepack);
          let aa = await this.$store.dispatch('updateUser',this.currentUser);
          console.log(aa);


          let id = articlepack.articlepack_id;
          console.log(id);
          let rpta = await this.$store.dispatch('deleteArticlepack',id);
          if(rpta.error){
              alert(rpta.error);
            }else{
              alert("Se ha eliminado correctamente el StayPack");
              this.$router.go(0);//MAGIA//
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
.estiloSubCard{
    border-radius: 20px;
  } 
 .estiloinCard{
    border-radius: 30px;
    
  } 
  .estiloinCardin{
    border-radius: 15px;
    
  } 
</style>