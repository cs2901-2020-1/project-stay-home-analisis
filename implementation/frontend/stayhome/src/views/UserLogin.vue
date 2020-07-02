<template>
    <v-container>
      <h1>LOGIN</h1>
      <v-spacer></v-spacer>
      <v-form v-model="valid">
        <v-text-field v-model="loginInfo.email" label="Email" :rules="emailRules"/>
        <v-text-field v-model="loginInfo.password" 
                      label="Password" 
                      :type="showPassword ? 'text' : 'password' "
                      :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                      :rules="passwordRules"
                      @click:append="showPassword=!showPassword"/>
        <v-btn @click="loginUser" :disabled="!valid">Login</v-btn>
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
        v => /.+@.+\..+/.test(v) || 'Email tiene que ser valido',
      ],
      passwordRules: [
        v => !!v || 'Password requirido',
        v => (v && v.length <= 20) || 'Password tiene que ser menor que 20 caracteres',
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
      let validator = await this.$store.dispatch("loadAll");
      console.log(validator.data)
       for(var i = 0; i < validator.data.length; i++){
         if(this.loginInfo.email === validator.data[i].email){
           this.loginInfo.user_id = validator.data[i].user_id;
           this.loginInfo.username = validator.data[i].username;
           password = validator.data[i].password;
         }
       }
       if(this.loginInfo.password == password){
          /* Fin Autenticar */
          let user = await this.$store.dispatch('loginUser',this.loginInfo);
          console.log(user);
          if(user.error){
            alert(user.error)
          }else{
            alert('Gracias por loguearte, ' + user.username);
            this.$router.push('/mainpage');
          }
       }else{
         alert('Hubo un error al eliminar el usuario, intenta denuevo')
       }
    }
  },
}
</script>