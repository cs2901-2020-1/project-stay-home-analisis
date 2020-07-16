import Vue from 'vue'
import Vuex from 'vuex'
import Api from "@/services/api";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    users: [],
    currentUser: {},
    articles: [],
    articlepacks: [],
    articles_por_tupac: []

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
      window.localStorage.currentUser = JSON.stringify({});
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
    },
    UPDATE_ARTICLE(state,article){
      state.articles.find(u => u.article_id == article.article_id)
      //a = article;
    },
    DELETE_ARTICLE(state,aid)
    {
      let a = state.articles.filter(a => a.article_id != aid);
      this.state.articles = a;
      console.log(this.state.articles);
    },

    SET_ARTICLEPACKS(state,articlepacks)
    {
      state.articlepacks = articlepacks;
    },

    ADD_ARTICLEPACK(state,articlepack)
    {
      let adartpack = state.articlepacks.concat(articlepack);
      state.articlepacks = adartpack;
    },
    SET_ARTICLES_POR_TUPAC(state,article_by_pack){

      state.articles_por_tupac = article_by_pack;
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
        return {error: "No se pudo actualizar, intenta denuevo"};
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
        return {error: "Email/password incorrectos, intenta denuevo"}
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
        return {error: "Hubo un error al registrar, intenta denuevo"}
      }
    },
    async deleteUser({commit},deleteInfo){

      try{
    
        let delete_article = await Api().delete(`/articlesUserId/${deleteInfo.user_id}`);
        console.log(delete_article.data);
        if(delete_article.status==200 || delete_article.status==204)
        {
          commit('DELETE_ARTICLE',delete_article.article_id);
        
        }

        let response = await Api().delete(`/users/${deleteInfo.user_id}`);
        console.log(response.data);
        if(response.status==200 || response.status==204)
        {
          commit('DELETE_USER',deleteInfo.user_id);
          commit('LOGOUT_USER');
        }
        return response;
      }
      catch{
        return {error: "Hubo un error al eliminar el usuario, intenta denuevo"}
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
       try{
         console.log(article);
       let response = await Api().post('/articles',article);
       let art = response.data;
       commit('ADD_ARTICLE',art);
       return art;
      }
       catch
       {
        return {error: "Hubo un error al subir el articulo"}
       }
      },
      async addFile({commit},capsule){
        try{
        console.log(capsule);
        const formData = new FormData()
        formData.append('file', capsule.file)

        let response = await Api().post(`/uploadFile/${capsule.article_id}`,formData);
        let f = response.data;
        commit('ADD_ARTICLE',f);
        console.log(response.data);
        return response;
        }
        catch
        {
          return {error: "Hubo un error al subir el articulo"}
        }

      },
      async updateArticle({commit},articleInfo){
        try{
          let response = await Api().put(`/articles/${articleInfo.article_id}`,articleInfo);
          console.log(response);
          let updated_article = response.data;
          commit('UPDATE_ARTICLE',updated_article);
          return updated_article;
        }
        catch
        {
          return {error: "Error al validar"};
        }
      },
      async deleteArticle({commit},article){
        try{
          let response = await Api().delete(`/articles/${article.article_id}`);
          if(response.status==200 || response.status==204)
          {
            commit('DELETE_ARTICLE',article.article_id);
          }
        }
        catch{
          return {error: "Hubo un error al eliminar el articulo, intenta denuevo"}
        }
      },
      async deleteArticle_by_user_id({commit},user){
        try{
          let response = await Api().delete(`/articles_by_user/${user.user_id}`);
          if(response.status==200 || response.status==204)
          {
            commit('DELETE_ARTICLE_BY_USER_ID',user.user_id);
          }
        }
        catch{
          return {error: "Hubo un error al eliminar el articulo, intenta denuevo"}
        }
      },


      async loadAllArticlepacks({commit}){
 
        let response = await Api().get('/articlepacks');
        commit('SET_ARTICLEPACKS',response.data);
        console.log(response.data);
        return response
       },

       async addArticlepack({commit},articlepack)
     {
       try{
       let response = await Api().post('/articlepacks',articlepack);
       let artpack = response.data;
       console.log(artpack);
       commit('ADD_ARTICLEPACK',artpack);
       return artpack;
      }
       catch
       {
        return {error: "Hubo un error al crear el paquete de artículos"}
       }
      },

      async loadAllArticles_tupac({commit},info){
        try{
        console.log(info);
        let response = await Api().get(`/articlesporpack/${info}`);
        commit('SET_ARTICLES_POR_TUPAC',response.data);
        console.log(response.data);
        return response
        }catch{
          return {error: "Hubo un error al agregar el articulo"}
        }
       },

  
  },
  modules: {
  }
});
