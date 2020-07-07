<template>
<v-container v-if="currentUser.username">
    <h1 class="estilo"> {{currentUser.username}}  <v-text class="estiloc"> >> </v-text>  <v-text class="estiloI"> Inicio </v-text></h1>
  <v-container >
    <v-row >

      <v-col  >
        Matemática
      </v-col>
      <v-col>
        Física
      </v-col>
      <v-col>
        Química
      </v-col>

    </v-row>
   
    <v-row>
      
      <v-col>
        <v-container>
          <v-container></v-container>
            <div v-for="article in articles" :key ="article.article_id" >
            <div  v-if="article.curso == 'Matemática'">
              
            <v-row>
            <v-col >
              
              </div>
              <div  v-if="article.tipo[0] =='a'"> 
              <v-text class="estiloArticle">  <v-icon medium left color="blue">mdi-file-document </v-icon> {{article.title}} </v-text> 
              </div>
              
              <div  v-else-if="article.tipo[0] =='v'"> 
              <v-text class="estiloArticle">  <v-icon medium left color="blue">mdi-play-circle </v-icon> {{article.title}} </v-text> 
              </div>
              
              <div  v-else> 
              <v-text class="estiloArticle">  <v-icon medium left color="blue">mdi-file-image </v-icon> {{article.title}} </v-text> 
              </div>
            </v-col>
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
            </div>
        </v-container>
      </v-col>



    <v-col>
      <v-container>
          <v-container></v-container>
            <div v-for="article in articles" :key ="article.article_id" >
            <div  v-if="article.curso == 'Física'">
            <v-row>
            <v-col>
              <div  v-if="article.tipo[0] =='a'"> 
              <v-text class="estiloArticle">  <v-icon medium left color="blue">mdi-file-document </v-icon> {{article.title}} </v-text> 
              </div>
              
              <div  v-else-if="article.tipo[0] =='v'"> 
              <v-text class="estiloArticle">  <v-icon medium left color="blue">mdi-play-circle </v-icon> {{article.title}} </v-text> 
              </div>
              
              <div  v-else> 
              <v-text class="estiloArticle">  <v-icon medium left color="blue">mdi-file-image </v-icon> {{article.title}} </v-text> 
              </div>
            </v-col>
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
            </div>
        </v-container>
    </v-col>


    <v-col>
      <v-container>
          <v-container></v-container>
            <div v-for="article in articles" :key ="article.article_id" >
            <div  v-if="article.curso == 'Química'">
            <v-row>
            <v-col>
              <div  v-if="article.tipo[0] =='a'"> 
              <v-text class="estiloArticle">  <v-icon medium left color="blue">mdi-file-document </v-icon> {{article.title}} </v-text> 
              </div>
              
              <div  v-else-if="article.tipo[0] =='v'"> 
              <v-text class="estiloArticle">  <v-icon medium left color="blue">mdi-play-circle </v-icon> {{article.title}} </v-text> 
              </div>
              
              <div  v-else> 
              <v-text class="estiloArticle">  <v-icon medium left color="blue">mdi-file-image </v-icon> {{article.title}} </v-text> 
              </div>
            </v-col>
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
            </div>
        </v-container>
    </v-col>
  </v-row>
  </v-container>
</v-container>
    <v-container v-else>
     Por favor inicia sesión
    </v-container>   
</template>

<script>
import { mapState } from 'vuex';
export default {

    
    
    name: 'StayHome',
    data(){
        return{
        }
    },
    computed: {
      videos(){return this.$store.state.articles},
        ...mapState(['currentUser']),
        ...mapState(['articles']),
    },
    mounted(){
    this.$store.dispatch("loadAll");
    this.$store.dispatch("loadAllArticles");
    },
    methods:
    {
        down()
        {
                this.$router.push("/download")
        },

      next () {
        this.onboarding = this.onboarding + 1 === this.length
          ? 0
          : this.onboarding + 1
      },
      prev () {
        this.onboarding = this.onboarding - 1 < 0
          ? this.length - 1
          : this.onboarding - 1
      },





    },

    watch: {
      loader () {
        const l = this.loader
        this[l] = !this[l]

        setTimeout(() => (this[l] = false), 3000)

        this.loader = null
      },
    },
}
       
</script>

<style lang="scss" scoped>

  .custom-loader {
    animation: loader 1s infinite;
    display: flex;
  }
  @-moz-keyframes loader {
    from {
      transform: rotate(0);
    }
    to {
      transform: rotate(360deg);
    }
  }
  @-webkit-keyframes loader {
    from {
      transform: rotate(0);
    }
    to {
      transform: rotate(360deg);
    }
  }
  @-o-keyframes loader {
    from {
      transform: rotate(0);
    }
    to {
      transform: rotate(360deg);
    }
  }
  @keyframes loader {
    from {
      transform: rotate(0);
    }
    to {
      transform: rotate(360deg);
    }
  }

.titulo{
        text-align: center;
        font-style: normal;
        font-size: 27px;
        letter-spacing: 0.8px;
        word-spacing: -1.6px;
        color: #000000;
        font-weight: 700;
        font-variant: small-caps;
        text-transform: uppercase;
    }

.estilo {
        font-size:45px;
    }

.estiloc {
        font-size: 15px;
        font-family: "Lucida Console", Courier, monospace;


    }
.estiloI{
   font-size: 25px;
        
}



</style>
