package com.stayhome.demo.controller;

import com.stayhome.demo.business.ArticlesPorPackBusiness;
import com.stayhome.demo.data.ArticlesPorPack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ArticlesPorPackController {

    @Autowired
    private ArticlesPorPackBusiness business;

    @GetMapping("/articlesporpack")
    public List<ArticlesPorPack> read()
    {
        return business.findAll();
    }

    @GetMapping("articlesporpack/{id}")
    public List<ArticlesPorPack> readbyid(@PathVariable("id")BigInteger articlepack_id)
    {
        return business.getArticlesPorPackId(articlepack_id);
    }

    @PostMapping("articlesporpack")
    public ArticlesPorPack create(@RequestBody ArticlesPorPack articleporpack)
    {
        return business.create(articleporpack);
    }

}
