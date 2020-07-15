package com.stayhome.demo.controller;

import com.stayhome.demo.business.ArticlePackBusiness;
import com.stayhome.demo.data.Article;
import com.stayhome.demo.data.ArticlePack;
import com.stayhome.demo.repositories.ArticlePackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticlePackController {

    @Autowired
    private ArticlePackBusiness business;

    @GetMapping("/articlepacks")
    public List<ArticlePack> read()
    {
        return business.findAll();
    }

    @PostMapping("/articlepacks")
    public ArticlePack create(@RequestBody ArticlePack articlepack)
    {
        return business.create(articlepack);
    }
}
