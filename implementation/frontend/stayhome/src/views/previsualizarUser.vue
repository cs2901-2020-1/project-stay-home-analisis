<template>

<v-container >

<v-row  v-if="currentArticle.tipo[0] == 'i'">

  
  <v-row justify="left">
    <v-text  class="estilo"> {{currentUser.username}}  <v-text class="estiloP"> >> </v-text> <v-text class="estiloT">  Artículo </v-text></v-text>

</v-row>

<v-container></v-container>

<v-row justify="center">
    <v-text  class="estiloT"> Tema:  <v-text class="estiloT">  Álgebra </v-text></v-text>

</v-row>

<v-container></v-container>

    <v-card
    class="mx-auto"
    max-width="1000"
  >
    <v-img
      v-bind:src="require(`../../../../backend/demo/src/main/resources/Files/${currentArticle.title}`)" 
      height="600px"
    ></v-img>

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
        <v-row justify="center">
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        
        small :href="'http://localhost:9898/downloadFile/'+ currentArticle.article_id">Descargar
        </v-btn>
      </v-row>

    <v-container></v-container>

      <v-row justify="center">
    <v-btn
      dark
      color="dark"
      small
      @click.stop="dialog = true"
    >
      Ver mis paquetes de artículos
    </v-btn>

    <v-dialog
      v-model="dialog"
      max-width="400"
    >
      <v-card>
        <v-card-title class="headline"> Paquete de artículos </v-card-title>

        <v-card-text>
          <v-col>
            <div v-for="articlepack in articlepacks" :key="articlepack.articlepack_id">
              <v-row>
                <v-col>
                <v-text class="estiloP" > <v-icon color="dark">mdi-folder-multiple</v-icon> {{articlepack.name}} </v-text>
                </v-col>
                <v-col>
                <v-btn
                  color="dark"
                  dark
                  small
                  @click="addArticletoPack(articlepack.articlepack_id)"
                >
                  Añadir
                 </v-btn>
                 </v-col>
              </v-row>
            </div>
          

          </v-col>
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>

          <v-btn
            dark
            color="dark"
            small
            @click="dialog = false"
          >
            cerrar
          </v-btn>

          
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
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
    <source v-bind:src="require(`../../../../backend/demo/src/main/resources/Files/${currentArticle.title}`)" type="video/mp4" />
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
    <v-text  class="estilo"> Tema  <v-text class="estiloP"> >> </v-text> <v-text class="estiloT">  {{currentArticle.tema}} </v-text></v-text>

</v-row>

<v-container></v-container>

<v-container>
   <pdf src="merge.pdf"></pdf>
</v-container>


</v-row>
















    </v-container>

</template>



<script>
import { mapState } from 'vuex';

import pdf from 'vue-pdf'


export default {

  components: {
    pdf
  },
    
    data () {
      return {
         dialog:false,
         show: false,

      doublei: {
            "articlepackid": '',
            "article_id": ''
        }

    


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

  async addArticletoPack(articlepack_id)
   {
     this.doublei.article_id = this.currentArticle.article_id;
     this.doublei.articlepackid = articlepack_id;
     console.log(this.doublei);
     let response = await Api().post("/articlesporpack/",doublei);
     console.log(response)

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
   font-size: 25px;
 }   


</style>