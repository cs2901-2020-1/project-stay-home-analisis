package com.stayhome.demo.repositories;

import com.stayhome.demo.data.ArticlePack;
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
public interface ArticlePackRepository extends JpaRepository<ArticlePack, BigInteger> {

    @Transactional
    @Query(value = "SELECT app_article_pack.name FROM app_article_pack WHERE app_article_pack.name = :id AND app_article_pack.user_id = :user_id ", nativeQuery = true)
    String FindFavorite(@Param("id") String id, @Param("user_id") BigInteger user_id);

    @Query(value = "SELECT COUNT(app_articlesbypack.article_id) FROM app_articlesbypack WHERE app_articlesbypack.articlepack_id = :id", nativeQuery = true)
    BigInteger Contador(@Param("id") BigInteger articlepack_id);

    @Modifying
    @Query(value = "DELETE FROM app_articlesbypack WHERE app_articlesbypack.articlepack_id = ?1", nativeQuery = true)
    void deleteArticlesPorPackByArticlepack_id(BigInteger articlepack_id);

    @Modifying
    @Query(value= "UPDATE app_user SET contador_articlepack = :contador WHERE user_id = :user_id", nativeQuery = true)
    void updateUser(@Param("contador") BigInteger contador, @Param("user_id") BigInteger user_id);


    @Query(value = "SELECT COUNT(app_article_pack.user_id) FROM app_article_pack WHERE app_article_pack.name = :nombre AND app_article_pack.user_id = :id", nativeQuery = true)
    BigInteger Contador_fav(@Param("nombre") String nombre, @Param("id") BigInteger user_id);



}
