<template>
<v-container>
   <v-container style="center" class="text-md-center" justify="center" v-model="valid"
   v-if="currentUser.username">
        <h2 class="text-md-center" >{{currentUser.username}} Suba un article</h2>
        <v-form>
            <v-select
            v-model="SelectedCurso"
            :items="cursos"
            :rules="[v => !!v || 'Curso is required']"
            label="Curso"
            required
            ></v-select>
            <!-- Ver compo se vería mejor, en cascada o que la base de datos se encargue -->
            <v-select v-if="this.SelectedCurso" 
            v-model="SelectedTipo"
            :items="tipos"
            :rules="[v => !!v || 'Tipo is required']"
            label="Tipo"
            required
            ></v-select>


            <div v-if="this.SelectedTipo == 'Documento'">

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

            <div v-else-if="this.SelectedTipo == 'Imagen'">
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

            <div v-else-if="this.SelectedTipo == 'Video'">
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
            @click="upload"
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
        data: ()=>({
            valid :false,
            SelectedCurso: '',
            SelectedTipo: '',
            cursos: [
                'Matemática',
                'Física',
                'Química',
            ],
            tipos: [
                'Video',
                'Documento',
                'Imagen',
            ],
            documentos: [],
            imagenes: [],
            videos: [],

        }),
        methods:{
            upload(){
                console.log(this.documentos)
                console.log(this.imagenes)
                console.log(this.videos)
                console.log(this.SelectedCurso)
                console.log(this.SelectedTipo)
            },
        }
    }
</script>

<style lang="scss" scoped>

</style>