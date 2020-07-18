<template>

<v-container justify="center">

<v-row >
  <v-row justify="left">

    <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
    
    <v-icon >mdi-chevron-right</v-icon>
   <v-text class="estiloT" color="grey"> Contáctanos </v-text> 
  
</v-row>
</v-row>
<v-container></v-container>
<v-container></v-container>
<v-container></v-container>

<v-row justify="center">
    <v-card
    class="estiloB"
    color=#FFC400
    dark
    high="700"
    width="400"
  >
    <v-card-title>
      <v-icon
        large
        left
      >
        mdi-cellphone      
        </v-icon>

      <span class="title font-weight-light">¡Contáctanos!</span>
    </v-card-title>

    <v-card-text class="headline font-weight-bold" color="#FFFFFF">

        <v-row justify="center">
           <v-icon> mdi-facebook </v-icon> <v-text> StayHome </v-text>
            </v-row>
              <v-row justify="center">
                  
           <v-icon> mdi-instagram </v-icon>  <v-text> StayHome </v-text>
            </v-row>
              <v-row justify="center">
            <v-icon> mdi-twitter </v-icon>  <v-text> @StayHome </v-text>
            </v-row >
              <v-row justify="center">
            <v-icon>mdi-gmail </v-icon> <v-text> stayhome@gmail.com </v-text>
            </v-row>

    </v-card-text>

    <v-card-actions>
      <v-list-item class="grow">
        <v-list-item-avatar color="grey darken-3">
            <v-icon
            large
             >
            mdi-home
            </v-icon>
        </v-list-item-avatar>

        <v-list-item-content>
          <v-list-item-title>Equipo Stay home </v-list-item-title>
        </v-list-item-content>

      </v-list-item>
    </v-card-actions>
  </v-card>

</v-row>

</v-container>



</template>



<script>
import { mapState } from 'vuex';


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
 .estiloB{
    border-radius: 30px;
}


</style>