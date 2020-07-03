<template>
    <v-container>
      <h1>Artículos:</h1>
      <div v-for="article in articles" :key ="article.article_id">
            <h1>
              {{article.title}}
              <v-btn x-small :href="'http://localhost:9898/downloadFile/'+article.article_id" >Descargar</v-btn>
        </h1>
      </div>

    </v-container>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: 'article-download',
  computed: {
    ...mapState(['articles'])
  },
  mounted(){
    this.$store.dispatch("loadAllArticles")
  },
  methods: {
  },
}
</script>