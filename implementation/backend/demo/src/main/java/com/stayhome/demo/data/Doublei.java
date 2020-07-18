package com.stayhome.demo.data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
public class Doublei implements Serializable {

    @ManyToOne
    @JoinColumn(name = "articlepack_id", nullable = false)
    private ArticlePack articlepack;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;


    public Doublei(){

    }

    public Doublei(ArticlePack articlepack, Article article) {
        this.articlepack=articlepack;
        this.article=article;
    }

    public ArticlePack getArticlepack() {
        return articlepack;
    }

    public void setArticlepack(ArticlePack articlepack) {
        this.articlepack = articlepack;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }


}