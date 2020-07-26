<template>
<v-container v-if="currentUser.admin == true">


<v-container/>

    <router-link  to="/buscar"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
    <v-icon >mdi-chevron-right</v-icon>
    <v-text class="estiloT" color="grey"> Solicitudes </v-text> 


  <v-container/>
  <v-container/>


  <v-row justify="center">

      <v-card class ="estiloSubCard " color=#F44336
      
      height="450" width="800"
      
      >
        <v-toolbar
          dark
          tabs
          flat
          color=#F44336
        > 
        <v-spacer/>

        <v-text class="estiloT" color="grey"> Matemática </v-text> 
          
          <v-spacer></v-spacer>

          <template v-slot:extension>
       
            <v-tabs
              v-model="tabs"
              align-with-title
            >
              <v-tab href="#one"> Álgebra </v-tab>
              <v-tab href="#two"> Geometría </v-tab>
              <v-tab href="#three"> Ecuaciones </v-tab>

              <v-tabs-slider color=#01579B></v-tabs-slider>
            </v-tabs>

          </template>
        </v-toolbar>
        
        <v-card-text >

          <v-tabs-items v-model="tabs" color=#FF5722>
            
            <v-tab-item
              v-for="content in ['one', 'two', 'three']"
              :key="content"
              :value="content"
              color=#FF5722
            >
              <div  v-if="content == 'one'"  >
                <v-col>
                 
                    <v-slide-group
                      v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      color="#FF5722"
                    >
                    
                      <v-slide-item
                        v-for="article in articles" 
                        :key="article.article_id"
                      >
                      <div v-if="article.aceptado == false" >
                        <div v-if="article.curso == 'Matemática'" >
                          <div v-if="article.tema == 'Álgebra'" >
                            <v-col>
                            <v-card
                              class="estiloinCard"
                              height="180"
                              width="300"
                              color=#F44336
                            >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >
         <v-container/>
          <v-text class="estiloTa"  align="center"
            justify="center">  {{article.title}} </v-text>

          <v-container/>
            <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                large ><v-icon left>mdi-eye</v-icon> <router-link class="white--text" :to="{ name: 'previsualizar', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link></v-btn>
          <v-container/>

          </v-row>
        </v-card>
        
        </v-col>
        
          </div>
          </div>
          </div>
      </v-slide-item>
    </v-slide-group>

</v-col>
</div>


   <div  v-if="content == 'two'" >

        <v-col>

 
    <v-slide-group
      v-model="model"
      class="pa-4"
      prev-icon="mdi-minus"
      next-icon="mdi-plus"
      show-arrows
    >
      <v-slide-item
       v-for="article in articles" 
          :key="article.article_id"
      >
      <div v-if="article.aceptado == false" >
        <div v-if="article.curso == 'Matemática'" >
          <div v-if="article.tema == 'Geometría'" >
      
         <v-col>
                            <v-card
                              class="estiloinCard"
                              height="180"
                              width="300"
                              color=#F44336
                            >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >
         <v-container/>
          <v-text class="estiloTa"  align="center"
            justify="center"> {{article.title}} </v-text>

          <v-container/>
            <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                large ><v-icon left>mdi-eye</v-icon> <router-link class="white--text" :to="{ name: 'previsualizar', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link></v-btn>
          <v-container/>

          </v-row>
        </v-card>
        
        </v-col>
          </div>
          </div>
          </div>
      </v-slide-item>
    </v-slide-group>

</v-col>
</div>




<div  v-if="content == 'three'" >

<v-col>

 
    <v-slide-group
      v-model="model"
      class="pa-4"
      prev-icon="mdi-minus"
      next-icon="mdi-plus"
      show-arrows
    >
      <v-slide-item
       v-for="article in articles" 
          :key="article.article_id"
      >
      <div v-if="article.aceptado == false" >
        <div v-if="article.curso == 'Matemática'" >
          <div v-if="article.tema == 'Ecuaciones'" >
      
         <v-col>
                            <v-card
                              class="estiloinCard"
                              height="180"
                              width="300"
                              color=#F44336
                            >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >
         <v-container/>
          <v-text class="estiloTa"  align="center"
            justify="center"> {{article.title}} </v-text>

          <v-container/>
            <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                large ><v-icon left>mdi-eye</v-icon> <router-link class="white--text" :to="{ name: 'previsualizar', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link></v-btn>
          <v-container/>

          </v-row>
        </v-card>
        
        </v-col>
          </div>
          </div>
          </div>
      </v-slide-item>
    </v-slide-group>
  

</v-col>
</div>

        </v-tab-item>
      </v-tabs-items>
      <v-container/>
    </v-card-text>
    
  </v-card>
  

</v-row>


<v-container/>
<v-container/>

  


<v-row justify="center">

      <v-card class ="estiloSubCard "  color=#01579B
      height="450" width="800">
        <v-toolbar
          dark
          tabs
          flat
          color=#01579B
        > 
        <v-spacer/>

        <v-text class="estiloT" color="grey"> Física </v-text> 
          
          <v-spacer></v-spacer>
          <template v-slot:extension>
       
            <v-tabs
              v-model="tabsF"
              align-with-title
            >
              <v-tab href="#oneF"> Magnetismo </v-tab>
              <v-tab href="#twoF"> Cinemática </v-tab>
              <v-tab href="#threeF"> Dinámica </v-tab>
              <v-tabs-slider color="#F44336"></v-tabs-slider>
            </v-tabs>

          </template>
        </v-toolbar>
        
        <v-card-text >

          <v-tabs-items v-model="tabsF" color=#FF5722>
            <v-tab-item
              v-for="content in ['oneF', 'twoF', 'threeF']"
              :key="content"
              :value="content"
              color=#FF5722
            >
 <div  v-if="content == 'oneF'" >

        <v-col>

 
    <v-slide-group
      v-model="model"
      class="pa-4"
      prev-icon="mdi-minus"
      next-icon="mdi-plus"
      show-arrows
    >
      <v-slide-item
       v-for="article in articles" 
          :key="article.article_id"
      >
      <div v-if="article.aceptado == false" >
        <div v-if="article.curso == 'Física'" >
          <div v-if="article.tema == 'Magnetismo'" >
      
       <v-col>
                            <v-card
                              class="estiloinCard"
                              height="180"
                              width="300"
                              color=#01579B
                            >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >
         <v-container/>
          <v-text class="estiloTa"  align="center"
            justify="center"> {{article.title}} </v-text>

          <v-container/>
            <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                large ><v-icon left>mdi-eye</v-icon> <router-link class="white--text" :to="{ name: 'previsualizar', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link></v-btn>
          <v-container/>

          </v-row>
        </v-card>
        
        </v-col>
          </div>
          </div>
          </div>
      </v-slide-item>
    </v-slide-group>
  

</v-col>
</div> 
 

<div  v-if="content == 'twoF'" >

        <v-col>

 
    <v-slide-group
      v-model="model"
      class="pa-4"
      prev-icon="mdi-minus"
      next-icon="mdi-plus"
      show-arrows
    >
      <v-slide-item
       v-for="article in articles" 
          :key="article.article_id"
      >
      <div v-if="article.aceptado == false" >
        <div v-if="article.curso == 'Física'" >
          <div v-if="article.tema == 'Cinemática'" >
      
        <v-col>
                            <v-card
                              class="estiloinCard"
                              height="180"
                              width="300"
                              color=#01579B
                            >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >
         <v-container/>
          <v-text class="estiloTa"  align="center"
            justify="center"> {{article.title}} </v-text>

          <v-container/>
            <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                large ><v-icon left>mdi-eye</v-icon> <router-link class="white--text" :to="{ name: 'previsualizar', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link></v-btn>
          <v-container/>

          </v-row>
        </v-card>
        
        </v-col>
          </div>
          </div>
          </div>
      </v-slide-item>
    </v-slide-group>

</v-col>
</div> 



<div  v-if="content == 'threeF'" >

        <v-col>

    <v-slide-group
      v-model="model"
      class="pa-4"
      prev-icon="mdi-minus"
      next-icon="mdi-plus"
      show-arrows
    >
      <v-slide-item
       v-for="article in articles" 
          :key="article.article_id"
      >
      <div v-if="article.aceptado == false" >
        <div v-if="article.curso == 'Física'" >
          <div v-if="article.tema == 'Dinámica'" >
      
        <v-col>
                            <v-card
                              class="estiloinCard"
                              height="180"
                              width="300"
                              color=#01579B
                            >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >
         <v-container/>
          <v-text class="estiloTa"  align="center"
            justify="center"> {{article.title}} </v-text>

          <v-container/>
            <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                large ><v-icon left>mdi-eye</v-icon> <router-link class="white--text" :to="{ name: 'previsualizar', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link></v-btn>
          <v-container/>

          </v-row>
        </v-card>
        
        </v-col>
          </div>
          </div>
          </div>
      </v-slide-item>
    </v-slide-group>

</v-col>
</div> 


        </v-tab-item>
      </v-tabs-items>
    </v-card-text>
    
  </v-card>

</v-row>

<v-container/>
<v-container/>


<v-row justify="center">


      <v-card class ="estiloSubCard " id="lateral"  color=#FFC400
      height="450" width="800"

      
      >
        <v-toolbar
          dark
          tabs
          flat
          color=#FFC400
        > 
        <v-spacer/>

        <v-text class="estiloT" color="grey"> Química </v-text> 
          
          <v-spacer></v-spacer>
          <template v-slot:extension>
       
            <v-tabs
              v-model="tabsQ"
              align-with-title
            >
              <v-tab href="#oneQ"> Química básica </v-tab>
              <v-tab href="#twoQ"> Química orgánica </v-tab>
              <v-tabs-slider color=#01579B></v-tabs-slider>
            </v-tabs>

          </template>
        </v-toolbar>
        
        <v-card-text >

          <v-tabs-items v-model="tabsQ" color=#FF5722>
            <v-tab-item
              v-for="content in ['oneQ', 'twoQ']"
              :key="content"
              :value="content"
              color=#FF5722
            >

<div  v-if="content == 'oneQ'" >

        <v-col>

  
    <v-slide-group
      v-model="model"
      class="pa-4"
      prev-icon="mdi-minus"
      next-icon="mdi-plus"
      show-arrows
    >
      <v-slide-item
       v-for="article in articles" 
          :key="article.article_id"
      >
      <div v-if="article.aceptado == false" >
        <div v-if="article.curso == 'Química'" >
          <div v-if="article.tema == 'Química Básica'" >
      
        <v-col>
                            <v-card
                              class="estiloinCard"
                              height="180"
                              width="300"
                              color=#FFC400
                            >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >
         <v-container/>
          <v-text class="estiloTa"  align="center"
            justify="center"> {{article.title}} </v-text>

          <v-container/>
            <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                large ><v-icon left>mdi-eye</v-icon> <router-link class="white--text" :to="{ name: 'previsualizar', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link></v-btn>
          <v-container/>

          </v-row>
        </v-card>
        
        </v-col>






          </div>
          </div>
          </div>
      </v-slide-item>
    </v-slide-group>

</v-col>
</div> 


<div  v-if="content == 'twoQ'" >

        <v-col>

  
    <v-slide-group
      v-model="model"
      class="pa-4"
      prev-icon="mdi-minus"
      next-icon="mdi-plus"
      show-arrows
    >
      <v-slide-item

       v-for="article in articles" 
          :key="article.article_id"
      >
      <div v-if="article.aceptado == false" >
        <div v-if="article.curso == 'Química'" >
          <div v-if="article.tema == 'Química Orgánica'" >
      
        <v-col>
                            <v-card
                              class="estiloinCard"
                              height="180"
                              width="300"
                              color=#CFD8DC
                            >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >
         <v-container/>
          <v-text class="estiloTa"  align="center"
            justify="center"> {{article.title}} </v-text>

          <v-container/>
            <v-btn 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                large ><v-icon left>mdi-eye</v-icon> <router-link class="white--text" :to="{ name: 'previsualizar', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link></v-btn>
          <v-container/>

          </v-row>
        </v-card>
        
        </v-col>
          </div>
          </div>
          </div>
      </v-slide-item>
    </v-slide-group>

</v-col>
</div>   
        </v-tab-item>
      </v-tabs-items>
    </v-card-text>
    
  </v-card>

</v-row>


</v-container> 











<v-container v-else-if="currentUser.username" >

  <v-row justify="left">

    
          <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
          <v-icon >mdi-chevron-right</v-icon>
          <v-text class="estiloT" color="grey"> Buscar StayFiles </v-text> 
  
  </v-row>
    

    <v-container/>
    <v-container/>

   
    <v-row class="estiloM" >
        
      <v-col center>
        <v-flex xs12>
        <v-card
          class="estiloC"
          color=#FFC400

          
        >
         <v-text class=estiloL> Matemática </v-text>

        </v-card>
        
         </v-flex>
      </v-col>
      
      <v-col center  >
        <v-flex xs12>
        <v-card
          class="estiloC"
          color=#FFC400 
        >
        
        <v-text class=estiloL>  Física </v-text>
           </v-card>
         </v-flex>
      </v-col>
      
      
      <v-col center>
        <v-flex xs12>
        <v-card
          class="estiloC"
           color=#FFC400

        >
         <v-text class=estiloL>  Química </v-text>
          </v-card>
         </v-flex>
      </v-col>
    </v-row>
    
  
   <v-container/>

    <v-row >
      <v-col >
        <v-layout colum  >
        <v-flex  >
        <v-card
          class="estiloC"
          color=#FFC400
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
            <v-icon left>mdi-numeric</v-icon> Álgebra
            </v-btn>
            </v-row>
            </template>

            <v-card class="estiloB"
                height="340px" 
                color=#E0F2F1
            >

              
              <v-card-title> StayFiles </v-card-title>

              <template>

                <div class="text-center">

                  <v-bottom-sheet v-model="sheet">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon medium left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>



                    <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Álgebra'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-slide-item  @click="sheet = false">
                     
              
              <div  v-if="article.tipo[0] =='v'"> 

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

                <v-icon  medium left color="white" > mdi-play-circle </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" > {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">{{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >


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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon medium left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>


                    <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark
                      >

                      <div  v-for="article in articles" :key="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.tema == 'Álgebra'">
                      <div  v-if="article.tipo[0] == 'i'">

                      <v-slide-item  @click="sheet2 = false">
                     
           
               <div  v-if="article.tipo[0] =='i'"> 


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
                
                <v-icon medium left color="white">mdi-file-image </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>

                
              </v-text> 
              
              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto"> {{article.countdislikes}} </v-text>
              <v-container/>
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon> <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
             </v-col>
              <v-spacer/>
              <v-container/>
              

              </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>

                    </v-slide-group>


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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon medium left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>


                    <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>
                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.aceptado == true">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.tema == 'Álgebra'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-slide-item  @click="sheet3 = false">
                      <div  v-if="article.tipo[0] =='a'"> 

                     
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

                <v-icon medium left color="white">mdi-file-document </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              </v-text> 
              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>

              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link> 
              </v-btn>


              

            </v-row>
              </v-card>
              </v-col>
              </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group>
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions >

                  <v-btn color="dark" large dark  @click="dialog1 = false"> Cerrar</v-btn>

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

          <v-card
                class="estiloB"
                height="340px" 
                color=#E0F2F1
          >
              <v-card-title>StayFiles</v-card-title>



              <template>


                <div class="text-center">
                  <v-bottom-sheet v-model="sheetG1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>



                    
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Geometría'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-slide-item  @click="sheet = false">
                     
              
              <div  v-if="article.tipo[0] =='v'"> 

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

                <v-icon  medium left color="white" > mdi-play-circle </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" > {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto"> {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>


                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Geometría'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-slide-item  @click="sheet1 = false">
                     
              
              <div  v-if="article.tipo[0] =='i'"> 

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

                <v-icon  medium left color="white" > mdi-file-image </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Geometría'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-slide-item  @click="sheet = false">
                     
              
              <div  v-if="article.tipo[0] =='a'"> 

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

                <v-icon  medium left color="white" > mdi-file-document </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" > {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="color" dark @click="dialog2 = false"> Cerrar</v-btn>
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

          <v-card
          class="estiloB"
                height="340px" 
                color=#E0F2F1>
              <v-card-title>StayFiles</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetE1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Ecuaciones'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-slide-item  @click="sheet = false">
                     
              
              <div  v-if="article.tipo[0] =='v'"> 

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

                <v-icon  medium left color="white" > mdi-play-circle </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" > {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Ecuaciones'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-slide-item  @click="sheet2 = false">
                     
              
              <div  v-if="article.tipo[0] =='i'"> 

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

                <v-icon  medium left color="white" > mdi-file-image </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Matemática'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Ecuaciones'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-slide-item  @click="sheet3 = false">
                     
              
              <div  v-if="article.tipo[0] =='a'"> 

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

                <v-icon  medium left color="white" > mdi-file-document </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="dark" dark @click="dialog3 = false"> Cerrar</v-btn>
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
         color=#FFC400
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

          <v-card
           class="estiloB"
                height="340px" 
                color=#E0F2F1>
              <v-card-title>StayFiles</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetM1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>

                     <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Magnetismo'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-slide-item  @click="sheetM1 = false">
                     
              
              <div  v-if="article.tipo[0] =='v'"> 

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

                <v-icon  medium left color="white" > mdi-play-circle </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Magnetismo'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-slide-item  @click="sheetM2 = false">
                     
              
              <div  v-if="article.tipo[0] =='i'"> 

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

                <v-icon  medium left color="white" > mdi-file-image </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Magnetismo'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-slide-item  @click="sheetM3 = false">
                     
              
              <div  v-if="article.tipo[0] =='a'"> 

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

                <v-icon  medium left color="white" > mdi-file-document </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="color" dark @click="dialogf1 = false"> Cerrar</v-btn>
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

          <v-card  class="estiloB"
                height="340px" 
                color=#E0F2F1>
              <v-card-title>StayFiles</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetC1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>

                     <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Cinemática'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-slide-item  @click="sheetC1 = false">
                     
              
              <div  v-if="article.tipo[0] =='v'"> 

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

                <v-icon  medium left color="white" > mdi-play-circle </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Cinemática'">
                      <div  v-if="article.tipo[0] == 'i'">

                      <v-slide-item  @click="sheetC2 = false">
                     
              
              <div  v-if="article.tipo[0] =='i'"> 

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

                <v-icon  medium left color="white" > mdi-file-image </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                    <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Cinemática'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-slide-item  @click="sheetC1 = false">
                     
              
              <div  v-if="article.tipo[0] =='a'"> 

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

                <v-icon  medium left color="white" > mdi-file-document </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="dark" dark @click="dialogf2 = false"> Cerrar</v-btn>
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

          <v-card class="estiloB"
                height="340px" 
                color=#E0F2F1>
              <v-card-title>StayFiles</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetD1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Dinámica'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-slide-item  @click="sheetD1 = false">
                     
              
              <div  v-if="article.tipo[0] =='v'"> 

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

                <v-icon  medium left color="white" > mdi-play-circle </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Dinámica'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-slide-item  @click="sheetD1 = false">
                     
              
              <div  v-if="article.tipo[0] =='i'"> 

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

                <v-icon  medium left color="white" > mdi-file-image </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" > {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Física'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Dinámica'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-slide-item  @click="sheetD3 = false">
                     
              
              <div  v-if="article.tipo[0] =='a'"> 

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

                <v-icon  medium left color="white" > mdi-file-document </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="dark" dark @click="dialogf3 = false"> Cerrar</v-btn>
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
         color=#FFC400
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

          <v-card  class="estiloB"
                height="340px" 
                color=#E0F2F1>
              <v-card-title>StayFiles</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetQ1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Química Básica'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-slide-item  @click="sheetQ1 = false">
                     
              
              <div  v-if="article.tipo[0] =='v'"> 

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

                <v-icon  medium left color="white" > mdi-play-circle </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Química Básica'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-slide-item  @click="sheetQ2 = false">
                     
              
              <div  v-if="article.tipo[0] =='i'"> 

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

                <v-icon  medium left color="white" > mdi-file-image </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto"> {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Química Básica'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-slide-item  @click="sheetQ1 = false">
                     
              
              <div  v-if="article.tipo[0] =='a'"> 

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

                <v-icon  medium left color="white" > mdi-file-document </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="dark" dark @click="dialogq1 = false"> Cerrar</v-btn>
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

          <v-card  class="estiloB"
                height="340px" 
                color=#E0F2F1>
              <v-card-title>StayFiles</v-card-title>
              <template>
                <div class="text-center">
                  <v-bottom-sheet v-model="sheetQO1">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="dark"
                        dark
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Videos
                      </v-btn>
                    </template>
                     <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Química Orgánica'">
                      <div  v-if="article.tipo[0] == 'v'">
                      <v-slide-item  @click="sheetQO1 = false">
                     
              
              <div  v-if="article.tipo[0] =='v'"> 

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

                <v-icon  medium left color="white" > mdi-play-circle </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Imágenes
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Química Orgánica'">
                      <div  v-if="article.tipo[0] == 'i'">
                      <v-slide-item  @click="sheetQO2 = false">
                     
              
              <div  v-if="article.tipo[0] =='i'"> 

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

                <v-icon  medium left color="white" > mdi-file-image </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
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
                        large
                        v-bind="attrs"
                        v-on="on"
                      >
                        <v-icon small left color=" darken">mdi-folder</v-icon> Documentos
                      </v-btn>
                    </template>
                      <v-slide-group 
                    
                    v-model="model"
                      class="pa-4"
                      prev-icon="mdi-minus"
                      next-icon="mdi-plus"
                      show-arrows
                      dark>

                      <div  v-for="article in articles" :key ="article.article_id">
                      <div  v-if="article.curso == 'Química'">
                      <div  v-if="article.aceptado == true ">
                      <div  v-if="article.tema == 'Química Orgánica'">
                      <div  v-if="article.tipo[0] == 'a'">
                      <v-slide-item  @click="sheetQO1 = false">
                     
              
              <div  v-if="article.tipo[0] =='a'"> 

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

                <v-icon  medium left color="white" > mdi-file-document </v-icon> <v-text class="estiloTexto"> {{article.title}} </v-text>
              
              </v-text> 

              <v-container/>

        

               <v-icon medium left color="white">mdi-thumb-up </v-icon> <v-text class="estiloTexto" >  {{article.countlikes}}</v-text>  
             
              <v-icon medium left color="white">mdi-thumb-down </v-icon><v-text class="estiloTexto">  {{article.countdislikes}} </v-text>
              <v-container/>


             
              
              <v-btn  small
                      dark
                      v-bind="attrs"
                      v-on="on"
                      color="dark" > 
                <v-icon small left color=" darken">mdi-eye </v-icon>  
              <router-link class="white--text" :to ="{ name: 'previsualizarUser', params:{ id: article.article_id}}"> <v-text color="white">Previsualizar </v-text> </router-link>
              </v-btn>

              </v-row>
              </v-card>
              </v-col>

                </div>
                     </v-slide-item>
                     </div>
                     </div>
                     </div>
                     </div>
                     </div>
                    </v-slide-group >
                  </v-bottom-sheet>
                </div>
              </template>
              
                   <v-divider></v-divider>
                 <v-card-actions>
                  <v-btn color="dark" dark @click="dialogq2 = false"> Cerrar</v-btn>
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

          dialogA: false,

         tabs: null,
         
         tabsF:null,

         tabsQ:null,

         length: 3,
         onboarding: 0,


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
           dialogq2:false,


        }
    },

  
    computed: {
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
      async addarticle(){
        this.playlist.user = this.currentUser;
        console.log(this.playlist);
        let reponse_articlepack = await this.$store.dispatch('addArticlepack',this.playlist);
        if(reponse_articlepack.error){
          alert(reponse_articlepack.error);
        }else{
           alert('El StayPack ' + reponse_articlepack.name + ' se ha creado correctamente');
           this.$router.go(0);//MAGIA//
        }
      }

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
    border-radius: 20px;



    }

    .estiloTituloAdmin{
        text-align: left;
        font-size: 40px;    



    }



.estilo {
        font-size:40px;
    }

.estiloP {
        font-size: 15px;
        font-family: "Lucida Console", Courier, monospace;
    }

 .estiloTa{
   font-size: 18px;
 }   


 .estiloSubCard{

    border-radius: 20px;

  } 

  
 .estiloinCard{

    border-radius: 30px;
    
    class:ma-4


  } 

  .estiloT{
   font-size: 25px;
 }   

 .estiloB{
    border-radius: 30px;
 } 


 .estiloD{
   font-size: 25px;
   text-align: center;
 }    

 
 .estiloN{
   font-size: 15px;
   text-align: center;
 }  

 .estiloN{
   color: white;
   
 }  

 .estiloTexto{
   color: white;
   
 } 




</style>