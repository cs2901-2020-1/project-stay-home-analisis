<template>
<div class="back" >
        
        <div class="perfil" center > Perfil</div>

         <v-container>
        <div class="text-center"  >
            <b-button-group  vertical center size="lg">
            <b-button @click="admin">Administrar Perfil</b-button>
            <b-button>Descargas</b-button>
            <b-button>Historial</b-button>
            </b-button-group>
        </div>
        </v-container>
</div>  
</template>

<script>
import { mapState } from 'vuex';
export default {
    name: 'StayHome',
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
        }
    }
}
       
</script>

<style lang="scss" scoped>


.back{
       
    
        background: rgba(121, 193, 196, 0.603);
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: center; 

        border: 2px solid gray;
        margin: 100px;
        width: 250px;
        height: 300px;
        float: center;

    .perfil{
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
}


</style>