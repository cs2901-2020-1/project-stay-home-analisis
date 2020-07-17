package com.stayhome.demo.repositories;

import com.stayhome.demo.data.ArticlePack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigInteger;
import java.util.List;

@Repository
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public interface ArticlePackRepository extends JpaRepository<ArticlePack, BigInteger> {

    @Transactional
    @Query(value = "SELECT app_article_pack.name FROM app_article_pack WHERE app_article_pack.name = :id", nativeQuery = true)
    String FindFavorite(@Param("id") String id);
}
