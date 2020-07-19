package com.stayhome.demo.repositories;

import com.stayhome.demo.data.Article;
import com.stayhome.demo.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
public interface UserRepository extends JpaRepository<User, BigInteger> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM app_article WHERE app_article.user_id = ?1", nativeQuery = true)
    void delete_article_by_user_id(BigInteger user_id);

    @Modifying
    @Query(value = "DELETE FROM app_likesbyarticle WHERE app_likesbyarticle.userid = :userid", nativeQuery = true)
    void deleteLikes_by_user(@Param("userid")BigInteger userid);

    @Query(value = "SELECT app_article.article_id FROM app_article WHERE app_article.user_id = :userid", nativeQuery = true)
    List<BigInteger> allArticles_by_user(@Param("userid")BigInteger userid);

    @Modifying
    @Query(value = "DELETE FROM app_articlesbypack WHERE app_articlesbypack.article_id = ?1", nativeQuery = true)
    void deleteArticlebypack_by_user(BigInteger article_id);

    @Modifying
    @Query(value = "DELETE FROM app_article_pack WHERE app_article_pack.user_id = ?1", nativeQuery = true)
    void deleteArticlepack_by_user(BigInteger user_id);
}