package com.stayhome.demo.repositories;

import com.stayhome.demo.data.Dbi;
import com.stayhome.demo.data.LikesPorArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

public interface LikesPorArticleRepository extends JpaRepository<LikesPorArticle, Dbi> {



}
