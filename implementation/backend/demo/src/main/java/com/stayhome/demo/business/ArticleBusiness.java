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
    /*
    public List<Article> findAll_id(user_id){

        return new ArrayList<>(repository.findById(user_id));
    }
*/
    public void deleteArticle_user_id(BigInteger user_id){
        repository.deleteById(user_id);
    }
    public void delete(BigInteger article_id){

        repository.deleteById(article_id);
    }

}
