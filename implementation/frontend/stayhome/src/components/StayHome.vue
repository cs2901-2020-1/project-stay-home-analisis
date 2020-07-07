<template>
<v-container>
  <v-container v-if="currentUser.username">
    <h1 class="estilo"> {{currentUser.username}}  <v-text class="estiloc"> >> </v-text>  <v-text class="estiloI"> Inicio </v-text></h1>
    <v-container>  </v-container>
    <h2> Artículos</h2>
    <v-container>  </v-container>
    <v-btn class="white--text"  dark @click="down"> Ver artículos </v-btn>
    </v-container>
    <v-container v-else>
     Por favor inicia sesión
    </v-container>
</v-container>    
</template>

<script>
import { mapState } from 'vuex';
export default {

    
    
    name: 'StayHome',
    data(){
        return{
        }
    },
    computed: {
      videos(){return this.$store.state.articles},
        ...mapState(['currentUser'])
    },
    mounted(){
    this.$store.dispatch("loadAll");
    this.$store.dispatch("loadAllArticles");
    },
    methods:
    {
        down()
        {
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



</style>
