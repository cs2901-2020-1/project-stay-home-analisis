package com.stayhome.demo.repositories;

import com.stayhome.demo.data.ArticlesPorPack;
import com.stayhome.demo.data.Doublei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
public interface ArticlesPorPackRepository extends JpaRepository<ArticlesPorPack, Doublei> {
    //List<ArticlesPorPack> findByDoubleiArticlepack(BigInteger articlepackid);
    @Transactional
    @Query(value = "SELECT * FROM app_articlesbypack WHERE app_articlesbypack.articlepack_id = :id", nativeQuery = true)
    List<ArticlesPorPack> findByDoubleiArticlepack(@Param("id") BigInteger id);

    @Modifying
    @Query(value = "DELETE FROM app_articlesbypack WHERE app_articlesbypack.articlepack_id = ?1", nativeQuery = true)
    void deleteArticlesPorPackByArticlepack_id(BigInteger articlepack_id);


}
