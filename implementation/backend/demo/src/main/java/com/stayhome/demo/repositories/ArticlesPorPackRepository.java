package com.stayhome.demo.repositories;

import com.stayhome.demo.data.ArticlePack;
import com.stayhome.demo.data.ArticlesPorPack;
import com.stayhome.demo.data.Doublei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface ArticlesPorPackRepository extends JpaRepository<ArticlesPorPack, Doublei> {
    @Transactional
    @Query(value = "SELECT * FROM app_articlesbypack WHERE app_articlesbypack.articlepack_id = :id", nativeQuery = true)
    List<ArticlesPorPack> findByDoubleiArticlepack(@Param("id") BigInteger id);

}
