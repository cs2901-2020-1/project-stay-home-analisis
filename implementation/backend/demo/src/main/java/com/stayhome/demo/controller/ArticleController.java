package com.stayhome.demo.controller;

import com.stayhome.demo.data.Article;
import com.stayhome.demo.business.ArticleBusiness;
import com.stayhome.demo.data.User;
import com.stayhome.demo.payload.UploadArticleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleBusiness business;

    @PostMapping("/uploadFile/{id}")
    public UploadArticleResponse uploadFile(@RequestParam("file") MultipartFile file
    ,@PathVariable BigInteger id) {
        Article article = business.storeFile(file,id);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(article.getArticle_id().toString())
                .toUriString();

        return new UploadArticleResponse(article.getTitle(), fileDownloadUri,
                article.getTipo());
    }

    @PostMapping("/articles")
    public Article create (@RequestBody Article item){
        return business.create(item);
    }

  /*  @GetMapping("/downloadFile/{article_id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable BigInteger article_id) {
        // Load file from database
        Article article = business.getArticle(article_id);
        article.

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(article.getTipo()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + article.getTitle() + "\"")
                .body(new ByteArrayResource(article.getData()));
    }*/

}