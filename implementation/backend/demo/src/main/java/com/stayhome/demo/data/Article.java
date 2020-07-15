package com.stayhome.demo.data;

import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

import java.util.Vector;

@Entity
@Table(name = "app_article",
        schema = "public"
)
public class Article implements Serializable {

    @Id
    @GeneratedValue
    private BigInteger article_id;

    @Column
    @NotNull
    private String link;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String curso;

    @Column
    @NotNull
    private String tema;

    @Column
    @NotNull
    private String tipo;

    @Column
    @NotNull
    private String descripcion;

    @Column
    @NotNull
    private Boolean aceptado = false;

    @Column
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BigInteger user_id;

    @Column
    public Vector<String> comentarios;

    @Column
    public Vector<BigInteger> likes;

    @Column
    public Vector<BigInteger> dislikes;


    @Lob
    private byte[] data;

    public Article() {
    }

    public Article(String link, String title, String curso, String tema, String tipo,
                   String descripcion, Boolean aceptado, BigInteger user_id, byte[] data,
                   Vector<String> comentarios, Vector<BigInteger> likes, Vector<BigInteger> dislikes) {
        this.link = link;
        this.title = title;
        this.curso = curso;
        this.tema = tema;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.aceptado = aceptado;
        this.user_id = user_id;
        this.data = data;

        this.comentarios = comentarios;
        this.likes = likes;
        this.dislikes = dislikes;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getAceptado() { return aceptado; }

    public void setAceptado(Boolean aceptado) { this.aceptado = aceptado; }

    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    public byte[] getData() { return data; }

    public void setData(byte[] data) { this.data = data; }


    public Vector<String> getComentarios() { return comentarios; }

    public void setComentarios(Vector<String> comentarios) {
        this.comentarios = comentarios;
    }

    public Vector<BigInteger> getLikes() { return likes; }

    public void setLikes(Vector<BigInteger> likes) { this.likes = likes; }

    public Vector<BigInteger> getDislikes() { return dislikes; }

    public void setDislikes(Vector<BigInteger> dislikes) { this.dislikes = dislikes; }


}
