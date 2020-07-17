package com.stayhome.demo.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="app_articlesbypack",
        schema="public")
public class ArticlesPorPack implements Serializable{

    @EmbeddedId
    private Doublei doublei;


    public ArticlesPorPack(){

    }

    public ArticlesPorPack(Doublei id)
    {
        this.doublei = id;
    }

    public Doublei getDoublei() {
        return doublei;
    }

    public void setDoublei(Doublei doublei) {
        this.doublei = doublei;
    }
}