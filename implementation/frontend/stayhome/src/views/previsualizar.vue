<template>

<v-container v-if="currentUser.admin == true">


<v-row  v-if="currentArticle.tipo[0] == 'i'">

  <v-container></v-container>

  <router-link  to="/buscar"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <v-text class="estiloT" color="grey"> Solicitudes </v-text> 

  <v-container></v-container>

<v-row justify="center">
    <v-text  class="estilo"> Título:  <v-text class="estilo">  {{currentArticle.title}} </v-text></v-text>

</v-row>

<v-container></v-container>

  <v-row justify="center">
    
    <v-card
    class="estiloinCard"
    max-width="1000"  
  >
    <v-img
      :src="currentArticle.link"
      height="600px"
    ></v-img>

    
    <v-card-title>
      <v-text class="estiloD"> Tema: {{currentArticle.tema}} </v-text>
    </v-card-title>

    <v-spacer/>
    <v-card-subtitle>
      <v-text class="estiloD"> Subido por: {{currentArticle.user.username}} </v-text>
    </v-card-subtitle>

    <v-card-actions>
      
      <v-col>
        <v-col justify="center">
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        medium @click="Validar(currentArticle)"> Validar
        </v-btn>
      </v-col>
      <v-col justify="center">
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        medium @click="Eliminar(currentArticle)">Eliminar
        </v-btn>
        </v-col>
    </v-col>
      <v-col >
        <v-row justify="center">
      <v-btn
      
        icon
        @click="show = !show"
        small
        
      >
        <v-icon >{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon> <v-text class="estiloT"> más información </v-text>
      </v-btn>
      </v-row>
      </v-col>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text >
    
        <v-text class="estiloD">{{currentArticle.descripcion}} </v-text>
       
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
</v-row>
</v-row>




<v-row  v-else-if="currentArticle.tipo[0] == 'v'">

  <v-row justify="left">
    <v-text  class="estilo"> {{currentUser.username}}  <v-text class="estiloP"> >> </v-text> <v-text class="estiloS">  Artículo </v-text></v-text>
  </v-row>

<v-container></v-container>

<v-row justify="center">
    <v-text  class="estilo"> Título:  <v-text class="estilo">  {{currentArticle.title}} </v-text></v-text>

</v-row>

<v-container/>

<v-row justify="center">
    <v-card
    class="estiloinCard"
    max-width="1000"
  >
  <video 
    controls
     widht="440" 
     height="540" 
    :src="currentArticle.link" type="video/mp4"
    >
  </video>

    <v-container/>

    <v-card-title>
      <v-text class="estiloD"> Tema: {{currentArticle.tema}} </v-text>
    </v-card-title>

    <v-spacer/>

    <v-card-subtitle>
     <v-text class="estiloD">  Subido por: {{currentArticle.user.username}} </v-text>
    </v-card-subtitle>

    <v-card-actions>
      <v-col>
        <v-col justify="center">
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        small @click="Validar(currentArticle)">Validar
        </v-btn>
      </v-col>
      <v-col justify="center">
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        small @click="Eliminar(currentArticle)">Eliminar
        </v-btn>
        </v-col>
    </v-col>
      <v-col >
        <v-row justify="center">
      <v-btn
      
        icon
        @click="show = !show"
        small
        
      >
        <v-icon >{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon> <v-text class="estiloD"> más información </v-text>
      </v-btn>
      </v-row>
      </v-col>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
    
        <v-text class="estiloT">{{currentArticle.descripcion}} </v-text>
       
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
</v-row>
  
</v-row>





<v-row  v-else-if="currentArticle.tipo[0] == 'a'">

<v-row justify="left">
    <v-text  class="estilo"> {{currentUser.username}}  <v-text class="estiloP"> >> </v-text> <v-text class="estiloT">  Artículo </v-text></v-text>

</v-row>

<v-container></v-container>


<v-row class="estiloT" justify="left">
   Tema: {{currentArticle.tema}}
</v-row>
<v-container></v-container>

<v-row  class="estiloT" justify="left">
   Título: {{currentArticle.title}}

</v-row>

<v-container></v-container>

<v-row  class="estiloT" justify="left">
  más información: {{currentArticle.descripcion}}

</v-row>



<v-container justify="center" >
  <v-col>
   <pdf :src="currentArticle.link" width="900" height="780" style="border: none;"></pdf>

</v-col>
<v-container></v-container>
<v-container></v-container>
<v-container></v-container>


<v-row justify="center">
        <v-col justify="center">
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        large @click="Validar(currentArticle)">Validar
        </v-btn>
      </v-col>
      <v-col justify="center">
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        large @click="Eliminar(currentArticle)">Eliminar
        </v-btn>
        </v-col>
    </v-row>


</v-container>







</v-row>

    </v-container>

    <v-container v-else>

      <v-alert
      prominent
      type="error"
    >
      <v-row justify="center" align="center">
        <v-col  class="grow" >
          Estimado {{currentUser.username}}, usted no tiene permisos para acceder a este contenido.
        </v-col>
        <v-spacer></v-spacer>

        <v-col>
          <v-btn @click="Home"> Página de inicio</v-btn>
        </v-col>
      </v-row>
    </v-alert>
    </v-container>
</template>



<script>
import pdf from 'vue-pdf'
import { mapState } from 'vuex';



export default {

 components: {
    pdf
  },
    
    data: () => ({
      show: false,
     
    }),


 computed: {

      currentArticle(){
          
          return this.$store.state.articles.find(ar => ar.article_id == this.$route.params.id)
          },

        ...mapState(['currentUser']),
        ...mapState(['articles']),
        ...mapState(['users']),

      
    },


    mounted(){
    this.$store.dispatch("loadAll");
    this.$store.dispatch("loadAllArticles");

   
    },


methods:{

  Home(){
      this.$router.push("/")
    },

async Validar(currentArticle){
        currentArticle.aceptado = true;
        let updated_article = await this.$store.dispatch("updateArticle",currentArticle);
          if(updated_article.error){
            alert(updated_article.error);
          }else{
            alert("Se ha validado correctamente")
          }
          this.$router.push("/buscar")
      },

      Eliminar(currentArticle){
        let response = confirm(`¿Estás seguro que deseas eliminar este StayFile? ${this.currentUser.username}`);
        if(response){
          this.$store.dispatch('deleteArticle',currentArticle);
          this.$router.push("/buscar");

        }
      }
},  

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
   font-size: 20px;
   
 }   
 .estiloinCard{

    border-radius: 30px;
    class:ma-4


  } 
  .estiloD{
   font-size: 25px;
   text-align: center;
 }  

.estiloS{
   font-size: 29px;
 }  


</style>