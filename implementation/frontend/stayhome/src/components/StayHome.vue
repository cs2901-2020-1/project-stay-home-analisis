<template>
<v-container v-if="currentUser.admin == true">
     Solicitudes
     <div v-for="article in articles" :key ="article.article_id">
        <h1 v-if="article.aceptado == false">
              {{article.title}}
              {{article.aceptado}}
              <v-btn x-small @click="Validar(article)">Validar</v-btn>
              <v-btn x-small @click="Eliminar(article)">Eliminar</v-btn>
        </h1>
      </div>
</v-container> 

<v-container v-else-if="currentUser.username" >
    <h1 class="estilo"> {{currentUser.username}}  <v-text class="estiloc"> >> </v-text>  <v-text class="estiloI"> Inicio </v-text></h1>
   
   
    <v-row class="estiloM" >
        
      <v-col center>
        <v-flex xs12>
        <v-card
          class="estiloC"
          outlined
          tile
        >
         <v-text class=estiloL> Matemática </v-text>
        </v-card>
         </v-flex>
      </v-col>
      
      <v-col center  >
        <v-flex xs12>
        <v-card
          class="estiloC"
          outlined
          tile
        >
        
        <v-text class=estiloL>  Física </v-text>
           </v-card>
         </v-flex>
      </v-col>
      
      
      <v-col center>
        <v-flex xs12>
        <v-card
          class="estiloC"
          outlined
          tile
        >
         <v-text class=estiloL>  Química </v-text>
          </v-card>
         </v-flex>
      </v-col>
    </v-row>
    
  
   <v-container></v-container>
   <v-container></v-container>

    <v-row >
      <v-col >
        <v-layout colum  >
        <v-flex  >
        <v-card
          class="estiloC"
          outlined
          tile
        >
        <v-container>
          <v-container></v-container>

            <v-dialog v-model="dialog1" scrollable max-width="700px">

            <template v-slot:activator="{ on, attrs }">
            <v-row justify="center"  >
            <v-btn
                class="subheading"
                large
                dark
                center
                v-bind="attrs"
                v-on="on"
                color="dark"
              >
            <v-icon  left >mdi-numeric</v-icon> Álgebra
            </v-btn>
            </v-row>
            </template>

          <v-card>
              <v-card-title>Artículos</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheet">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Videos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Álgebra'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-list-item  @click="sheet = false">
                     
            <v-row >
              <v-col>
              <div  v-if="article.tipo[0] =='v'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-play-circle </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              <v-container></v-container>


               <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheet2">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Imágenes</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.tema == 'Álgebra'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-list-item  @click="sheet2 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='i'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-image </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>


                <v-container></v-container>

                <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheet3">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Documentos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.tema == 'Álgebra'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-list-item  @click="sheet3 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='a'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-document </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="blue darken-1" text @click="dialog1 = false"> Cerrar</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>

    <v-container></v-container>



<v-dialog v-model="dialog2" scrollable max-width="700px">

            <template v-slot:activator="{ on, attrs }">
            <v-row justify="center" >
            <v-btn
                class="subheading"
                large
                dark
                center
                v-bind="attrs"
                v-on="on"
                color="dark"
              >
             <v-icon  left > mdi-math-compass</v-icon>Geometría
            </v-btn>
            </v-row>
            </template>

          <v-card>
              <v-card-title>Artículos</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetG1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Videos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.tema == 'Geometría'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-list-item  @click="sheet = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='v'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-play-circle </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              <v-container></v-container>


               <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetG2">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Imágenes</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.tema == 'Geometría'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-list-item  @click="sheet2 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='i'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-image </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>


                <v-container></v-container>

                <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetG3">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Documentos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.tema == 'Geometría'">
                      <div  v-if="article.tipo[0] == 'a' " >
                      <v-list-item  @click="sheet3 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='a'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-document </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="blue darken-1" text @click="dialog2 = false"> Cerrar</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>




        <v-container></v-container>

<v-dialog v-model="dialog3" scrollable max-width="700px">

            <template v-slot:activator="{ on, attrs }">
            <v-row justify="center">
            <v-btn
                class="subheading"
                large
                dark
                center
                v-bind="attrs"
                v-on="on"
                color="dark"
              >
             <v-icon  left > mdi-numeric</v-icon>Ecuaciones
            </v-btn>
            <v-container></v-container>
            </v-row>
            </template>

          <v-card>
              <v-card-title>Artículos</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetE1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Videos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.tema == 'Ecuaciones'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-list-item  @click="sheet = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='v'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-play-circle </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              <v-container></v-container>


               <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetE2">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Imágenes</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.tema == 'Ecuaciones'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-list-item  @click="sheet2 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='i'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-image </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>


                <v-container></v-container>

                <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetE3">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Documentos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.tema == 'Ecuaciones'">
                      <div  v-if="article.tipo[0] == 'a' " >
                      <v-list-item  @click="sheet3 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='a'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-document </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="blue darken-1" text @click="dialog3 = false"> Cerrar</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>

        </v-container>
        </v-card>
        </v-flex>
        </v-layout >
  </v-col>
     
 



    <v-col >
       
      <v-card
          class="estiloC"
          outlined
          tile
        >
       <v-container>
      <v-container></v-container>

      <v-dialog v-model="dialogf1" scrollable max-width="700px">

            <template v-slot:activator="{ on, attrs }">
            <v-row justify="center">
            <v-btn
                class="subheading"
                large
                dark
                center
                v-bind="attrs"
                v-on="on"
                color="dark"
              >
            <v-icon  left >  mdi-magnet-on</v-icon> Magnetismo
            </v-btn>
            </v-row>
            </template>

          <v-card>
              <v-card-title>Artículos</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetM1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Videos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.tema == 'Magnetismo'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-list-item  @click="sheetM1 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='v'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-play-circle </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              <v-container></v-container>


               <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetM2">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Imágenes</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.tema == 'Magnetismo'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-list-item  @click="sheetM2 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='i'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-image </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>


                <v-container></v-container>

                <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetM3">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Documentos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.tema == 'Magnetismo'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-list-item  @click="sheetM3 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='a'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-document </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="blue darken-1" text @click="dialogf1 = false"> Cerrar</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>

       <v-container></v-container>

      <v-dialog v-model="dialogf2" scrollable max-width="700px">

            <template v-slot:activator="{ on, attrs }">
            <v-row justify="center">
            <v-btn
                class="subheading"
                large
                dark
                center
                v-bind="attrs"
                v-on="on"
                color="dark"
              >
            <v-icon  left >  mdi-car</v-icon> Cinemática
            </v-btn>
            </v-row>
            </template>

          <v-card>
              <v-card-title>Artículos</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetC1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Videos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.tema == 'Cinemática'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-list-item  @click="sheetC1 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='v'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-play-circle </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              <v-container></v-container>


               <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetC2">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Imágenes</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.tema == 'Cinemática'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-list-item  @click="sheetC2 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='i'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-image </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>


                <v-container></v-container>

                <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetC3">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Documentos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.tema == 'Cinemática'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-list-item  @click="sheetC3 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='a'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-document </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="blue darken-1" text @click="dialogf2 = false"> Cerrar</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>





<v-container></v-container>

      <v-dialog v-model="dialogf3" scrollable max-width="700px">

            <template v-slot:activator="{ on, attrs }">
            <v-row justify="center">
            <v-btn
                class="subheading"
                large
                dark
                center
                v-bind="attrs"
                v-on="on"
                color="dark"
              >
            <v-icon  left >  mdi-car</v-icon> Dinámica
            </v-btn>
            </v-row>
            </template>

          <v-card>
              <v-card-title>Artículos</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetD1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Videos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.tema == 'Dinámica'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-list-item  @click="sheetD1 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='v'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-play-circle </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              <v-container></v-container>


               <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetD2">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Imágenes</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.tema == 'Dinámica'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-list-item  @click="sheetD2 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='i'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-image </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>


                <v-container></v-container>

                <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetD3">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Documentos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.tema == 'Dinámica'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-list-item  @click="sheetD3 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='a'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-document </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="blue darken-1" text @click="dialogf3 = false"> Cerrar</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          <v-container></v-container>
     </v-container>
     </v-card>
      
    </v-col>
   
    




    <v-col >
      <v-card
          class="estiloC"
          outlined
          tile
        >
      <v-container>
          <v-container></v-container>
           

<v-dialog v-model="dialogq1" scrollable max-width="700px">

            <template v-slot:activator="{ on, attrs }">
            <v-row justify="center">
                        <v-container></v-container>

            <v-btn
                class="subheading"
                large
                dark
                center
                v-bind="attrs"
                v-on="on"
                color="dark"
              >
            <v-icon  left >   mdi-pine-tree </v-icon> Química básica
            </v-btn>
            </v-row>
            </template>

          <v-card>
              <v-card-title>Artículos</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetQ1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Videos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.tema == 'Química Básica'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-list-item  @click="sheetQ1 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='v'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-play-circle </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              <v-container></v-container>


               <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetQ2">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Imágenes</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.tema == 'Química Básica'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-list-item  @click="sheetQ2 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='i'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-image </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>


                <v-container></v-container>

                <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetQ3">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Documentos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.tema == 'Química Básica'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-list-item  @click="sheetQ3 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='a'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-document </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="blue darken-1" text @click="dialogq1 = false"> Cerrar</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>

          

<v-container></v-container>
           


<v-dialog v-model="dialogq2" scrollable max-width="700px">

            <template v-slot:activator="{ on, attrs }">
            <v-row justify="center">
            <v-btn
                class="subheading"
                large
                dark
                center
                v-bind="attrs"
                v-on="on"
                color="dark"
              >
            <v-icon  left >  mdi-biohazard </v-icon> Química orgánica
            </v-btn>
            </v-row>
            </template>

          <v-card>
              <v-card-title>Artículos</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetQO1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Videos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.tema == 'Química Orgánica'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-list-item  @click="sheetQO1 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='v'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-play-circle </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              <v-container></v-container>


               <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetQO2">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Imágenes</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.tema == 'Química Orgánica'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-list-item  @click="sheetQO2 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='i'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-image </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>


                <v-container></v-container>

                <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetQO3">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        small
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                    <v-list>
                      <v-subheader>Documentos</v-subheader>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.tema == 'Química Orgánica'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-list-item  @click="sheetQO3 = false">
                     
            <v-row>
              <v-col>
              <div  v-if="article.tipo[0] =='a'"> 
              <v-text class="estiloArticle">  
                <v-icon medium left color="blue">mdi-file-document </v-icon> {{article.title}} 
              </v-text> 
              </div>
              </v-col>
              <v-col>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark"  :href="'http://localhost:9898/downloadFile/'+ article.article_id" > 
                <v-icon small left color=" darken">mdi-arrow-down-bold-box </v-icon>  Descargar 
              </v-btn>

              </v-col>
            </v-row>
                     </v-list-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-list>
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="blue darken-1" text @click="dialogq2 = false"> Cerrar</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          <v-container></v-container>
          <v-container></v-container>
          <v-container></v-container>
          
        </v-container>
        </v-card>
    </v-col>
    </v-row>
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
           sheet:false,
           sheet2:false,
           sheet3:false,
           dialog1:false,

           sheetG1:false,
           sheetG2:false,
           sheetG3:false,
           dialog2:false,

           sheetE1:false,
           sheetE2:false,
           sheetE3:false,
           dialog3:false,

           sheetM1:false,
           sheetM2:false,
           sheetM3:false,
           dialogf1:false,

           sheetC1:false,
           sheetC2:false,
           sheetC3:false,
           dialogf2:false,

           sheetD1:false,
           sheetD2:false,
           sheetD3:false,
           dialogf3:false,

           sheetQ1:false,
           sheetQ2:false,
           sheetQ3:false,
           dialogq1:false,

           sheetQO1:false,
           sheetQO2:false,
           sheetQO3:false,
           dialogq2:false


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
    methods:{
      
      down(){
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

      async Validar(article){
        article.aceptado = true;
        let updated_article = await this.$store.dispatch("updateArticle",article);
          if(updated_article.error){
            alert(updated_article.error);
          }else{
            alert("Se ha validado correctamente")
          }
          this.$router.push("/mainpage")
      },
      Eliminar(article){
        let response = confirm(`¿Estás seguro que deseas eliminar este articulo? ${this.currentUser.username}`);
        if(response){
          this.$store.dispatch('deleteArticle',article);
          this.$router.push("/mainpage");

        }
      }


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

.estiloL {
        text-align: center;
        font-size: 40px;
        color: white;
       
        
       //background-color: rgba(94, 175, 141, 0.664);

    }

.estiloM {
        text-align: center;
        font-size: 40px;
       
        
       //background-color: rgba(94, 175, 141, 0.664);

    }

    .estiloF{
    background-color: rgb(0, 0, 0);
        
}

    .estiloC{
    //background-color: rgb(94, 175, 141, 0.664);
    background-color: #00897B;


    }

</style>
