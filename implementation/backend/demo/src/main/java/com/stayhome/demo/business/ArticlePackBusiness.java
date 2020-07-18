package com.stayhome.demo.business;

import com.stayhome.demo.controller.UserController;
import com.stayhome.demo.data.ArticlePack;
import com.stayhome.demo.repositories.ArticlePackRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArticlePackBusiness {

    @Autowired
    private ArticlePackRepository repository;

    public List<ArticlePack> findAll(){

        List<ArticlePack> items = new ArrayList<>();

        if(repository.findAll().size() == 0){
            ArticlePack Favorite = new ArticlePack();
            Favorite.setName("Favoritos de " + UserController.Current.getUsername());
            Favorite.setDescripcion("Coleccion de Favoritos de " + UserController.Current.getUsername());
            Favorite.setUser(UserController.Current);
            repository.save(Favorite);
        }
        for (ArticlePack item : repository.findAll()){
            BigInteger contador = repository.Contador(item.getArticlepack_id());
            item.setContador(contador);
            items.add(item);
        }
        return items;
    }

    public ArticlePack create(ArticlePack newArticlePack) {
        return repository.save(newArticlePack);
    }

    public ArticlePack update(@NotNull ArticlePack item){
        ArticlePack a = repository.findById(item.getArticlepack_id()).get();
        if(a != null){
            return repository.save(item);
        }
        return null;
    }

    public void delete(BigInteger articlepack_id){
        repository.deleteArticlesPorPackByArticlepack_id(articlepack_id);
        repository.deleteById(articlepack_id);
    }

    public String Fav(String name, BigInteger id){
        return repository.FindFavorite(name,id);
    }



}
