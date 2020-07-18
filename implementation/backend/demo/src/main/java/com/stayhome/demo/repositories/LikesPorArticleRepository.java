package com.stayhome.demo.repositories;

import com.stayhome.demo.data.Dbi;
import com.stayhome.demo.data.LikesPorArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public interface LikesPorArticleRepository extends JpaRepository<LikesPorArticle, Dbi> {



}
