<template>
<v-container>
   <v-container style="center" class="text-md-center" justify="center" v-model="valid"
    v-if="currentUser.username">
        <h2 class="text-md-center" >{{currentUser.username}} Suba un article</h2>
        <v-form>
            <v-select
            v-model="article.SelectedCurso"
            :items="cursos"
            :rules="[v => !!v || 'Curso is required']"
            label="Curso"
            required
            ></v-select>
            <v-select v-if="article.SelectedCurso"
            v-model="article.SelectedTema"
            :items="temas"
            :rules="[v => !!v || 'Tema is required']"
            label="Tema"
            required
            ></v-select>
            <!-- Ver compo se vería mejor, en cascada o que la base de datos se encargue -->
            <v-select v-if="article.SelectedTema" 
            v-model="article.SelectedTipo"
            :items="tipos"
            :rules="[v => !!v || 'Tipo is required']"
            label="Tipo"
            required
            ></v-select>


            <div v-if="article.SelectedTipo == 'Documento'">

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

            <div v-else-if="article.SelectedTipo == 'Imagen'">
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

            <div v-else-if="article.SelectedTipo == 'Video'">
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
import {mapState} from 'vuex';
    export default {
        computed: {
            ...mapState(['currentUser'])
        },
        mounted(){
            this.$store.dispatch("loadAll")
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
             article_id: '',
             link: '',
             title: '',
             SelectedCurso: '',
             SelectedTema: '',
             SelectedTipo: '',
             user_id: ''
            },
            documentos: [],
            imagenes: [],
            videos: [],

        }),
        methods:{
          async  upload_imagenes(){
     /*   let validator = await this.$store.dispatch("loadAllArticles");
        console.log(validator)
        if(validator.data == ''){
        this.article.article_id = 1;
        }else{
        console.log(validator.data[validator.data.length-1].article_id);
        this.article.article_id = validator.data[validator.data.length-1].article_id + 1;
        }*/
        this.article.article_id = 12312;
        this.article.title = this.imagenes.name;
        this.article.link= "../../../database/articles/" + this.article.title;
        this.article.user_id = this.currentUser.user_id;
        console.log(this.article)

      }

            },
        }
  
</script>

<style lang="scss" scoped>

</style>