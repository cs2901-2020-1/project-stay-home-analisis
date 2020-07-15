<template>
<v-container>
   <v-container  v-model="valid"
    v-if="currentUser.username  && currentUser.admin == false ">
        <h2 class="estilo"  >{{currentUser.username}}<v-text class="estiloc"> >> </v-text> <v-text class="estiloA"> Subir artículos </v-text> </h2>
        <v-container>  </v-container>
        
        <v-form>
            <v-select
            v-model="article.curso"
            :items="cursos"
            :rules="[v => !!v || 'Curso es requerido']"
            label="Curso"
            required
            ></v-select>
                    <div v-if="article.curso">
                        <v-select v-if="article.curso == 'Matemática'"
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
                    </div>
            <v-select v-if="article.tema" 
            v-model="article.tipo"
            :items="tipos"
            :rules="[v => !!v || 'Tipo es requerido']"
            label="Tipo"
            required
            ></v-select>

            <v-textarea v-if="article.tipo" v-model="article.descripcion" label="Descripción" required :rules="descripcionRules"/>



            <div v-if="article.tipo == 'Documento' && article.descripcion">

                    <v-file-input
                    v-model="articles"
                    placeholder="Subir tu documento"
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
            </div>

            <div v-else-if="article.tipo == 'Imagen' && article.descripcion">
                    <v-file-input
                    v-model="articles"
                    placeholder="Subir tu imagen"
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
            </div>

            <div v-else-if="article.tipo == 'Video' && article.descripcion">
                <v-file-input
                v-model="articles"
                placeholder="Subir tu video"
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
            </div>
            <v-btn 
            color="blue-grey"
            class="ma-2 white--text"
            @click="upload"
            :disabled="!valid"
            >
            Subir
                <v-icon right dark>mdi-cloud-upload</v-icon>
            </v-btn>    

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
             descripcionRules: [
        v => !!v || 'Descripción requirida',
        v => (v && v.length <= 1000) || 'La descripción tiene que ser menor que 1000 caracteres',
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
             title: '',
             curso: '',
             tema: '',
             tipo: '',
             descripcion: '',
             aceptado: false,
             user_id: ''
            },
            articles:[]

        }),
        methods:{
          async  upload(){
            this.article.title = this.articles.name;
            this.article.link= "../../../database/articles/" + this.article.title;
            this.article.user_id = this.currentUser.user_id;        
            let reponse_article = await this.$store.dispatch('addArticle',this.article);
            let id = reponse_article.article_id;
            let capsule = new Capsule(this.articles,id);
            let response_file = await this.$store.dispatch('addFile',capsule);
             if(response_file.error){
            alert(response_file.error)
          }else{
            alert('La subida del archivo se completó con éxito, espere que sea validada por un administrador');
            this.$router.push('/mainpage');
          }
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



</style>