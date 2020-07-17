package com.stayhome.demo.repositories;

import com.stayhome.demo.data.ArticlesPorPack;
import com.stayhome.demo.data.Dbi;
import com.stayhome.demo.data.LikesPorArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

public interface LikesPorArticleRepository extends JpaRepository<LikesPorArticle, Dbi> {

    @Transactional
    @Query(value = "SELECT * FROM app_likesbyarticle WHERE app_likesbyarticle.articleid = :id AND app_likesbyarticle.lik = TRUE", nativeQuery = true)
    List<LikesPorArticle> getLikesporArticle(@Param("id") BigInteger id);

    @Query(value = "SELECT * FROM app_likesbyarticle WHERE app_likesbyarticle.articleid = :id AND app_likesbyarticle.lik = FALSE", nativeQuery = true)
    List<LikesPorArticle> getDislikesporArticle(@Param("id") BigInteger id);


}
