package com.stayhome.demo.repositories;

import com.stayhome.demo.data.ArticlePack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ArticlePackRepository extends JpaRepository<ArticlePack, BigInteger> {
}
