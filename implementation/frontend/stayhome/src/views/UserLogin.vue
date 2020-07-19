<template>
  <v-container>
    <v-form >
      <v-container class="fill-height" fluid justify="center">
        <v-row align="center" justify="center">
          <v-col md="6">
            <v-card class="estiloCard">
              <v-container/>
              <v-row justify="center">
                 <v-text class="estilo">Iniciar sesión</v-text>
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
                        <v-text-field v-model="loginInfo.email" label="Correo" :rules="emailRules"/>
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
                        <v-text-field v-model="loginInfo.password" 
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
                    <v-btn x-large @click="loginUser"   :disabled="!valid" :loading="loading" dark> Entrar </v-btn>
                  </v-card-actions>
                </v-row>
                <v-row justify="center">	
                  <router-link class="estiloP" to="/registration" > <v-text class="estiloP"> ¿No tienes una cuenta? ¡Registrate aquí! </v-text> </router-link>
                </v-row>
                <v-container/>
              </v-form>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
  </v-container>
</template>


<script>
export default {
  name: 'Login',
  props: {
      source: String,
    },
  data() {
    return {
      showPassword : false,
      valid:false,
      loading: false,
      loginInfo:{
        user_id: '',
        username: '',
        email: '',
        password: '',
        contador_articlepack: '',
        admin: false
      },
      emailRules: [
        v => !!v || 'Correo requerido',
        v => /.+@.+\..+/.test(v) || 'Correo tiene que ser valido',
      ],
      passwordRules: [
        v => !!v || 'Contraseña requirido',
        v => (v && v.length <= 20) || 'Contraseña tiene que ser menor que 20 caracteres',
      ]
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
  mounted(){
    this.$store.dispatch("loadAll")
  },
  methods: {
    async loginUser(){
      /* Autenticar */
      let password = '';
      let admin = '';
      let validator = await this.$store.dispatch("loadAll");
      console.log(validator.data)
       for(var i = 0; i < validator.data.length; i++){
         if(this.loginInfo.email === validator.data[i].email){
           this.loginInfo.user_id = validator.data[i].user_id;
           this.loginInfo.username = validator.data[i].username;
           this.loginInfo.contador_articlepack = validator.data[i].contador_articlepack
           password = validator.data[i].password;

           if(validator.data[i].admin == true){
                admin = validator.data[i].admin;
                this.loginInfo.admin = admin
           }else{
                this.loginInfo.admin = false;
           }

         }
       }
       if(this.loginInfo.password == password){
          /* Fin Autenticar */
          let user = await this.$store.dispatch('loginUser',this.loginInfo);
          console.log(user);
          if(user.error){
            alert(user.error)
          }else{
            alert('Gracias por iniciar sesión, ' + user.username);
            this.loading = true;
            setTimeout(() => { 
                if(this.loginInfo.admin == false){
                    this.$router.push('/myplaylists');
                }else{
                    this.$router.push('/buscar');
                }
            },1000);
          }
       }else{
         alert('Correo/Contraseña incorrectos, intenta denuevo')
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

  .estiloP {
    font-size: 17px;
    color: white;
  }
  .estiloT{
    font-size: 25px;
  }   
  .estiloC{
    background-color: #F44336;
  }
  .estiloSubCard{
    border-radius: 20px;
  } 
  .estiloCard{
    background-color: #F44336;
    border-radius: 30px;
  }   

</style>