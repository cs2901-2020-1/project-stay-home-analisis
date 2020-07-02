<template>
<v-container>
   <v-container style="center" class="text-md-center" justify="center" v-model="valid"
    v-if="currentUser.username">
        <h2 class="text-md-center" >{{currentUser.username}} Suba un article</h2>
        <v-form>
            <v-select
            v-model="article.curso"
            :items="cursos"
            :rules="[v => !!v || 'Curso is required']"
            label="Curso"
            required
            ></v-select>
            <v-select v-if="article.curso"
            v-model="article.tema"
            :items="temas"
            :rules="[v => !!v || 'Tema is required']"
            label="Tema"
            required
            ></v-select>
            <!-- Ver compo se vería mejor, en cascada o que la base de datos se encargue -->
            <v-select v-if="article.tema" 
            v-model="article.tipo"
            :items="tipos"
            :rules="[v => !!v || 'Tipo is required']"
            label="Tipo"
            required
            ></v-select>


            <div v-if="article.tipo == 'Documento'">

                    <v-file-input
                    v-model="documentos"
                    placeholder="Upload your document"
                    label="Documento"
                    prepend-icon="mdi-file-document"
                    outlined
                    show-size
                    class="pa-3"
                    accept=".pdf"
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

            <div v-else-if="article.tipo == 'Imagen'">
                    <v-file-input
                    v-model="imagenes"
                    placeholder="Upload your image"
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

            <div v-else-if="article.tipo == 'Video'">
                <v-file-input
                v-model="videos"
                placeholder="Upload your video"
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
            @click="upload_imagenes"
            :disabled="!valid"
            >
            Upload
                <v-icon right dark>mdi-cloud-upload</v-icon>
            </v-btn>    

        </v-form>
   </v-container>
   <v-container v-else>
   Por favor Logueate
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
            cursos: [
                'Matemática',
                'Física',
                'Química',
            ],
            temas:[
                'Álgebra',
                'Geometría',
                'Ecuaciones'
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
             user_id: ''
            },
            documentos: [],
            imagenes: [],
            videos: [],

        }),
        methods:{
          async  upload_imagenes(){
        this.article.title = this.imagenes.name;
        this.article.link= "../../../database/articles/" + this.article.title;
        this.article.user_id = this.currentUser.user_id;        
        console.log(this.article);
        console.log(this.imagenes);
        let a = await this.$store.dispatch('addArticle',this.article);
        let id = a.article_id;
        let capsule = new Capsule(this.imagenes,id);
        console.log(capsule);
        console.log(id);
        let b = await this.$store.dispatch('addFile',capsule);
        console.log(b);

      }

            },
        }
  
</script>

<style lang="scss" scoped>

</style>