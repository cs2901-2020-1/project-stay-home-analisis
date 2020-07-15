package com.stayhome.demo.business;

import com.stayhome.demo.data.User;
import com.stayhome.demo.exceptions.ArticleException;
import com.stayhome.demo.exceptions.ArticleNotFoundException;
import com.stayhome.demo.data.Article;
import com.stayhome.demo.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigInteger;
import java.nio.file.Paths;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

@Service
public class ArticleBusiness {

    @Autowired
    private ArticleRepository repository;

    private File f = new File("src/main/resources/Files/");
    private String upload_folder = f.getAbsolutePath();

    public Article storeFile(MultipartFile file, BigInteger id) {
        try {
            Article article = repository.findById(id).get();
            String titulo = file.getOriginalFilename();
            String tipo = file.getContentType();
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(article.getUser_id() +"/"+ titulo)
                    .toUriString();
            article.setTitle(titulo);
            article.setTipo(tipo);
            article.setLink(fileDownloadUri);
            article.setData(file.getBytes());
            Path path = Paths.get(upload_folder + "/"+ titulo);
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

        return new ArrayList<>(repository.findAll());
    }

    public Article getArticle(BigInteger article_id) {
        return repository.findById(article_id)
                .orElseThrow(() -> new ArticleNotFoundException("File not found with id " + article_id));
    }
    public Article update(Article item){
        Article a = repository.findById(item.getArticle_id()).get();
        if(a!=null){
            return repository.save(item);
        }
        return null;
    }

    /*
    public List<Article> findAll_id(user_id){

        return new ArrayList<>(repository.findById(user_id));
    }
*/

    /*public int addLike(BigInteger article_id, BigInteger user_id){

            //if usuario aun no ha likeado este articulo
            Article article = repository.findById(article_id).get();
            
            if(article.likes.contains(user_id)){
                article.likes.add(user_id);
            }
            //si ha likeado antes

            if(article.dislikes.contains(user_id)){
                article.dislikes.remove(user_id);
                article.likes.add(user_id);
            }
            return article.likes.size();
            
    }*/

    /*public int addDislike(BigInteger article_id, BigInteger user_id){
            //if usuario aun no ha dislikeado este articulo
            Article article = repository.findById(article_id).get();
            
            if(article.dislikes.contains(user_id)){
                article.dislikes.add(user_id);
            }
            //si ha likeado antes

            if(article.likes.contains(user_id)){
                article.likes.remove(user_id);
                article.dislikes.add(user_id);
            }
             
            return article.dislikes.size();


    }*/

    /*public void addComment(BigInteger article_id, BigInteger user_id, String comment){
        try{
            Article article = repository.findById(article_id).get();
            article.comentarios.add(comment);
        } catch (Exception ex){
            //alerta "Solo usuarios logeados pueden dejar feedback!"
        }
    }*/

    public void delete(BigInteger article_id){

        repository.deleteById(article_id);
    }

}
