package com.stayhome.demo.data;

import javax.persistence.*;
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

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Boolean admin;

    public User() {
    }

    public User(String email, String password, String username, Boolean admin) {
        this.email =  email;
        this.username = username;
        this.password = password;
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

    public Boolean getAdmin() {return admin;}

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

    public void setAdmin(Boolean admin) {this.admin = admin;}
}
