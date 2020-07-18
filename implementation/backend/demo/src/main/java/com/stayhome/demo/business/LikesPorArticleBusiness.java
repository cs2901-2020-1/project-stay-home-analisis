package com.stayhome.demo.business;

import com.stayhome.demo.data.ArticlePack;
import com.stayhome.demo.data.ArticlesPorPack;
import com.stayhome.demo.data.LikesPorArticle;
import com.stayhome.demo.repositories.LikesPorArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class LikesPorArticleBusiness {

    @Autowired
    private LikesPorArticleRepository repository;

    public List<LikesPorArticle> findAll(){

        return new ArrayList<>(repository.findAll());
    }


    public LikesPorArticle create(LikesPorArticle newLike)
    {
        LikesPorArticle react = repository.findbykey(newLike.getDbi().getArticleid(),newLike.getDbi().getUserid());
        if(react!=null) {
            if (newLike.getLik() == react.getLik()) {
                repository.deletebykey(react.getDbi().getArticleid(), react.getDbi().getUserid());
                return newLike;
            }
        }

            return repository.save(newLike);

    }

}
