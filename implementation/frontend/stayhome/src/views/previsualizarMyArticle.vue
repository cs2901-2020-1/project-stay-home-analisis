<template>

<v-container >

<v-row  v-if="currentArticle.tipo[0] == 'i'">

  
  <v-row justify="left">

    <router-link  to = "/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
    
    <v-icon >mdi-chevron-right</v-icon>
   <v-text class="estiloT" color="grey"> Mi Artículo </v-text> 


    
  
</v-row>


    



<v-container></v-container>

<v-row justify="center">
    <v-text  class="estiloT"> Título:  <v-text class="estiloT">  {{currentArticle.title}} </v-text></v-text>

</v-row>

<v-container></v-container>

    <v-card
    class="mx-auto"
    max-width="1000"
  >
    <v-img
      v-bind:src="require(`../../../../backend/demo/src/main/resources/Files/${currentArticle.nombre}`)" 
      height="600px"
    ></v-img>

    <v-card-title>
      Tema: {{currentArticle.tema}}
    </v-card-title>

    <v-card-subtitle>
        <div  v-for="user in users" :key="user.user_id">
            <div v-if="user.user_id == currentArticle.user_id">
                Subido por: {{user.username}}
            </div>
        </div>
    </v-card-subtitle>

    <v-card-actions>
     
      <v-col >
        <v-row justify="center">
      <v-btn
      
        icon
        @click="show = !show"
        small
        
      >
        <v-icon >{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon> <v-text > Descripción </v-text>
      </v-btn>
      </v-row>
      </v-col>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
    
        {{currentArticle.descripcion}}
       
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
</v-row>




<v-row  v-else-if="currentArticle.tipo[0] == 'v'">
 <v-row justify="left">
    <v-text  class="estilo"> Tema  <v-text class="estiloP"> >> </v-text> <v-text class="estiloT">  {{currentArticle.tema}} </v-text></v-text>

</v-row>

<v-container></v-container>

    <v-card
    class="mx-auto"
    max-width="1000"
  >
  <video 
    controls
     widht="240" 
     height="240" 
    >
    <source v-bind:src="require(`../../../../backend/demo/src/main/resources/Files/${currentArticle.nombre}`)" type="video/mp4" />
  </video>


    <v-card-title>
      Título: {{currentArticle.title}}
    </v-card-title>

    <v-card-subtitle>
        <div  v-for="user in users" :key="user.user_id">
            <div v-if="user.user_id == currentArticle.user_id">
                Subido por: {{user.username}}
            </div>
        </div>
    </v-card-subtitle>

    <v-card-actions>
      <v-col>
        <v-col justify="center">
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        small :href="'http://localhost:9898/downloadFile/'+ currentArticle.article_id"> Descargar
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
        <v-icon >{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon> <v-text > Descripción </v-text>
      </v-btn>
      </v-row>
      </v-col>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
        {{currentArticle.descripcion}}
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
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
  Descripción: {{currentArticle.descripcion}}

</v-row>



<v-container justify="center" >
  <v-col>
   <iframe src="http://www.colvema.org/pdf/consejos/origenperrogato.pdf" width="900" height="780" style="border: none;"></iframe>

</v-col>
<v-container></v-container>
<v-container></v-container>
<v-container></v-container>

</v-container>



</v-row>


    </v-container>

</template>



<script>
import { mapState } from 'vuex';

import Api from "@/services/api";

export default {

    
    data () {
      return {
         dialog:false,
         show: false,
          article_to_pack:{
          doublei: {
                articlepack: [],
                article: []
            }

          },



        items: [
        {
          text: 'Inicio',
          disabled: false,
          href: 'http://localhost:8080/myplaylists',
          
        },
        {
          text: 'Artículos',
          disabled: false,
          href: 'http://localhost:8080/buscar',
        },
        {
          text: 'Artículo',
          disabled: true,
        
        },
      ],





    }
   },


 computed: {

      currentArticle(){
          
          return this.$store.state.articles.find(ar => ar.article_id == this.$route.params.id)
          },

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


methods:{

  Home(){
      this.$router.push("/")
    },

  down(){
            this.$router.push("/download")
        },

  async addArticletoPack(articlepack)
   {
     this.article_to_pack.doublei.article = this.currentArticle;
     this.article_to_pack.doublei.articlepack = articlepack;
     console.log(this.article_to_pack);
     let response = await Api().post("/articlesporpack/",this.article_to_pack);
     console.log(response)
     if(response.error){
       alert(response.error)
     }else{
       alert('Se agrego el articulo a ' + this.article_to_pack.doublei.articlepack.name)
       this.$router.go(0);//MAGIA//
     }
/*
     let list_ids = [];
     let articlepack_response = await Api().get(`/articlesporpack/${this.article_to_pack.doublei.articlepackid}`);
     for(var i = 0; i < articlepack_response.data.length; i++){
          list_ids[i] = articlepack_response.data[i].doublei.article_id;
     }
     console.log(list_ids);
   
*/
   },     

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