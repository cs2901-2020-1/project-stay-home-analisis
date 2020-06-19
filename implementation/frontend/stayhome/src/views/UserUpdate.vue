<template>
    <v-container>
      <h1>Administrar mi cuenta</h1>      
      <v-spacer></v-spacer>
      <v-form v-model="valid">
        <div>
          Username : {{currentUser.username}}
    <v-dialog v-model="dialog1" persistent max-width="290"> 
        <template v-slot:activator="{ on, attrs }">
        <v-btn  color="primary"
          dark
          v-bind="attrs"
          v-on="on">Editar</v-btn>
        </template>
        <v-card>
        <v-card-title class="headline">Cambiar username</v-card-title>
        <v-card-text> 
          <v-row>
            <v-col cols="12"> 
        <v-text-field v-model="editInfo.username" label="Username" :rules="nameRules"/>
            </v-col>
          </v-row>  
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="green darken-1" text @click="dialog1 = false">Cerrar</v-btn>
          <v-btn color="green darken-1" text @click="userUpdate">Guardar cambios</v-btn>
        </v-card-actions>
      </v-card>
      </v-dialog>
        </div>
        <div>
        Email : {{currentUser.email}}
        <v-dialog v-model="dialog2" persistent max-width="290"> 
        <template v-slot:activator="{ on, attrs }">
        <v-btn  color="primary"
          dark
          v-bind="attrs"
          v-on="on">Editar</v-btn>
        </template>
        <v-card>
          <v-form v-model="valid">
        <v-card-title class="headline">Cambiar email</v-card-title>
        <v-card-text>
          <v-row>
            <v-col cols="12"> 
                 <v-text-field v-model="editInfo.email" label="Email" :rules="emailRules"/>
            </v-col>
          </v-row>             
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="green darken-1" text @click="dialog2 = false">Cerrar</v-btn>
          <v-btn color="green darken-1" text @click="userUpdate" :disabled="!valid">Guardar cambios</v-btn>
        </v-card-actions>
          </v-form>
      </v-card>
      </v-dialog>
        </div>
        <div> 
        Contraseña : {{currentUser.password}} 
        <v-dialog v-model="dialog3" persistent max-width="290"> 
        <template v-slot:activator="{ on, attrs }">
        <v-btn  color="primary"
          dark
          v-bind="attrs"
          v-on="on">Editar</v-btn>
        </template>
        <v-card>
        <v-card-title class="headline">Cambiar contraseña</v-card-title>
        <v-card-text> 
          <v-row>
            <v-col cols="12"> 
                      <v-text-field v-model="editInfo.password" 
                      label="Password" 
                      :type="showPassword ? 'text' : 'password' "
                      :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                      :rules="passwordRules"
                      @click:append="showPassword=!showPassword"/>
            </v-col>
          </v-row>  
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="green darken-1" text @click="dialog3 = false">Cerrar</v-btn>
          <v-btn color="green darken-1" text @click="userUpdate">Guardar cambios</v-btn>
        </v-card-actions>
      </v-card>
      </v-dialog>
        </div>
        <v-btn @click="userDelete">Eliminar cuenta</v-btn>
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
      ],
      dialog1: false,
      dialog2: false,
      dialog3: false
    }
  },
  mounted(){
    this.$store.dispatch("loadAll")
  },
  methods: {
    async userUpdate(){

        if(this.editInfo.password!='')
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
        }

        this.editInfo.user_id = this.currentUser.user_id;
        let user = await this.$store.dispatch('updateUser', this.editInfo);
          if(user.error){
            alert(user.error)
          }else{
            alert('Se han actualizado tus datos con éxito');
          }
        this.$router.push("/mainpage")
      },
      userDelete()
      {
        let response = confirm(`¿Estás seguro que deseas eliminar tu cuenta? ${this.currentUser.username}`);
        if(response)
        {
          this.$store.dispatch('deleteUser',this.currentUser);
          console.log(this.currentUser);
          this.$router.push("/");
        }
      }
    }
  
}
</script>