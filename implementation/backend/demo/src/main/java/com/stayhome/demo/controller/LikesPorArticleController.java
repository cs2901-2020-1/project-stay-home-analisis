package com.stayhome.demo.controller;

import com.stayhome.demo.business.LikesPorArticleBusiness;
import com.stayhome.demo.data.ArticlesPorPack;
import com.stayhome.demo.data.LikesPorArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class LikesPorArticleController {

    @Autowired
    private LikesPorArticleBusiness business;

    @GetMapping("/likesporarticles")
    public List<LikesPorArticle> read()
    {
        return business.findAll();
    }


    @PostMapping("/likesporarticles")
    public LikesPorArticle create(@RequestBody LikesPorArticle like)
    {
        return business.create(like);
    }

}