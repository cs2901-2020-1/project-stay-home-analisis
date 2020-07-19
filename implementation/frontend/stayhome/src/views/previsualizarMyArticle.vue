<template>

<v-container >

<v-row justify="center" v-if="currentArticle.tipo[0] == 'i'">

  <v-row>
    <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <router-link  to="/buscar"> <v-text class="estiloT" color="blue"> StayFiles </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <v-text class="estiloT" color="grey"> StayFile </v-text> 
  </v-row>

<v-container></v-container>

<v-row justify="center">
  <v-text  class="estilo"> Título:  <v-text class="estilo">  {{currentArticle.title}} </v-text></v-text>
</v-row>

<v-container></v-container>

    <v-card
    class="estiloinCard"
    max-width="1000"
    color=#FFC400
  >
    <v-img
      :src="'https://stayhome-backend.herokuapp.com/downloadFile/'+ currentArticle.article_id"
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
        <v-card-text>

        <v-text class="estiloD">{{currentArticle.descripcion}}</v-text>

        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>

  <v-container/>
  <v-container/>


</v-row>





<v-row justify="center" v-else-if="currentArticle.tipo[0] == 'v'">

   <v-row>
    <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <router-link  to="/buscar"> <v-text class="estiloT" color="blue"> Artículos </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <v-text class="estiloT" color="grey"> Artículo </v-text> 
  </v-row>

<v-container></v-container>

<v-row justify="center">
  <v-text  class="estilo"> Título:  <v-text class="estilo">  {{currentArticle.title}} </v-text></v-text>
</v-row>




<v-container/>
<v-container/>


        <v-card
          class="estiloinCard"
          max-width="1000"
          color=#FFC400
        >



        <video 
          controls
          widht="340" 
          height="340" 
          >
          <source v-bind:src="require(`../../../../backend/demo/src/main/resources/Files/${currentArticle.nombre}`)" type="video/mp4" />
        </video>


    <v-card-title>
      <v-text class="estiloD"> Tema: {{currentArticle.tema}} </v-text>
    </v-card-title>

    <v-spacer/>


    <v-card-subtitle>
      
      
      <v-text class="estiloD"> Subido por: {{currentArticle.user.username}} </v-text>
      

    </v-card-subtitle>

    <v-card-actions>
     
    
      <v-row justify="center">
      <v-btn
        icon
        @click="show = !show"
        small
      >
        <v-icon >{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon> <v-text class="estiloT"> más información </v-text>
      </v-btn>
      </v-row>
  
    </v-card-actions>
    

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>
        <v-card-text>

        <v-text class="estiloD">{{currentArticle.descripcion}}</v-text>

        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>

  <v-container/>
  <v-container/>
</v-row>








<v-row justify="center"  v-else-if="currentArticle.tipo[0] == 'a'">

<v-container></v-container>
<v-container></v-container>
<v-container></v-container>


<v-row>
    <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <router-link  to="/buscar"> <v-text class="estiloT" color="blue"> Artículos </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <v-text class="estiloT" color="grey"> Artículo </v-text> 
  </v-row>

<v-container></v-container>

<v-row justify="center">
  <v-text  class="estilo"> Título:  <v-text class="estilo">  {{currentArticle.title}} </v-text></v-text>
</v-row>




<v-container/>
<v-container/>


        <v-card
          class="estiloinCard"
          max-width="1000"
          color=#FFC400
        >


<iframe src="http://www.colvema.org/pdf/consejos/origenperrogato.pdf" width="900" height="780" style="border: none;"></iframe>


    <v-card-title>
      <v-text class="estiloD"> Tema: {{currentArticle.tema}} </v-text>
    </v-card-title>

    <v-spacer/>


    <v-card-subtitle>
      
      
      <v-text class="estiloD"> Subido por: {{currentArticle.user.username}} </v-text>
      

    </v-card-subtitle>

      
    <v-card-actions>
    
      <v-row justify="center">
      <v-btn
        icon
        @click="show = !show"
        small
      >
        <v-icon >{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon> <v-text class="estiloT"> más información </v-text>
      </v-btn>
      </v-row>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>
        <v-card-text>

        <v-text class="estiloD">{{currentArticle.descripcion}}</v-text>

        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>

  <v-container/>
  <v-container/>
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
        ...mapState(['articles_por_tupac'])

      
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
       alert('Se agrego el StayFile a ' + this.article_to_pack.doublei.articlepack.name)
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
   font-size: 20px;
 }   

 
 
 .estiloinCard{

    border-radius: 30px;
    justify: center;
    


  } 
  .estiloD{
   font-size: 20px;
   text-align: center;
 }  

.estiloS{
   font-size: 29px;
 }  

  .estiloTexto{
   color: white;
   font-size:20px;
   
 } 
  .estiloTextoT{
   color: white;
   font-size:320px;
   
 }


</style>