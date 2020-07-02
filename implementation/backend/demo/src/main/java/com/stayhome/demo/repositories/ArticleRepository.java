package com.stayhome.demo.repositories;

import com.stayhome.demo.data.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ArticleRepository extends JpaRepository<Article, BigInteger> {

}