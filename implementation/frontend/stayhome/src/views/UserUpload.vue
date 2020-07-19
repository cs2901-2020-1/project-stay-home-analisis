<template>
<v-container>
   <v-container  v-model="valid"
    v-if="currentUser.username  && currentUser.admin == false " >

        

    <v-row>

          <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
          <v-icon >mdi-chevron-right</v-icon>
          <v-text class="estiloT" color="grey"> Subir StayFiles </v-text> 
        
    </v-row>

      


        <v-container/> 
        <v-container/> 


        <v-form>
            
         <v-card class="estiloSubCard" color=#FFC400
 >
            <v-container class="fill-height" fluid justify="center">
            <v-row align="center" justify="center">
            <v-col md="6">

           
            <v-container/> 

            <v-card class="estiloSubCard" height="100px" width="800px" >
            
                <v-row justify="center">
                <div class="display-4">
                <v-avatar tile color=#F44336>
                <v-icon x-large color=#FFFFFF>mdi-library</v-icon>
                </v-avatar>
                 </div>
                      
            <v-col justify="center" md="8" >
            <v-select
            v-model="article.curso"
            :items="cursos"
            :rules="[v => !!v || 'Curso es requerido']"
            label="Curso"
            required
            ></v-select>
            </v-col>

                </v-row>            

            </v-card >
            
            </v-col>
            </v-row>
            </v-container>

            <v-container/>

                    

                         <v-container class="fill-height" fluid justify="center">
                        <v-row align="center" justify="center">
                        <v-col md="6">

                        <v-card class="estiloSubCard" height="100px" width="800px">

                         <v-row justify="center">
                       
                        <div class="display-4">
                        <v-avatar tile color=#F44336>
                        <v-icon x-large color=#FFFFFF> mdi-library</v-icon>
                        </v-avatar>
                        </div>
                      
                        <v-col justify="center" md="8">

                                
                        <v-select 
                        v-if="article.curso == 'Matemática'"
                        v-model="article.tema"
                        :items="temas_mate"
                        :rules="[v => !!v || 'Tema es requerido']"
                        label="Tema"
                        required
                        ></v-select>


                        <v-select v-else-if="article.curso == 'Física'"
                        v-model="article.tema"
                        :items="temas_fisica"
                        :rules="[v => !!v || 'Tema es requerido']"
                        label="Tema"
                        required
                        ></v-select>

                        <v-select v-else-if="article.curso == 'Química'"
                        v-model="article.tema"
                        :items="temas_quimica"
                        :rules="[v => !!v || 'Tema es requerido']"
                        label="Tema"
                        required
                        ></v-select>

                        </v-col>
                        </v-row>
                        </v-card>
                        </v-col>
                        </v-row>
                         </v-container>



            <v-container/>


                <v-container class="fill-height" fluid justify="center">
                <v-row align="center" justify="center">
                <v-col md="6">
                <v-card class="estiloSubCard" height="100px" width="800px">
                    <v-row justify="center">
                <div class="display-4">
                <v-avatar tile color=#F44336>
                <v-icon x-large color=#FFFFFF> mdi-library</v-icon>
                </v-avatar>
                 </div>
                      
            <v-col justify="center" md="8">

            <v-select 
            v-model="article.tipo"
            :items="tipos"
            :rules="[v => !!v || 'Tipo es requerido']"
            label="Tipo"
            required
            >  </v-select> 
            </v-col>
             </v-row>
                </v-card>
                </v-col>
                </v-row>
                </v-container>
           

            <v-container/>

            <v-container class="fill-height" fluid justify="center">
                <v-row align="center" justify="center">
                <v-col md="6">

            <v-card  class="estiloSubCard" height="100px" width="800px">
                <v-row justify="center">
                <div class="display-4">
                <v-avatar tile color=#F44336>
                <v-icon x-large color=#FFFFFF> mdi-library</v-icon>
                </v-avatar>
                 </div>
                      
            <v-col justify="center" md="8">

            <v-text-field v-model="article.title" label="Titulo" required :rules="tituloRules"></v-text-field>
            </v-col>
                </v-row>
            </v-card>
            </v-col>
            </v-row>
            </v-container>


            <v-container/>

             <v-container class="fill-height" fluid justify="center">
            <v-row align="center" justify="center">
            <v-col md="6">

            <v-card class="estiloSubCard" height="200px" width="800px">

                <v-row justify="center">
               
                      
            <v-col justify="center" md="8">
                
            <v-textarea  v-model="article.descripcion" label="Descripción" required :rules="descripcionRules"/>
            </v-col>
                </v-row>
            </v-card>
            
            </v-col>
            </v-row>
             </v-container>

            <v-container/>

         <v-container class="fill-height" fluid justify="center">
            <v-row align="center" justify="center">
            <v-col md="6">

            <div v-if="article.tipo == 'Documento' && article.descripcion">

                <v-card class="estiloSubCard"  height="100px" width="800px">

                <v-row justify="center">
               
                      
            <v-col justify="center" md="8">


                    <v-file-input
                    v-model="articles"
                    placeholder="Subir tu StayFile"
                    label="Documento"
                    prepend-icon="mdi-file-document"
                    outlined
                    show-size
                    class="pa-3"
                    accept=".pdf, .docx"
            
                    >   
                        <template v-slot:selection="{ text }">
                            <v-chip
                                small
                                label
                                color="primary"
                            >
                                {{ text }}
                            </v-chip>
                        </template>

                    </v-file-input>
            </v-col>
                </v-row>
                </v-card>
            </div>

            <div v-else-if="article.tipo == 'Imagen' && article.descripcion">
                <v-card class="estiloSubCard"  height="100px" width="800px">

                <v-row justify="center">
               
                      
            <v-col justify="center" md="8">
                    <v-file-input
                    v-model="articles"
                    placeholder="Subir tu StayFile"
                    label="Imagen"
                    prepend-icon="mdi-camera"
                    outlined
                    show-size
                    class="pa-3"
                    accept="image/*"
                    >   
                        <template v-slot:selection="{ text }">
                            <v-chip
                                small
                                label
                                color="primary"
                            >
                                {{ text }}  
                            </v-chip>
                        </template>
                    </v-file-input>
            </v-col>
                </v-row>
                </v-card>
            </div>

            <div v-else-if="article.tipo == 'Video' && article.descripcion">
                
                <v-card class="estiloSubCard"  height="100px" width="800px">

                <v-row justify="center">
               
                      
            <v-col justify="center" md="8">
                <v-file-input
                v-model="articles"
                placeholder="Subir tu StayFile"
                label="Video"
                prepend-icon="mdi-video"
                outlined
                show-size
                class="pa-3"
                accept="video/*"
                >   
                    <template v-slot:selection="{ text }">
                        <v-chip
                            small
                            label
                            color="primary"
                        >
                            {{ text }}
                        </v-chip>
                    </template>
                </v-file-input>
            </v-col>
                </v-row>
                </v-card>
            </div>
            </v-col>
            </v-row>
         </v-container>


 <v-container class="fill-height" fluid justify="center">
            <v-row align="center" justify="center">
            <v-col md="2">
            <v-contaienr/>
            <v-btn 
            color="dark"
            dark
            @click="upload"
            :disabled="!valid"
            large
            :loading="loading"
            >
            Subir

            <v-icon right dark>mdi-cloud-upload</v-icon>

            </v-btn> 
            </v-col>
            </v-row>
            
 </v-container>   
         </v-card>
        </v-form>
   </v-container>


   <v-container v-else>
   ERROR
   </v-container>
</v-container>   
</template>

<script>

class Capsule {
  constructor(file,article_id) {
    this.file = file;
    this.article_id = article_id;
  }
}


import {mapState} from 'vuex';
    export default {
        computed: {
            ...mapState(['currentUser'])
        },
        mounted(){
            this.$store.dispatch("loadAll")
            this.$store.dispatch("loadAllArticles")
        },
        data: ()=>({
            valid :false,

            loading: false,

            descripcionRules: [
                v => !!v || 'Descripción requirida',
                v => (v && v.length <= 1000) || 'La descripción tiene que ser menor que 1000 caracteres',
            ],

            tituloRules: [
                v => !!v || 'Titulo requirido',
                v => (v && v.length <= 30) || 'El titulo tiene que ser menor que 30 caracteres',
            ],

            cursos: [
                'Matemática',
                'Física',
                'Química',
            ],
            temas_mate:[
                'Álgebra',
                'Geometría',
                'Ecuaciones'
            ],
            temas_fisica:[
                'Magnetismo',
                'Cinemática',
                'Dinámica'
            ],
            temas_quimica:[
                'Química Básica',
                'Química Orgánica'
            ],
            tipos: [
                'Video',
                'Documento',
                'Imagen',
            ],
            article:{
                link: '',
                nombre: '',
                title: '',
                curso: '',
                tema: '',
                tipo: '',
                descripcion: '',
                aceptado: false,
                user:[]
            },
            articles:[],
        
        }),
        methods:{
            async  upload(){
                this.article.nombre = this.articles.name;
                this.article.link= "../../../database/articles/" + this.article.title;
                this.article.user = this.currentUser; 
                console.log(this.article);    
                let reponse_article = await this.$store.dispatch('addArticle',this.article);
                console.log(reponse_article);
                let id = reponse_article.article_id;
                let capsule = new Capsule(this.articles,id);
                let response_file = await this.$store.dispatch('addFile',capsule);
                this.loading=true;

                setTimeout(() => {
                if(response_file.error){
                    alert(response_file.error)
                    this.loading=false;
                }else{
                    alert('La subida del StayFile se completó con éxito, espere que sea validada por un administrador');
                    this.loading=false;
                    this.$router.push('/myplaylists');
                }},1000);
            },
        },
    }
  
</script>

<style lang="scss" scoped>

.estilo {
        font-size:45px;
    }

.estiloc {
        font-size: 15px;
        font-family: "Lucida Console", Courier, monospace;


    }
.estiloA{
   font-size: 25px;
        
}
.estilosub{
   font-size: 20px;
   
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif; font-size: 24px; font-style: normal; font-variant: normal; font-weight: 700; line-height: 26.4px; } h3 { font-family: Arial, "Helvetica Neue", Helvetica, sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 700; line-height: 15.4px; } p { font-family: Arial, "Helvetica Neue", Helvetica, sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; line-height: 20px; } blockquote { font-family: Arial, "Helvetica Neue", Helvetica, sans-serif; font-size: 21px; font-style: normal; font-variant: normal; font-weight: 400; line-height: 30px; } pre { font-family: Arial, "Helvetica Neue", Helvetica, sans-serif; font-size: 13px; font-style: normal; font-variant: normal; font-weight: 400; line-height: 18.5714px; 
        
}

 .estiloT{
   font-size: 25px;
 }   
 .estiloC{

        background-color: #4DB6AC;

 }  

 .estiloSubCard{

    border-radius: 20px;
    background-color: #E0E0E0;

  } 



</style>