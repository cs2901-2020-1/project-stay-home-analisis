<template>
    <v-container>
    <div v-for="articles in articles_por_tupac" :key="articles.article_id">
       {{articles.doublei.article.title}}
    </div>   
    
    </v-container>
</template>

<script>
import { mapState } from 'vuex';
//import Api from "@/services/api";
export default {
    computed:{
        currentArticlePack(){
          return this.$store.state.articlepacks.find(ar => ar.article_id == this.$route.params.id)
        },
        ...mapState(['articles']),
        ...mapState(['articlepacks']),
        ...mapState(['articles_por_tupac'])

    },
    mounted(){
        this.$store.dispatch("loadAllArticles_tupac",this.$route.params.id)
    },
    methods:{/*
        async asd(){
            let list_ids = [];
            let articlepack_response = await Api().get("/articlesporpack/67");
            for(var i = 0; i < articlepack_response.data.length; i++){
                list_ids[i] = articlepack_response.data[i].doublei.article_id;
            }
            console.log(list_ids);
        }
        */
    }
}
</script>

<style>

</style>>