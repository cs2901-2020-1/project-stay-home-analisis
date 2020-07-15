package com.stayhome.demo.repositories;

import com.stayhome.demo.data.ArticlesPorPack;
import com.stayhome.demo.data.Doublei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ArticlesPorPackRepository extends JpaRepository<ArticlesPorPack, Doublei> {
    List<ArticlesPorPack> findByDoubleiArticlepackid(BigInteger articlepackid);

}
