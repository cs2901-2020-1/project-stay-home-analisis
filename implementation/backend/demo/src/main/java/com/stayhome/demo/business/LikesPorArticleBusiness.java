package com.stayhome.demo.business;

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

    public List<LikesPorArticle> findLikesById(BigInteger id)
    {
        return new ArrayList<>(repository.getLikesporArticle(id));
    }

    public List<LikesPorArticle> findDislikesById(BigInteger id)
    {
        return new ArrayList<>(repository.getDislikesporArticle(id));
    }

    public LikesPorArticle create(LikesPorArticle newLike) {
        return repository.save(newLike);
    }

}
