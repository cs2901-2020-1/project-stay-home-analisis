<template>
<v-container >
<v-container class="fill-height" fluid justify="center">
        <v-row align="center" justify="center">
          <v-col md="6">
            <v-card class="estiloC">
              <v-container/>
              <v-row justify="center">
                 <v-text class="estilo">Registrarte</v-text>
              </v-row>
              <v-spacer></v-spacer>
              <v-form  v-model="valid"> 
                <v-card-text>
                  <v-card class="estiloSubCard" height="100px" width="800px">
                    <v-row justify="center">
                      <div class="display-4">
                        <v-avatar tile color=#212121>
                          <v-icon x-large color=#FFFFFF>mdi-account</v-icon>
                        </v-avatar>
                      </div>
                      <v-col justify="center" md="8">
                        <v-text-field v-model="registerInfo.username" label="Usuario" :rules="nameRules"/>
                      </v-col>
                    </v-row>
                    <v-container/>
                  </v-card>
                  <v-container/>

                  <v-card class="estiloSubCard" height="100px" width="800px">
                    <v-row justify="center">
                      <div class="display-4">
                        <v-avatar tile color=#212121>
                          <v-icon x-large color=#FFFFFF>mdi-email</v-icon>
                        </v-avatar>
                      </div>
                      <v-col justify="center" md="8">
                        <v-text-field v-model="registerInfo.email" label="Correo" :rules="emailRules"/>
                      </v-col>
                    </v-row>
                    <v-container/>
                  </v-card>
                  <v-container/>

                  <v-card class="estiloSubCard" height="100px" width="800px">
                    <v-row justify="center">
                      <div class="display-4">
                        <v-avatar tile color=#212121>
                          <v-icon x-large color=#FFFFFF>mdi-lock</v-icon>
                        </v-avatar>
                      </div>
                      <v-col justify="center" md="8">
                        <v-text-field v-model="registerInfo.password" 
                          label="Contraseña" 
                          :type="showPassword ? 'text' : 'password' "
                          :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                          :rules="passwordRules"
                          @click:append="showPassword=!showPassword"
                        />
                      </v-col>
                    </v-row>
                    <v-container/>
                  </v-card>
                </v-card-text>
                <v-row justify="center">
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn x-large @click="registerUser"   :disabled="!valid" :loading="loading" dark> Regístrate </v-btn>
                  </v-card-actions>
                </v-row>
                <v-container/>
              </v-form>
            </v-card>
          </v-col>
        </v-row>
      </v-container> 
</v-container>  
</template>

<script>
export default {
  name: 'Register',
  data() {
    return {
      showPassword : false,
      loading: false,
      registerInfo:{
        user_id: '',
        username: '',
        email: '',
        password: '',
        contador_articlepack: 0,
        admin: false,
      },
       emailRules: [
        v => !!v || 'Correo requerido',
        v => /.+@.+\..+/.test(v) || 'El correo tiene que ser valido',
      ],
      nameRules: [
        v => !!v || 'Usuario requirido',
        v => (v && v.length <= 15) || 'El usuario tiene que ser menor que 15 caracteres',
      ],
      passwordRules: [
        v => !!v || 'Contraseña requirido',
        v => (v && v.length <= 20) || 'La contraseña tiene que ser menor que 20 caracteres',
      ]
    }
  },
  mounted(){
    this.$store.dispatch("loadAll")
  },
  methods: {
    async registerUser(){
   
      if(this.registerInfo.username != '' && this.registerInfo.email != '' && this.registerInfo.password != '' ){    
          let user = await this.$store.dispatch('registerUser',this.registerInfo);
          console.log(user);
          if(user.error){
            alert(user.error)
          }else{
            alert('Gracias por registrate en StayHome, ' + user.username);
            this.loading = true;

          setTimeout(() => {
            if(this.registerInfo.admin == false){
                this.$router.push('/myplaylists');
            }else{
                this.$router.push('/buscar');
            }
          },1000);

          }
      }else{
         alert('Hubo un error, intenta de nuevo')
      }
    }
  },
}
</script>



<style scoped>
  .v-progress-circular {
    margin: 1rem;
  }

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
  .estilo {
    font-size:50px;
    color:white;
        
  }   
  .estiloC{
    background-color: #FFC400;
    border-radius: 30px;
  }  
  .estiloSubCard{
    border-radius: 15px;
  } 
  
</style>