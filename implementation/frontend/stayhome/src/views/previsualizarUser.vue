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
        <v-row justify="center">
          <v-row>
            <v-col>
              <v-btn 
                dark
                v-bind="attrs"
                v-on="on"
                color="dark"
                small :href="currentArticle.link">Descargar
              </v-btn>
            </v-col>
            <v-col>
              <v-btn 
                fab
                x-large
                dark
                @click="addLiketoArticle">
               <v-icon color="blue" large>mdi-thumb-up</v-icon> <v-text>{{currentArticle.countlikes}}</v-text> </v-btn>
            </v-col>
          </v-row>
          <v-row>
            <v-col>
              <v-btn
                dark
                color="dark"
                small
                @click.stop="dialog = true"
              >
                Ver mis StayPacks
              </v-btn>
            </v-col>
            <v-col>
              <v-btn 
                fab
                x-large
                dark
                @click="addDisliketoArticle"> <v-icon color="red" large>mdi-thumb-down</v-icon>
                  <v-text> {{currentArticle.countdislikes}} </v-text> </v-btn>
            </v-col>
          </v-row>
          <v-row>
            <v-col>
              <v-btn
                dark
                color="dark"
                small
                @click="eliminar(currentArticle)"
              >
                Eliminar
              </v-btn>
            </v-col>
          </v-row>
      </v-row>

    <v-container></v-container>

      <v-row justify="center">
    
    <v-dialog
      v-model="dialog"
      max-width="800"
    >
    

        <v-card-title class="headline" > <v-text  class="estiloTextoT"> StayPacks </v-text> </v-card-title>

        <v-card-text>
          <v-col>
            <v-slide-group
              v-model="model"
              class="pa-4"
              center-active
              show-arrows
              dark
             >

             <div v-for="articlepack in articlepacks" :key="articlepack.articlepack_id">
              <div v-if="articlepack.user.user_id == currentUser.user_id">

             <v-slide-item @click="sheet = false">

            <v-col >
                 <v-card  class="estiloinCard"
                              height="180"
                              width="300"
                              color=#E53935
                              >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >

              
                <v-text class="estiloTexto" align="center">  
                  
                <v-icon left color="white">mdi-folder-multiple</v-icon> <v-text class="estiloTexto"> {{articlepack.name}} </v-text>
               
               </v-text>
                
                <v-container/>

                <v-btn
                  color="dark"
                  dark
                  medium
                  @click="addArticletoPack(articlepack)"
                >
                  Añadir
                 </v-btn>
                 
                 </v-row>
                 </v-card>

                </v-col>
                
            </v-slide-item>
            </div>
          </div>

          </v-slide-group>
          
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
    <router-link  to="/buscar"> <v-text class="estiloT" color="blue"> StayFiles </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <v-text class="estiloT" color="grey"> StayFile </v-text> 
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
          :src="currentArticle.link" type="video/mp4"
          >
          
        </video>


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

          <v-row>
          <v-col>
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        
        small :href="currentArticle.link">Descargar
        </v-btn>
        </v-col>

        <v-col>
 
        <v-btn 
        fab
        x-large
        dark
        @click="addLiketoArticle">

        <v-icon color="blue" large>mdi-thumb-up</v-icon> <v-text>{{currentArticle.countlikes}}</v-text> </v-btn>
          
        </v-col>

        </v-row>

        <v-row>

          <v-col>
          <v-btn
      dark
      color="dark"
      small
      @click.stop="dialog = true"
    >
      Ver mis StayPacks
    </v-btn>
          </v-col>

          <v-col>

             <v-btn 
        fab
        x-large
        dark
        @click="addDisliketoArticle"> <v-icon color="red" large>mdi-thumb-down</v-icon>
        
        <v-text> {{currentArticle.countdislikes}} </v-text> </v-btn>
        
          </v-col>

        </v-row>
        <v-row>
            <v-col>
              <v-btn
                dark
                color="dark"
                small
                @click="eliminar(currentArticle)"
              >
                Eliminar
              </v-btn>
            </v-col>
          </v-row>
        
      

      </v-row>

    <v-container></v-container>

      <v-row justify="center">
    
    <v-dialog
      v-model="dialog"
      max-width="800"
    >
    

        <v-card-title class="headline" > <v-text  class="estiloTextoT"> StayPacks </v-text> </v-card-title>

        <v-card-text>
          <v-col>
            <v-slide-group
              v-model="model"
              class="pa-4"
              center-active
              show-arrows
              dark
             >

             <div v-for="articlepack in articlepacks" :key="articlepack.articlepack_id">
              <div v-if="articlepack.user.user_id == currentUser.user_id">

             <v-slide-item @click="sheet = false">

            <v-col >
                 <v-card  class="estiloinCard"
                              height="180"
                              width="300"
                              color=#E53935
                              >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >

              
                <v-text class="estiloTexto" align="center">  
                  
                <v-icon left color="white">mdi-folder-multiple</v-icon> <v-text class="estiloTexto"> {{articlepack.name}} </v-text>
               
               </v-text>
                
                <v-container/>

                <v-btn
                  color="dark"
                  dark
                  medium
                  @click="addArticletoPack(articlepack)"
                >
                  Añadir
                 </v-btn>
                 
                 </v-row>
                 </v-card>

                </v-col>
                
            </v-slide-item>
            </div>
          </div>

          </v-slide-group>
          
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


<v-row justify="center"  v-else-if="currentArticle.tipo[0] == 'a'">

<v-container></v-container>
<v-container></v-container>
<v-container></v-container>


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




<v-container/>
<v-container/>


        <v-card
          class="estiloinCard"
          max-width="1000"
          color=#FFC400
        >

<pdf :src="currentArticle.link" width="900" height="780" style="border: none;"></pdf>

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

          <v-row>
          <v-col>
      <v-btn 
        dark
        v-bind="attrs"
        v-on="on"
        color="dark"
        
        small :href="currentArticle.link">Descargar
        </v-btn>
        </v-col>

        <v-col>
 
        <v-btn 
        fab
        x-large
        dark
        @click="addLiketoArticle">

        <v-icon color="blue" large>mdi-thumb-up</v-icon> <v-text>{{currentArticle.countlikes}}</v-text> </v-btn>
          
        </v-col>

        </v-row>

        <v-row>

          <v-col>
          <v-btn
      dark
      color="dark"
      small
      @click.stop="dialog = true"
    >
      Ver mis StayPacks
    </v-btn>
          </v-col>

          <v-col>

             <v-btn 
        fab
        x-large
        dark
        @click="addDisliketoArticle"> <v-icon color="red" large>mdi-thumb-down</v-icon>
        
        <v-text> {{currentArticle.countdislikes}} </v-text> </v-btn>
        
          </v-col>

        </v-row>
        <v-row>
            <v-col>
              <v-btn
                dark
                color="dark"
                small
                @click="eliminar(currentArticle)"
              >
                Eliminar
              </v-btn>
            </v-col>
          </v-row>
        
      

      </v-row>

    <v-container></v-container>

      <v-row justify="center">
    
    <v-dialog
      v-model="dialog"
      max-width="800"
    >
    

        <v-card-title class="headline" > <v-text  class="estiloTextoT"> StayPacks </v-text> </v-card-title>

        <v-card-text>
          <v-col>
            <v-slide-group
              v-model="model"
              class="pa-4"
              center-active
              show-arrows
              dark
             >

             <div v-for="articlepack in articlepacks" :key="articlepack.articlepack_id">
              <div v-if="articlepack.user.user_id == currentUser.user_id">

             <v-slide-item @click="sheet = false">

            <v-col >
                 <v-card  class="estiloinCard"
                              height="180"
                              width="300"
                              color=#E53935
                              >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >

              
                <v-text class="estiloTexto" align="center">  
                  
                <v-icon left color="white">mdi-folder-multiple</v-icon> <v-text class="estiloTexto"> {{articlepack.name}} </v-text>
               
               </v-text>
                
                <v-container/>

                <v-btn
                  color="dark"
                  dark
                  medium
                  @click="addArticletoPack(articlepack)"
                >
                  Añadir
                 </v-btn>
                 
                 </v-row>
                 </v-card>

                </v-col>
                
            </v-slide-item>
            </div>
          </div>

          </v-slide-group>
          
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
    </v-container>

</template>



<script>
import { mapState } from 'vuex';

import Api from "@/services/api";
import pdf from 'vue-pdf'

export default {

    components: {
    pdf
  },
    
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
              articleid: [],
              userid: [],
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
       alert('Se agregó el StayFile a ' + this.article_to_pack.doublei.articlepack.name)
       this.$router.go(0);//MAGIA//
     }

   },
   async eliminar(currentArticle){
      let response = confirm(`¿Estás seguro que deseas eliminar este StayFile? ${this.currentUser.username}`);
        if(response){
          let rpta = await this.$store.dispatch('deleteArticle',currentArticle);
            if(rpta.error){
                alert(rpta.error);
            }else{
                alert("Se ha eliminado correctamente el StayFile");
                this.$router.push("/buscar");
            }
        }
   } ,    
     

   async addLiketoArticle()
   {

    this.reaccion_to_article.dbi.articleid = this.currentArticle;
    this.reaccion_to_article.dbi.userid = this.currentUser;
    this.reaccion_to_article.lik = true;
    console.log(this.reaccion_to_article);
    let response = await this.$store.dispatch('addReaccionToArticle',this.reaccion_to_article);
    console.log(response);
    if(response.error){
       alert(response.error);
     }else{
       alert('Se dio Me gusta');
        this.$router.go(0);
       
   }

},
async addDisliketoArticle()
   {
    this.reaccion_to_article.dbi.articleid = this.currentArticle;
    this.reaccion_to_article.dbi.userid = this.currentUser;
    this.reaccion_to_article.lik = false;
    console.log(this.reaccion_to_article);
    let response = await this.$store.dispatch('addReaccionToArticle',this.reaccion_to_article);
    console.log(response);
    if(response.error){
       alert(response.error);
     }else{
       alert('Se dio No me gusta');
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
   font-size: 20px;
 }   
 
 .estiloinCard{

    border-radius: 30px;
    justify: center;
    


  } 
  .estiloD{
   font-size: 25px;
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
   font-size:30px;
   
 }

</style>