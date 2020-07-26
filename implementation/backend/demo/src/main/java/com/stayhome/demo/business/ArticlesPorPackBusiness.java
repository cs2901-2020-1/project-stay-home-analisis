package com.stayhome.demo.business;

import com.stayhome.demo.data.ArticlesPorPack;
import com.stayhome.demo.repositories.ArticlesPorPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArticlesPorPackBusiness {

    @Autowired
    private ArticlesPorPackRepository repository;

    public List<ArticlesPorPack> findAll(){

        return new ArrayList<>(repository.findAll());
    }

    public List<ArticlesPorPack> getArticlesPorPackId(BigInteger articlepack_id) {
        return repository.findByDoubleiArticlepack(articlepack_id);
    }

    public ArticlesPorPack create(ArticlesPorPack newArticlesPorPack) {
        return repository.save(newArticlesPorPack);
    }

    public void delete(BigInteger articlepack_id){
        repository.deleteArticlesPorPackByArticlepack_id(articlepack_id);
    }


}
