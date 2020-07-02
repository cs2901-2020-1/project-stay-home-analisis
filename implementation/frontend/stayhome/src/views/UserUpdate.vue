<template>
<v-container>
    <v-container v-if="currentUser.username">
      <h1>{{currentUser.username}} >> Administrar Perfil </h1>
      <v-spacer></v-spacer>
      <v-container>
        <h2 class="text-md-center" > ¿Qué desea editar?</h2>

        <v-row class="pa-3" justify="center">
          Username: {{currentUser.username}}
          <v-dialog v-model="dialog1" persistent max-width="290"> 
              <template v-slot:activator="{ on, attrs }">
                <v-btn style="margin-left: 40px" class="subheading"
                  small 
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                  ><v-icon left>mdi-pencil</v-icon>Editar
                </v-btn>
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
        </v-row>
      
        <v-row class="pa-3" justify="center">
          Email: {{currentUser.email}}
          <v-dialog v-model="dialog2" persistent max-width="290"> 
              <template v-slot:activator="{ on, attrs }">
                <v-btn style="margin-left: 40px" class="subheading"
                  small  
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                  ><v-icon left>mdi-pencil</v-icon>Editar
                </v-btn>
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
        </v-row>
      
        <v-row class="pa-3" justify="center">
          Password: {{currentUser.password}}
          <v-dialog v-model="dialog3" persistent max-width="290"> 
              <template v-slot:activator="{ on, attrs }">
                <v-btn style="margin-left: 40px" class="subheading"
                  small  
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                  ><v-icon left>mdi-pencil</v-icon>Editar
                </v-btn>
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

        </v-row>
    
        <v-row class="pa-5" justify="center" >
          <v-btn  small  @click="userDelete"  color="error" >Eliminar cuenta</v-btn>
        </v-row>

        <v-row  class="pa-9" align="center" justify="center">
          <v-img src="../../public/img/edit2.png"
            max-width="400"
            max-height="400"
            justify="center"
          ></v-img>
        </v-row>

    </v-container>
  </v-container>

  <v-container v-else>
  Por favor Logueate
  </v-container>
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
        password: '',
        admin: false
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
