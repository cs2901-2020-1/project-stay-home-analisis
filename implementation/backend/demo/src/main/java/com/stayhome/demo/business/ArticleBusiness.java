package com.stayhome.demo.business;


import com.stayhome.demo.controller.UserController;
import com.stayhome.demo.exceptions.ArticleException;
import com.stayhome.demo.exceptions.ArticleNotFoundException;
import com.stayhome.demo.data.Article;
import com.stayhome.demo.repositories.ArticleRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigInteger;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;

@Service
@Transactional
public class ArticleBusiness {

    @Autowired
    private ArticleRepository repository;

    private File f = new File("src/main/resources/Files/");
    private String upload_folder = f.getAbsolutePath();

    public Article storeFile(MultipartFile file, BigInteger id) {
        try {
            Article article = repository.findById(id).get();
            String titulo = article.getTitle();
            String tipo = file.getContentType();
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(article.getArticle_id() +"/")
                    .toUriString();
            article.setTitle(titulo);
            article.setTipo(tipo);
            article.setLink(fileDownloadUri);
            article.setData(file.getBytes());
            article.setNombre(file.getOriginalFilename());
            Path path = Paths.get(upload_folder + "/"+ article.getNombre());
            Files.write(path,file.getBytes());
            return repository.save(article);
        } catch (Exception ex) {
            throw new ArticleException(ex.getMessage(), ex);
        }
    }

    public Article create(Article newArticle) {
        return repository.save(newArticle);
    }

    public List<Article> findAll(){

        List<Article> items = new ArrayList<>();

        for(Article i : repository.findAll())
        {
            BigInteger contadorLikes = repository.CountLikes(i.getArticle_id());

            BigInteger contadorDislikes = repository.CountDislikes(i.getArticle_id());

            i.setCountlikes(contadorLikes);
            i.setCountdislikes(contadorDislikes);
            items.add(i);
        }
        return items;
    }

    public Article getArticle(BigInteger article_id) {
        return repository.findById(article_id)
                .orElseThrow(() -> new ArticleNotFoundException("File not found with id " + article_id));
    }
    public Article update(@NotNull Article item){
        Article a = repository.findById(item.getArticle_id()).get();
        if(a!=null){
            return repository.save(item);
        }
        return null;
    }

    public void delete(BigInteger article_id){
        repository.delete_article_from_article_tupac(article_id);
        repository.deleteById(article_id);
    }

}
