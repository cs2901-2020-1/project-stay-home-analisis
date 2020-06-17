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
        password: ''
      },
       emailRules: [
        v => !!v || 'Email requerido',
        v => /.+@.+\..+/.test(v) || 'Email tiene que ser valido',
      ],
      nameRules: [
        v => !!v || 'Username requirido',
        v => (v && v.length <= 10) || 'Username tiene que ser menor que 10 caracteres',
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
      /* Autenticar */
      let validator = await this.$store.dispatch("loadAll");
      console.log(validator.data)
       for(var i = 0; i < validator.data.length; i++){
         if(this.registerInfo.email !== validator.data[i].email && this.registerInfo.username !== validator.data[i].username){
           this.registerInfo.user_id = validator.data[validator.data.length-1].user_id + 1;
           console.log(this.registerInfo.user_id);
         }
       }
       /* Fin Autenticar */
      if(this.registerInfo.username != '' && this.registerInfo.email != '' && this.registerInfo.password != ''){
          let user = await this.$store.dispatch('registerUser',this.registerInfo);
          console.log(user);
          if(user.error){
            alert(user.error)
          }else{
            alert('Thank you for register in StayHome, ' + user.username);
            this.$router.push('/mainpage');
          }
      }else{
         alert('There was an error, please try again')
      }
    }
  },
}
</script>