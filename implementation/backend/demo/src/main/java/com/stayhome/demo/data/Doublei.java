package com.stayhome.demo.data;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;

@Embeddable
public class Doublei implements Serializable {

    @NotNull
    private BigInteger articlepackid;

    @NotNull
    private BigInteger article_id;


    public Doublei(){

    }


    public Doublei(BigInteger articlepackid, BigInteger article_id)
    {
        this.articlepackid=articlepackid;
        this.article_id=article_id;
    }

    public BigInteger getarticlepackid() {
        return articlepackid;
    }

    public void setarticlepackid(BigInteger articlepackid) {
        this.articlepackid = articlepackid;
    }

    public BigInteger getArticle_id() {
        return article_id;
    }

    public void setArticle_id(BigInteger  article_id) {
        this.article_id = article_id;
    }
}