<template>
    <v-container>

      <v-container>
      <div class="titulo"> Stay Home </div>

      <v-container/>

      <v-carousel cycle 
      hide-delimiter-background
      show-arrows-on-hover
      class="estiloB"
      >
        <v-carousel-item
          v-for="(item,i) in items"
          :key="i"
          :src="item.src"
          reverse-transition="fade-transition"
          transition="fade-transition"
        ></v-carousel-item>
      </v-carousel>
      </v-container>

      <v-container/>

    </v-container>
</template>

<script>
import { mapState } from 'vuex';
export default {

  name: 'Home',
  computed: {
    ...mapState(['users'])
  },
  mounted(){
    this.$store.dispatch("loadAll")
  },
  methods: {

  },
  data () {
      return {
        items: [
          {
            src: 'https://cdn.discordapp.com/attachments/720494441214902293/723419765363965972/g4.png',
          },
          {
            src: 'https://e.rpp-noticias.io/normal/2017/10/13/035103_500349.jpg',
          },
          {
            src: 'http://pro-universitarios.com/wp-content/uploads/2015/04/Ceibal-1.gif',
          },
          {
            src: 'https://cde.laprensa.e3.pe/ima/0/0/1/5/3/153438.jpg',
          },

        ],
      }
    },
  }

</script>

<style lang="scss" scoped>

.titulo{
        //background-attachment: fixed;
        text-align: center;
        font-style: normal;
        font-size: 44px;
        letter-spacing: 0.8px;
        word-spacing: -1.6px;
        color: #000000;
        font-weight: 700;
        text-decoration: none solid rgb(68, 68, 68);
        font-variant: small-caps;
        text-transform: uppercase;
    }

    .estiloB{
    border-radius: 30px;
}

</style>