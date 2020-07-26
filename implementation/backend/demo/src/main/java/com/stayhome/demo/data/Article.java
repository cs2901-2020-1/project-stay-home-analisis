package com.stayhome.demo.data;

import javax.validation.constraints.NotNull;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;


@Entity
@Table(name = "app_article",
        schema = "public"
)
public class Article implements Serializable {

    @Id
    @GeneratedValue
    private BigInteger article_id;

    @Column (unique = true)
    @NotNull
    private String link;

    @Column (unique = true)
    @NotNull
    private String title;

    @Column (unique = true)
    @NotNull
    private String nombre;

    @Column
    @NotNull
    private String curso;

    @Column
    @NotNull
    private String tema;

    @Column
    @NotNull
    private String tipo;

    @Column (unique = true)
    @NotNull
    private String descripcion;

    @Column
    @NotNull
    private BigInteger countlikes = BigInteger.valueOf(0);

    @Column
    @NotNull
    private BigInteger countdislikes = BigInteger.valueOf(0);

    @Column
    @NotNull
    private LocalDateTime fecha = LocalDateTime.now();

    @Column
    @NotNull
    private Boolean aceptado = false;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Lob
    private byte[] data;

    public Article() {
    }

    public Article(String link, String title, String curso, String tema, String tipo,
                   String nombre, String descripcion, Boolean aceptado, User user, byte[] data) {
        this.link = link;
        this.title = title;
        this.curso = curso;
        this.tema = tema;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aceptado = aceptado;
        this.user = user;
        this.data = data;

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

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

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

    public LocalDateTime getLocalDateTime() { return fecha; }

    public void setLocalDateTime(LocalDateTime localDateTime) {this.fecha = localDateTime; }

    public Boolean getAceptado() { return aceptado; }

    public void setAceptado(Boolean aceptado) { this.aceptado = aceptado; }

    public User getUser() { return user; }

    public void setUser(User user) {this.user = user; }

    public byte[] getData() { return data; }

    public void setData(byte[] data) { this.data = data; }

    public BigInteger getCountlikes() {
        return countlikes;
    }

    public void setCountlikes(BigInteger countlikes) {
        this.countlikes = countlikes;
    }

    public BigInteger getCountdislikes() {
        return countdislikes;
    }

    public void setCountdislikes(BigInteger countdislikes) {
        this.countdislikes = countdislikes;
    }

}
