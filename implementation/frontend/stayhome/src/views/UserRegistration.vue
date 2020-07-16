<template>
    <v-container>
      <h1>REGISTER</h1>
      <v-spacer></v-spacer>
      <v-form v-model="valid">
        <v-text-field v-model="registerInfo.username" label="Username" :rules="nameRules"/>
        <v-text-field v-model="registerInfo.email" label="Email" :rules="emailRules"/>
        <v-text-field v-model="registerInfo.password" 
                      label="Password" 
                      :type="showPassword ? 'text' : 'password' "
                      :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                      :rules="passwordRules"
                      @click:append="showPassword=!showPassword"/>
        <v-btn @click="registerUser" :disabled="!valid" >Register</v-btn>
      </v-form>
    </v-container>
</template>

<script>
export default {
  name: 'Register',
  data() {
    return {
      showPassword : false,
      registerInfo:{
        user_id: '',
        username: '',
        email: '',
        password: '',
        admin: false,
      },
       emailRules: [
        v => !!v || 'Email requerido',
        v => /.+@.+\..+/.test(v) || 'Email tiene que ser valido',
      ],
      nameRules: [
        v => !!v || 'Username requirido',
        v => (v && v.length <= 15) || 'Username tiene que ser menor que 10 caracteres',
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
    async registerUser(){
   
      if(this.registerInfo.username != '' && this.registerInfo.email != '' && this.registerInfo.password != '' ){    
          let user = await this.$store.dispatch('registerUser',this.registerInfo);
          console.log(user);
          if(user.error){
            alert(user.error)
          }else{
            alert('Gracias por registrate en StayHome, ' + user.username);
            if(this.loginInfo.admin == false){
                this.$router.push('/myplaylists');
            }else{
                this.$router.push('/buscar');
            }
          }
      }else{
         alert('Hubo un error, intenta de nuevo')
      }
    }
  },
}
</script>