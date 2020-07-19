<template>
<v-container>

    <v-container v-if="currentUser.username && currentUser.admin == false">


      <v-row justify="left">

          <router-link  to="/myplaylists"> <v-text class="estiloT" color="blue"> {{currentUser.username}} </v-text> </router-link>
          <v-icon >mdi-chevron-right</v-icon>
          
        <v-text class="estiloT" color="grey"> Administrar perfil </v-text> 
        
      </v-row>



      <v-spacer></v-spacer>

      <v-container/>
      
      <v-container>

      
      <v-container/>



    
    <v-list  class="estiloB" color=#FFC400>
      <v-list-item 
      >
    
        <v-list-item-icon>
          <v-icon small  color=#F44336> mdi-brightness-1</v-icon>
        
        </v-list-item-icon>

      
        <v-list-item-content >
          <v-list-item-title> <v-text class="estiloT"> <v-text class="User" > Usuario: </v-text> {{currentUser.username}} </v-text> </v-list-item-title>
        </v-list-item-content>

        <v-dialog v-model="dialog1" persistent max-width="290">
              <template v-slot:activator="{ on, attrs }">
                <v-btn style="margin-left: 130px" class="subheading"
                  medium
                  dark
                  
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                  
                  ><v-icon center>mdi-pencil</v-icon>
                </v-btn>
                
              </template>
            
              <v-card class="estiloB">
                <v-card-title class="headline">Cambiar usuario</v-card-title>
                <v-card-text>

                  <v-row justify="center">
                      <div class="display-4">
                        <v-avatar tile color=#01579B>
                          <v-icon x-large color=#FFFFFF>> mdi-account-outline</v-icon>
                        </v-avatar>
                      </div>
                      <v-col justify="center" md="8">
                        <v-text-field v-model="editInfo.username" 
                          label="Usuario" 
                          :rules="nameRules"
                        />
                      </v-col>
                    </v-row>


                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color=#01579B text @click="dialog1 = false">Cerrar</v-btn>
                  <v-btn color=#01579B text @click="userUpdate"  >Guardar cambios</v-btn>
                </v-card-actions>
              </v-card>
          </v-dialog>

      </v-list-item>


<v-list-item
        >
        <v-list-item-icon>
          <v-icon   small  color=#F44336> mdi-brightness-1</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title><v-text class="estiloT"> <v-text class="User" > Correo: </v-text> {{currentUser.email}} </v-text> </v-list-item-title>
        </v-list-item-content>

        <v-dialog v-model="dialog2" persistent max-width="290">
              <template v-slot:activator="{ on, attrs }">
                <v-btn style="margin-left: 130px" class="subheading"
                  medium
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                  
                  ><v-icon center>mdi-pencil</v-icon>
                </v-btn>
                
              </template>
            
              <v-card class="estiloB">
                <v-card-title class="headline">Cambiar correo</v-card-title>
                <v-card-text>
                  
                    <v-row justify="center">
                      <div class="display-4">
                        <v-avatar tile color=#01579B>
                          <v-icon x-large color=#FFFFFF>mdi-email</v-icon>
                        </v-avatar>
                      </div>
                      <v-col justify="center" md="8">
                        <v-text-field v-model="editInfo.email" 
                          label="Correo" 
                          :rules="emaildRules"
                        />
                      </v-col>
                    </v-row>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color=#01579B text @click="dialog2 = false">Cerrar</v-btn>
                  <v-btn color=#01579B text @click="userUpdate" >Guardar cambios</v-btn>
                </v-card-actions>
              </v-card>
          </v-dialog>

      </v-list-item>

<v-list-item
        >
        <v-list-item-icon>
          <v-icon  small  color=#F44336> mdi-brightness-1</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title> <v-text class="estiloT"> <v-text class="User" > Contraseña: </v-text> {{currentUser.password}} </v-text> </v-list-item-title>
        </v-list-item-content>

          
        <v-dialog v-model="dialog3" persistent max-width="290">
              <template v-slot:activator="{ on, attrs }">
                <v-btn style="margin-left: 130px" class="subheading"
                  medium
                  dark
                  v-bind="attrs"
                  v-on="on"
                  color="dark"
                  
                  ><v-icon center>mdi-pencil</v-icon>
                </v-btn>
                
              </template>
            
              <v-card class="estiloB">
                <v-card-title class="headline">Cambiar contraseña</v-card-title>
                
                <v-card-text>
                     <v-row justify="center">
                      <div class="display-4">
                        <v-avatar tile color=#01579B>
                          <v-icon x-large color=#FFFFFF>mdi-lock</v-icon>
                        </v-avatar>
                      </div>
                      <v-col justify="center" md="8">
                        <v-text-field v-model="editInfo.password" 
                          label="Contraseña" 
                          :rules="passwordRules"
                        />
                      </v-col>
                    </v-row>

                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color=#01579B text @click="dialog3 = false">Cerrar</v-btn>
                  <v-btn color=#01579B text @click="userUpdate" >Guardar cambios</v-btn>
                </v-card-actions>
              </v-card>
          </v-dialog>

      </v-list-item>

    <v-container/>


 <v-list-item>
        <v-row class="pa-5" justify="center" >
          <v-btn  large  @click="userDelete"  :loading="loading" color="dark" dark >Eliminar cuenta</v-btn>
        </v-row>
      
  </v-list-item>

    </v-list>

      
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
      loading:false,

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
        this.loading1 = true;
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
        this.loading = true;
        if(response)
        {
          let response = await this.$store.dispatch('deleteUser',this.currentUser);
          //setTimeout(() => {
          if(response.error){
            alert(response.error);
            this.loading=false;
          }else{
            alert("Se ha eliminado correctamente el usuario");
            this.loading=false;
            this.$router.push("/");
          }//},1000);

        }
         this.loading = false;
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

.estiloCard{

    background-color: #01579B;
    border-radius: 30px;

  } 
.estiloB{
    border-radius: 30px;
    background-color: #E0E0E0;
}

</style>