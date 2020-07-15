<template>
    <v-container>
      <h1>Iniciar sesión</h1>
      <v-spacer></v-spacer>
      <v-form v-model="valid">
        <v-text-field v-model="loginInfo.email" label="Correo" :rules="emailRules"/>
        <v-text-field v-model="loginInfo.password" 
                      label="Contraseña" 
                      :type="showPassword ? 'text' : 'password' "
                      :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                      :rules="passwordRules"
                      @click:append="showPassword=!showPassword"/>
        <v-btn @click="loginUser" :disabled="!valid">Iniciar sesión</v-btn>
      </v-form>
    </v-container>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      showPassword : false,
      loginInfo:{
        user_id: '',
        username: '',
        email: '',
        password: '',
        admin: false
      },
       emailRules: [
        v => !!v || 'Email requerido',
        v => /.+@.+\..+/.test(v) || 'Correo tiene que ser valido',
      ],
      passwordRules: [
        v => !!v || 'Password requirido',
        v => (v && v.length <= 20) || 'Contraseña tiene que ser menor que 20 caracteres',
      ]
    }
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
            this.$router.push('/mainpage');
          }
       }else{
         alert('Email/password incorrectos, intenta denuevo')
       }
    }
  },
}
</script>