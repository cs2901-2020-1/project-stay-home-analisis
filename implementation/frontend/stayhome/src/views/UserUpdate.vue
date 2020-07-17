<template>
<v-container>

    <v-container v-if="currentUser.username && currentUser.admin == false">


      <v-row justify="left">

          <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
          <v-icon >mdi-chevron-right</v-icon>
          
        <v-text class="estiloT" color="grey"> Administrar perfil </v-text> 
        
      </v-row>



      <v-spacer></v-spacer>
      <v-container>
      </v-container>
      <v-container>
        <h2 class="text-md-left" > ¿Qué desea editar?</h2>
        <v-row class="pa-3" justify="left">
          <v-col class="User">
          Usuario: <v-text class="userc"> {{currentUser.username}}</v-text>
          </v-col> 

          <v-col>
          <v-dialog v-model="dialog1" persistent max-width="290">
              <template v-slot:activator="{ on, attrs }">
                <v-btn style="margin-left: 130px" class="subheading"
                  small
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                  
                  ><v-icon center>mdi-pencil</v-icon>
                </v-btn>
                
              </template>
            
              <v-card>
                <v-card-title class="headline">Cambiar usuario</v-card-title>
                <v-card-text>
                  <v-row>
                    <v-col cols="12">
                      <v-text-field v-model="editInfo.username" label="Usuario" :rules="nameRules"/>
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
          </v-col>
        </v-row>

        <v-row class="pa-3" justify="left">
           
           <v-col class="Email">
              Correo: <v-text class="emailc">{{currentUser.email}}</v-text>
           </v-col>

          <v-col>
          <v-dialog v-model="dialog2" persistent max-width="290">
              <template v-slot:activator="{ on, attrs }">
                <v-btn style="margin-left: 130px" class="subheading"
                  small
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                  ><v-icon center>mdi-pencil</v-icon>
                </v-btn>
              </template>
              <v-card>
                <v-form v-model="valid">
                  <v-card-title class="headline">Cambiar correo</v-card-title>
                  <v-card-text>
                    <v-row>
                      <v-col cols="12">
                          <v-text-field v-model="editInfo.email" label="Correo" :rules="emailRules"/>
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
          </v-col>
        </v-row>

        <v-row class="pa-3" justify="left">
           <v-col class="Password">
              Contraseña: <v-text class="passwordc">{{currentUser.password}} </v-text>
           </v-col>

          <v-col>
          <v-dialog v-model="dialog3" persistent max-width="290">
              <template v-slot:activator="{ on, attrs }">
                <v-btn style="margin-left: 130px" class="subheading"
                  small
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                  ><v-icon center>mdi-pencil</v-icon>
                </v-btn>
              </template>
              <v-card>
                <v-card-title class="headline">Cambiar contraseña</v-card-title>
                <v-card-text>
                <v-row>
                  <v-col cols="12">
                      <v-text-field v-model="editInfo.password"
                      label="Contraseña"
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
         </v-col>
        </v-row>

        <v-row class="pa-5" justify="left" >
          <v-btn  medium  @click="userDelete"  color="error" >Eliminar cuenta</v-btn>
        </v-row>

       

    </v-container>
  </v-container>

  <v-container v-else>
  ERROR
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
        v => !!v || 'Correo requerido',
        v => /.+@.+\..+/.test(v) || 'Correo tiene que ser valido',
      ],
      nameRules: [
        v => !!v || 'Usuario requerido',
        v => (v && v.length <= 15) || 'Usuario tiene que ser menor que 15 caracteres',
      ],
      passwordRules: [
        v => !!v || 'Contraseña requerida',
        v => (v && v.length <= 20) || 'Contraseña tiene que ser menor que 20 caracteres',
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
        this.$router.push("/myplaylists")
      },
      async userDelete()
      {
        let response = confirm(`¿Estás seguro que deseas eliminar tu cuenta? ${this.currentUser.username}`);
        if(response)
        {
          let response = await this.$store.dispatch('deleteUser',this.currentUser);
          if(response.error){
            alert(response.error);
          }else{
            alert("Se ha eliminado correctamente el usuario");
            this.$router.push("/");
          }

        }
      }
    }

}
</script>
<style lang="scss" scoped>

.estiloUser{
        font-size:45px;
    }

.estilo{
        font-size: 15px;
        font-family: "Lucida Console", Courier, monospace;

    }

.estiloAdmin{
        font-size: 25px;
        
    }
    
.User{
        font-size: 18px;
        font-weight: bold;
         font-family: 'MyWebFont', Fallback, sans-serif;
        .userc {
        font-size: 20px; 
        font-weight: normal;
      }      
}

    
.Email{
        font-size: 18px;
        font-weight: bold;
        .emailc {
        font-size: 20px; 
        font-weight: normal;
      }      
    }
    
.Password{
        font-size: 18px;
        font-weight: bold;
        .passwordc {
        font-size: 20px; 
        font-weight: normal;
      }      

    }

    .estiloT{
   font-size: 25px;
 }   

</style>