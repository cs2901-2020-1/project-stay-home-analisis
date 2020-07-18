package com.stayhome.demo.repositories;

import com.stayhome.demo.data.Dbi;
import com.stayhome.demo.data.LikesPorArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public interface LikesPorArticleRepository extends JpaRepository<LikesPorArticle, Dbi> {

    @Transactional
    @Query(value = "SELECT * FROM app_likesbyarticle WHERE app_likesbyarticle.articleid = :id AND app_likesbyarticle.lik = TRUE", nativeQuery = true)
    List<LikesPorArticle> getLikesporArticle(@Param("id") BigInteger id);

    @Query(value = "SELECT * FROM app_likesbyarticle WHERE app_likesbyarticle.articleid = :id AND app_likesbyarticle.lik = FALSE", nativeQuery = true)
    List<LikesPorArticle> getDislikesporArticle(@Param("id") BigInteger id);


}
