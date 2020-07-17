package com.stayhome.demo.controller;

import com.stayhome.demo.data.Article;
import com.stayhome.demo.business.ArticleBusiness;
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

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleBusiness business;

    @PostMapping("/uploadFile/{id}")
    public UploadArticleResponse uploadFile(
            @RequestParam("file") MultipartFile file,
            @PathVariable BigInteger id
    ){
        Article article = business.storeFile(file,id);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(article.getUser() +"/"+ article.getTitle())
                .toUriString();

        return new UploadArticleResponse(article.getTitle(), fileDownloadUri,
                article.getTipo());
    }

    @PostMapping("/articles")
    public Article create (@RequestBody Article item){
        return business.create(item);
    }


    @GetMapping( "/articles" )
    public List<Article> read (){
        return business.findAll();
    }

    @GetMapping( "/articles/{article_id}" )
    public Article read (@PathVariable BigInteger article_id){
        return business.getArticle(article_id);
    }

    @PutMapping("/articles/{article_id}")
    public Article update(
            @PathVariable BigInteger article_id,
            @RequestBody Article item
    ){
        return business.update(item);
    }

    @DeleteMapping("/articles/{article_id}")
    public void delete(@PathVariable BigInteger article_id){
        business.delete(article_id);
    }


    @DeleteMapping("/articlesUserId/{user_id}")
    public void delete_by_User_id(@PathVariable BigInteger user_id){business.delete_by_User_id(user_id);}


    @GetMapping("/downloadFile/{article_id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable BigInteger article_id) {
        Article article = business.getArticle(article_id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(article.getTipo()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + article.getNombre() + "\"")
                .body(new ByteArrayResource(article.getData()));
    }

}
