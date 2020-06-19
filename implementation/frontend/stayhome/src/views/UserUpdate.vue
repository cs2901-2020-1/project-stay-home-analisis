<template>
    <v-container>
      <h1>Administrar mi cuenta</h1>      
      <v-spacer></v-spacer>
      <v-form v-model="valid">
        <v-text-field v-model="editInfo.username" label="Username" :rules="nameRules"/>
        <v-text-field v-model="editInfo.email" label="Email" :rules="emailRules"/>
        <v-text-field v-model="editInfo.password" 
                      label="Password" 
                      :type="showPassword ? 'text' : 'password' "
                      :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                      :rules="passwordRules"
                      @click:append="showPassword=!showPassword"/>
        <v-btn @click="userUpdate" :disabled="!valid" >Actualizar</v-btn>
      </v-form>
    </v-container>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: 'Update',
  computed: {
    ...mapState(['currentUser'])
  },
  data() {
    return {
      showPassword : false,
      editInfo:{
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
        v => (v && v.length <= 15) || 'Username tiene que ser menor que 15 caracteres',
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
    async userUpdate(){

  /*      if(this.editInfo.password!='')
        {
          this.editInfo.username = this.currentUser.username;
          this.editInfo.email = this.currentUser.email;
        }
        else if(this.editInfo.email!=='')
        {
          this.editInfo.username = this.currentUser.username;
          this.editInfo.password = this.currentUser.password;
        }
        else
        {
          this.editInfo.password = this.currentUser.password;
          this.editInfo.email = this.currentUser.email;
        }*/

        this.editInfo.user_id = this.currentUser.user_id;
        let user = await this.$store.dispatch('updateUser', this.editInfo);
          if(user.error){
            alert(user.error)
          }else{
            alert('Se han actualizado tus datos con éxito');
          }
        this.$router.push("/mainpage")
      }
    }
  
}
</script>