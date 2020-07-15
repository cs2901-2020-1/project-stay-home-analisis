<template>
    <v-container>

        <div>
            <v-btn @click="asd" >HOLA</v-btn>
        </div>
    
    </v-container>
</template>

<script>
import { mapState } from 'vuex';
import Api from "@/services/api";
export default {
    computed:{
        ...mapState(['articles']),
    },
    methods:{
        async asd(){
            let list_ids = [];
            let articlepack_response = await Api().get("/articlesporpack/67");
            for(var i = 0; i < articlepack_response.data.length; i++){
                list_ids[i] = articlepack_response.data[i].doublei.article_id;
            }
            console.log(list_ids);
        }
    }
}
</script>

<style>

</style>>