import Vue from 'vue'
import Vuex from 'vuex'
import Api from "@/services/api";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    users: [],
    currentUser: {},
    articles: []
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
    },
    UPDATE_USER(state,user){
      let u = state.users.find(u => u.user_id == user.user_id)
      u = user;
      window.localStorage.currentUser = JSON.stringify(u);
    },
    DELETE_USER(state,uid)
    {
      let a = state.users.filter(a => a.user_id != uid);
      this.state.users = a
      console.log(this.state.users);
    },
    SET_ARTICLES(state,articles)
    {
      state.articles = articles;
    },
    ADD_ARTICLE(state,article)
    {
      let articles = state.articles.concat(article);
      state.articles = articles;
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

    async updateUser({commit},editInfo)
    {
      try{
        let response = await Api().put(`/users/${editInfo.user_id}`,editInfo);
        console.log(response);
        let updated_user = response.data;
        commit('UPDATE_USER',updated_user);
        commit('SET_CURRENT_USER',updated_user);
        return updated_user;
      }
      catch
      {
        return {error: "Update failed. Please try again"};
      }
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
    },
    async deleteUser({commit},deleteInfo){
      try{
        let response = await Api().delete(`/users/${deleteInfo.user_id}`);
        if(response.status==200 || response.status==204)
        {
          commit('DELETE_USER',deleteInfo.user_id);
          commit('LOGOUT_USER');
        }     
      }
      catch{
        return {error: "There was an error, please try again"}
      }
    },
    async loadAllArticles({commit}){
      let response = await Api().get('/articles');
      commit('SET_ARTICLES',response.data);
      console.log(response.data);
      return response
     },
     async addArticle({commit},article)
     {

       let response = await Api().post('/articles',article);
       let art = response.data;
       commit('ADD_ARTICLE',art);
       return art;
     },

     async addFile({commit},capsule){
      console.log(capsule);
      const formData = new FormData()
      formData.append('file', capsule.file)
     
      let response = await Api().post(`/uploadFile/${capsule.article_id}`,formData);
      let f = response.data;
      commit('ADD_ARTICLE',f);
      console.log(response.data);
      
      return response;

    },
  },
  modules: {
  }
});