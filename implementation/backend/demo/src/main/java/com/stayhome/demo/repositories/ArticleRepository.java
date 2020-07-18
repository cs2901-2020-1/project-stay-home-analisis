package com.stayhome.demo.repositories;

import com.stayhome.demo.data.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import java.math.BigInteger;

@Repository
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public interface ArticleRepository extends JpaRepository<Article, BigInteger> {

    @Transactional
    @Query(value = "SELECT COUNT(app_likesbyarticle.userid) FROM app_likesbyarticle WHERE app_likesbyarticle.articleid = :id AND app_likesbyarticle.lik=TRUE", nativeQuery = true)
    BigInteger CountLikes(@Param("id") BigInteger id);

    @Query(value = "SELECT COUNT(app_likesbyarticle.userid) FROM app_likesbyarticle WHERE app_likesbyarticle.articleid = :id AND app_likesbyarticle.lik=FALSE", nativeQuery = true)
    BigInteger CountDislikes(@Param("id") BigInteger id);

    @Modifying
    @Query(value = "DELETE FROM app_articlesbypack WHERE app_articlesbypack.article_id = ?1", nativeQuery = true)
    void delete_article_from_article_tupac(BigInteger article_id);

}