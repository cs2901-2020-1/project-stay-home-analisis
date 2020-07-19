<template>
<v-container>

<v-row justify="left">

    <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    
   <v-text class="estiloT" color="grey"> StayFiles </v-text> 
  
</v-row>


    <v-container>
<v-row>
    <div v-for="articles in articles_por_tupac" :key="articles.article_id">
    <v-col>
      <div  v-if="articles.doublei.article.curso == 'Matemática'">
            <v-card
            class="estiloinCardin"
                     height="180"
                    width="400"
                     color=#E53935
            >

    <v-list-item three-line>
        
      <v-list-item-content>
        <v-list-item-title class="headline mb-1" > <v-text class="estilotexto"> {{articles.doublei.article.title}} </v-text></v-list-item-title>

        <div class="overline mb-4"> <v-text class="estilotexto"> Curso: {{articles.doublei.article.curso}}</v-text> </div>


        <v-list-item-subtitle> <v-text class="estilotexto"> Tema: {{articles.doublei.article.tema}} </v-text> </v-list-item-subtitle>
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
      ><v-icon x-large color="white">
          mdi-library
      </v-icon>
      
      </v-list-item-avatar>


    </v-list-item>

    <v-card-actions>
        <v-row justify="center">
     <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                medium > <router-link class="white--text" :to="{ name: 'previsualizarMyArticle', params:{ id: articles.doublei.article.article_id}}"> <v-text color="white">Ver </v-text> </router-link></v-btn>
        
      </v-row>
    </v-card-actions>
  </v-card>
  </div>



<div  v-if="articles.doublei.article.curso == 'Física'">
            <v-card
            class="estiloinCardin"
                     height="180"
                    width="400"
                     color=#FFC400
            >

    <v-list-item three-line>
        
      <v-list-item-content>
        <v-list-item-title class="headline mb-1" > <v-text class="estilotexto"> {{articles.doublei.article.title}} </v-text></v-list-item-title>

        <div class="overline mb-4"> <v-text class="estilotexto"> Curso: {{articles.doublei.article.curso}}</v-text> </div>


        <v-list-item-subtitle> <v-text class="estilotexto"> Tema: {{articles.doublei.article.tema}} </v-text> </v-list-item-subtitle>
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
      ><v-icon x-large color="white">
          mdi-library
      </v-icon>
      
      </v-list-item-avatar>


    </v-list-item>

    <v-card-actions>
        <v-row justify="center">
     <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                medium > <router-link class="white--text" :to="{ name: 'previsualizarMyArticle', params:{ id: articles.doublei.article.article_id}}"> <v-text color="white">Ver </v-text> </router-link></v-btn>
        
      </v-row>
    </v-card-actions>
  </v-card>
  </div>



<div  v-if="articles.doublei.article.curso == 'Química'">
            <v-card
            class="estiloinCardin"
                     height="180"
                    width="400"
                     color=#4CAF50
            >

    <v-list-item three-line>
        
      <v-list-item-content>
        <v-list-item-title class="headline mb-1" > <v-text class="estilotexto"> {{articles.doublei.article.title}} </v-text></v-list-item-title>

        <div class="overline mb-4"> <v-text class="estilotexto"> Curso: {{articles.doublei.article.curso}}</v-text> </div>


        <v-list-item-subtitle> <v-text class="estilotexto"> Tema: {{articles.doublei.article.tema}} </v-text> </v-list-item-subtitle>
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
      ><v-icon x-large color="white">
          mdi-library
      </v-icon>
      
      </v-list-item-avatar>


    </v-list-item>

    <v-card-actions>
        <v-row justify="center">
     <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                medium > <router-link class="white--text" :to="{ name: 'previsualizarMyArticle', params:{ id: articles.doublei.article.article_id}}"> <v-text color="white">Ver </v-text> </router-link></v-btn>
        
      </v-row>
    </v-card-actions>
  </v-card>
  </div>







    </v-col>
    <v-container></v-container>

    
    </div>   
</v-row>
    
    </v-container>

    </v-container>

</template>

<script>
import { mapState } from 'vuex';
//import Api from "@/services/api";
export default {
    computed:{
        currentArticlePack(){
          return this.$store.state.articlepacks.find(ar => ar.article_id == this.$route.params.id)
        },
        ...mapState(['articles']),
        ...mapState(['articlepacks']),
        ...mapState(['articles_por_tupac']),
        ...mapState(['currentUser']),

    },
    mounted(){
        this.$store.dispatch("loadAllArticles_tupac",this.$route.params.id)
    },
    methods:{/*
        async asd(){
            let list_ids = [];
            let articlepack_response = await Api().get("/articlesporpack/67");
            for(var i = 0; i < articlepack_response.data.length; i++){
                list_ids[i] = articlepack_response.data[i].doublei.article_id;
            }
            console.log(list_ids);
        }
        */
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

        background-color: #4DB6AC;

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

  .estilotexto{
    font-size: 15px;
    color: white;
  } 


</style>