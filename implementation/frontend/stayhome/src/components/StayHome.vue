<template>
  <v-container>
      <v-container class="grey lighten-3">
        <v-row class="text-center" >
          <v-col
            v-for="(item,n) in items"
            :key="n"
            cols="100"
            sm="4"
          >
            <v-card
              class="titulo"
              outlined
              tile
              align="center" justify="center"
            >
              {{item.title}} 
            </v-card>
            <v-row  >
          <v-col
            v-for="(item2,i) in items2"
            :key="i"
            cols="100"
            sm="4"

          >
          <v-bottom-navigation
                v-model="bottomNav"
                dark
            >

            <v-btn
              class="white--text"
              tile
              dark
              center
            >
            <span>{{item2.title}}</span>
            <v-icon > {{item2.icon}} </v-icon>

            </v-btn>
            </v-bottom-navigation> 
          </v-col>
        </v-row>
          </v-col>
        </v-row>
      </v-container>
     
      <v-container>
       
    <v-card flat tile>
    <v-window v-model="onboarding" vertical >
      <v-window-item
        v-for="n in length"
        :key="`card-${n}`"
        
      >
        <v-card
          color="grey"
          height="200"
          width="340"
        >
          <v-row
            class="fill-height"
            align="center"
            justify="center"
            tag="v-card-text"
          >
            <h1 style="font-size: 5rem;" class="white--text">Artículo {{ n }}</h1>
          </v-row>
        </v-card>
      </v-window-item>
    </v-window>

    <v-card-actions class="justify-left">
      <v-btn
        text
        @click="prev"
        
      >
        <v-icon>mdi-chevron-up</v-icon>
      </v-btn>
      <v-item-group
        v-model="onboarding"
        class="text-center"
        mandatory
      >
     
      </v-item-group>
      <v-btn
        text
        @click="next"
      >
        <v-icon>mdi-chevron-down</v-icon>
      </v-btn>
    </v-card-actions>
  </v-card>
      </v-container>
      <v-container style="center" class="text-md-center" justify="center">
         <v-btn
          :loading="loading3"
          :disabled="loading3"
          color="blue-grey"
          class="ma-2 white--text"
          @click="loader = 'loading3'"
          
         
        >
          Upload
        <v-icon right dark>mdi-cloud-upload</v-icon>
        </v-btn>



      </v-container>

</v-container>
</template>

<script>
import { mapState } from 'vuex';
export default {

    
    
    name: 'StayHome',
    data(){
        return{

          length: 3,
          onboarding: 0,

           loader: null,
           loading3: false,

            bottomNav: 2,
            
             items: [
          {
            title: 'Matemática',
          },
          {
            title: 'Física',
          },
          {
            title: 'Química',
          }
            ],

             items2: [
          {
            title: 'Videos', icon: 'mdi-television-play'
          },
          {
            title: 'Docs', icon: 'mdi-book'
          },
          {
            title: 'Imágenes', icon: 'mdi-image'
          }
            ]
        }
    },
    computed: {

        ...mapState(['currentUser'])

    },
    mounted(){
    this.$store.dispatch("loadAll")
    },
    methods:
    {
        admin()
        {
                this.$router.push("/update")
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




</style>
