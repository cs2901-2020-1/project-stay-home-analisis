package com.stayhome.demo.controller;

import com.stayhome.demo.business.ArticlePackBusiness;
import com.stayhome.demo.data.ArticlePack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
