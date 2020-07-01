package com.stayhome.demo.data;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;


@Entity
@Table(name = "app_article",
        schema = "public"
)
public class Article implements Serializable {

    @Id
    private BigInteger article_id;

    @Column
    private String link;

    @Column
    private String title;

    @Column
    private String curso;

    @Column
    private String tema;

    @Column
    private String tipo;

    @Column
    private BigInteger user_id;

    public Article() {
    }

    public Article(BigInteger article_id, String link, String title, String curso, String tema, String tipo,
                   BigInteger user_id) {
        this.article_id = article_id;
        this.link = link;
        this.title = title;
        this.curso = curso;
        this.tema = tema;
        this.tipo = tipo;
        this.user_id = user_id;
    }

    public BigInteger getArticle_id() {
        return article_id;
    }

    public void setArticle_id(BigInteger article_id) {
        this.article_id = article_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }
}
