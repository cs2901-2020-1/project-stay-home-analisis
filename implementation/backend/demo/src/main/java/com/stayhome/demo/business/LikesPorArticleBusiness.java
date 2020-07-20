package com.stayhome.demo.business;

import com.stayhome.demo.data.LikesPorArticle;
import com.stayhome.demo.repositories.LikesPorArticleRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikesPorArticleBusiness {

    @Autowired
    private LikesPorArticleRepository repository;

    public List<LikesPorArticle> findAll(){

        return new ArrayList<>(repository.findAll());
    }

    public LikesPorArticle create(@NotNull LikesPorArticle newLike)
    {
        LikesPorArticle react = repository.findbykey(newLike.getDbi().getArticleid().getArticle_id(),newLike.getDbi().getUserid().getUser_id());
        if(react!=null) {
            if (newLike.getLik() == react.getLik()) {
                repository.deletebykey(react.getDbi().getArticleid().getArticle_id(), react.getDbi().getUserid().getUser_id());
                return newLike;
            }
        }
        return repository.save(newLike);

    }

}
