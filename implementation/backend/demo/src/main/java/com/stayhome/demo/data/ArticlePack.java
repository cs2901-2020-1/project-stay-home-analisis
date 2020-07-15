package com.stayhome.demo.data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "app_article_pack",
        schema = "public"
)
public class ArticlePack implements Serializable {
    @Id
    @GeneratedValue
    private BigInteger articlepack_id;

    @Column
    @NotNull
    private String name;

    public ArticlePack() {
    }

    public ArticlePack(String name) {
        this.name = name;
    }


    public BigInteger getArticlepack_id() {
        return articlepack_id;
    }

    public void setArticlepack_id(BigInteger articlepack_id) {
        this.articlepack_id = articlepack_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
