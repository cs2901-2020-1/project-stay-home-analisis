<template>
    <v-container>
      <v-container></v-container>
      <h1 class="estiloUser">Lista de Artículos:</h1>
      <v-container></v-container>
      <div v-for="article in articles" :key ="article.article_id">
    
         <v-row>
        <v-col>
         <v-text class="estiloArticle">  <v-icon medium left color="blue">mdi-folder </v-icon> {{article.title}} </v-text> </v-col>
       <v-col>
        <v-btn  small
                dark
                v-bind="attrs"
                v-on="on"
                color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
       <v-icon small left color=" darken">mdi-arrow-down-bold-box</v-icon>  Descargar </v-btn> 
        </v-col>
        </v-row>
      </div>

    </v-container>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: 'article-download',
  computed: {
    ...mapState(['articles'])
  },
  mounted(){
    this.$store.dispatch("loadAllArticles")
  },
  methods: {
  },
}
</script>


<style lang="scss" scoped>

.estiloUser{
        font-size:45px;
    }

.estiloArticle{
    font-size:25px;
    font-family: Arial, Helvetica, sans-serif;
    font-style: normal;
  }


</style>