package com.stayhome.demo.controller;

import com.stayhome.demo.business.ArticlePackBusiness;
import com.stayhome.demo.data.ArticlePack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ArticlePackController {

    @Autowired
    private ArticlePackBusiness business;

    @GetMapping("/articlepacks")
    public List<ArticlePack> read() {
/*
        if(business.Fav("Favoritos de " + UserController.Current.getUsername(),UserController.Current.getUser_id() ) == null){

               ArticlePack Favorite = new ArticlePack();
               Favorite.setName("Favoritos de " + UserController.Current.getUsername());
               Favorite.setDescripcion("Coleccion de Favoritos de " + UserController.Current.getUsername());
               Favorite.setUser(UserController.Current);
               business.create(Favorite);

        }

 */
        return business.findAll();
    }

    @PostMapping("/articlepacks")
    public ArticlePack create(@RequestBody ArticlePack articlepack)
    {
        return business.create(articlepack);
    }

    @PutMapping("/articlepacks/{id}")
    public ArticlePack update(
            @PathVariable BigInteger id,
            @RequestBody ArticlePack item
    ){
        return business.update(item);
    }

    @DeleteMapping("/articlepacks/{id}")
    public void delete(@PathVariable BigInteger id){
        business.delete(id);
    }

}
