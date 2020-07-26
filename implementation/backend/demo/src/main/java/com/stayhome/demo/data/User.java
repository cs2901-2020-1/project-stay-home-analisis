package com.stayhome.demo.data;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "app_user",
        schema = "public"
)
public class User implements Serializable{

    @Id
    @GeneratedValue
    private BigInteger user_id;

    @Column (unique = true)
    @NotNull
    private String email;

    @Column (unique = true)
    @NotNull
    private String username;

    @Column
    @NotNull
    private String password;

    @Column
    @NotNull
    private BigInteger contador_articlepack;
    @Column
    @NotNull
    private Boolean admin = false;

    public User() {
    }

    @JsonCreator
    public User(@JsonProperty("user_id")BigInteger user_id, @JsonProperty("email")String email, @JsonProperty("password")String password,
                @JsonProperty("username") String username, @JsonProperty("contador_articlepack")BigInteger contador_articlepack,@JsonProperty("admin")Boolean admin) {
        this.user_id = user_id;
        this.email =  email;
        this.username = username;
        this.password = password;
        this.contador_articlepack = contador_articlepack;
        this.admin = admin;
    }


    public BigInteger getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() { return username; }

    public String getPassword() {
        return password;
    }

    public Boolean  getAdmin() {return admin;}

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getContador_articlepack() {
        return contador_articlepack;
    }

    public void setContador_articlepack(BigInteger contador_articles) {
        this.contador_articlepack = contador_articles;
    }

    public void setAdmin(Boolean admin) {this.admin = admin;}

}
