package com.stayhome.demo.business;

import com.stayhome.demo.data.ArticlePack;
import com.stayhome.demo.data.ArticlesPorPack;
import com.stayhome.demo.repositories.ArticlesPorPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticlesPorPackBusiness {

    @Autowired
    private ArticlesPorPackRepository repository;

    public List<ArticlesPorPack> findAll(){

        return new ArrayList<>(repository.findAll());
    }

    public List<ArticlesPorPack> getArticlesPorPackId(BigInteger articlepack_id) {
        return repository.findByDoubleiArticlepackid(articlepack_id);
    }

    public ArticlesPorPack create(ArticlesPorPack newArticlesPorPack) {
        return repository.save(newArticlesPorPack);
    }
}
