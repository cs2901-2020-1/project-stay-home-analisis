package com.stayhome.demo.repositories;

import com.stayhome.demo.data.Dbi;
import com.stayhome.demo.data.LikesPorArticle;
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
public interface LikesPorArticleRepository extends JpaRepository<LikesPorArticle, Dbi> {


    @Query(value="SELECT * FROM app_likesbyarticle WHERE articleid = :asid AND userid = :usid",nativeQuery = true)
    LikesPorArticle findbykey(@Param("asid") BigInteger asid, @Param("usid")BigInteger usid);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM app_likesbyarticle WHERE articleid = :asid AND userid= :usid", nativeQuery = true)
    void deletebykey(@Param("asid")BigInteger asid, @Param("usid")BigInteger usid);


}
