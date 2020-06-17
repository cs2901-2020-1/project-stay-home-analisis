import Vue from 'vue'
import Vuex from 'vuex'
import Api from "@/services/api";


Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    users: [],
    currentUser: {}
  },
  mutations: {
    SET_USERS(state,users){
      state.users = users;
    },
    LOGOUT_USER(state){
      state.currentUser = {};
      window.localStorage.currentUser = JSON.stringify({});
    },
    SET_CURRENT_USER(state,user){
      state.currentUser = user;
      window.localStorage.currentUser = JSON.stringify(user);
    }
  },
  actions: {
    async loadAll({commit}){
      let response = await Api().get('/users');
      commit('SET_USERS', response.data);
      console.log(response.data);
      
      let user = JSON.parse(window.localStorage.currentUser);
      commit('SET_CURRENT_USER', user);

      return response;

    },
    logoutUser({commit}){
      commit('LOGOUT_USER');
    },

    async loginUser({commit},loginInfo){
      try{
        let response = await Api().post('/users',loginInfo);
        console.log(response);
        let user = response.data;
        commit('SET_CURRENT_USER', user);
        return user;
      }catch{
        return {error: "Email/password combination was incorrect. Please try again"}
      }
    
    },
    async registerUser({commit},registrationInfo){
      try{
        let response = await Api().post('/users',registrationInfo);
        console.log(response);
        let user = response.data;
        commit('SET_CURRENT_USER', user);
        return user;
      }catch{
        return {error: "There was an error, please try again"}
      }
    }
  },
  modules: {
  }
});
