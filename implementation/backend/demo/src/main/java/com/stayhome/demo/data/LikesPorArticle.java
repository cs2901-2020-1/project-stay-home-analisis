package com.stayhome.demo.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name="app_likesbyarticle",
        schema="public")
public class LikesPorArticle implements Serializable{

    @EmbeddedId
    private Dbi dbi;

    @Column
    @NotNull
    private Boolean lik;

    public LikesPorArticle(){

    }

    public LikesPorArticle(Dbi id)
    {
        this.dbi = id;
    }

    public Dbi getDbi() {
        return dbi;
    }

    public void setDbi(Dbi dbi) { this.dbi = dbi; }


    public Boolean getLik() {
        return lik;
    }

    public void setLik(Boolean lik) {
        this.lik = lik;
    }
}