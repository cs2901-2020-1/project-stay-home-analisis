<template>

<v-container >

<v-row  v-if="currentArticle.tipo[0] == 'i'">

  <v-row>
    <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <router-link  to="/buscar"> <v-text class="estiloT" color="blue"> Artículos </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <v-text class="estiloT" color="grey"> Artículo </v-text> 
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
      Subido por: {{currentArticle.user.username}}
    </v-card-subtitle>

    <v-btn @click="addLiketoArticle">Like {{currentArticle.countlikes}}</v-btn>

    <v-btn @click="addDisliketoArticle">Dislike {{currentArticle.countdislikes}} </v-btn>

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
        <v-btn @click="eliminar(currentArticle)">Eliminar</v-btn>
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
              <div v-if="articlepack.user.user_id == currentUser.user_id">
              <v-row>
                <v-col>
                <v-text class="estiloP" > <v-icon color="dark">mdi-folder-multiple</v-icon>  {{articlepack.name}}</v-text>
                </v-col>
                <v-col>
                <v-btn
                  color="dark"
                  dark
                  small
                  @click="addArticletoPack(articlepack)"
                >
                  Añadir
                 </v-btn>
                 </v-col>
              </v-row>
            </div>
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
      <v-col>
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
    <v-text class="estilo"> Título  <v-text class="estiloP"> >> </v-text> <v-text class="estiloT">  {{currentArticle.title}} </v-text></v-text>

</v-row>

<v-container></v-container>

    <v-card
    class="mx-auto"
    max-width="1000"
  >
  <video 
    controls
     widht="340" 
     height="340" 
    >
    <source v-bind:src="require(`../../../../backend/demo/src/main/resources/Files/${currentArticle.nombre}`)" type="video/mp4" />
  </video>


    <v-card-title>
      Tema: {{currentArticle.tema}}
    </v-card-title>

    <v-card-subtitle>
      Subido por: {{currentArticle.user.username}}
    </v-card-subtitle>

    <v-card-actions>
      <v-col>
        <v-row justify="center">
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        small :href="'http://localhost:9898/downloadFile/'+ currentArticle.article_id"> Descargar
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
              <div v-if="articlepack.user.user_id == currentUser.user_id">
              <v-row>
                <v-col>
                <v-text class="estiloP" > <v-icon color="dark">mdi-folder-multiple</v-icon>  {{articlepack.name}}</v-text>
                </v-col>
                <v-col>
                <v-btn
                  color="dark"
                  dark
                  small
                  @click="addArticletoPack(articlepack)"
                >
                  Añadir
                 </v-btn>
                 </v-col>
              </v-row>
            </div>
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


 <v-row>
        <v-col justify="center">
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        small :href="'http://localhost:9898/downloadFile/'+ currentArticle.article_id"> Descargar
        </v-btn>
      </v-col>

    <v-container></v-container>

    <v-col justify="center">
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
              <div v-if="articlepack.user.user_id == currentUser.user_id">
              <v-row>
                <v-col>
                <v-text class="estiloP" > <v-icon color="dark">mdi-folder-multiple</v-icon>  {{articlepack.name}}</v-text>
                </v-col>
                <v-col>
                <v-btn
                  color="dark"
                  dark
                  small
                  @click="addArticletoPack(articlepack)"
                >
                  Añadir
                 </v-btn>
                 </v-col>
              </v-row>
            </div>
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
  </v-col>


    </v-row>


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

          reaccion_to_article:{
            dbi: {
              articleid: ' ',
              userid: ' ',
            },
            lik: ' '
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

   },
   async eliminar(currentArticle){
      let response = confirm(`¿Estás seguro que deseas eliminar este paquete de articulo? ${this.currentUser.username}`);
        if(response){
          let rpta = await this.$store.dispatch('deleteArticle',currentArticle);
            if(rpta.error){
                alert(rpta.error);
            }else{
                alert("Se ha eliminado correctamente el articulo");
                this.$router.push("/buscar");
            }
        }
   } ,    
     

   async addLiketoArticle()
   {
    this.reaccion_to_article.dbi.articleid = this.currentArticle.article_id;
    this.reaccion_to_article.dbi.userid = this.currentUser.user_id;
    this.reaccion_to_article.lik = true;
    console.log(this.reaccion_to_article);
    let response = await this.$store.dispatch('addReaccionToArticle',this.reaccion_to_article);
    console.log(response);
    if(response.error){
       alert(response.error);
     }else{
       alert('Se dio Like');
       this.$router.go(0);
   }

},
async addDisliketoArticle()
   {
    this.reaccion_to_article.dbi.articleid = this.currentArticle.article_id;
    this.reaccion_to_article.dbi.userid = this.currentUser.user_id;
    this.reaccion_to_article.lik = false;
    console.log(this.reaccion_to_article);
    let response = await this.$store.dispatch('addReaccionToArticle',this.reaccion_to_article);
    console.log(response);
    if(response.error){
       alert(response.error);
     }else{
       alert('Se dio Dislike');
       this.$router.go(0);
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


</style>