package com.stayhome.demo.data;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;


@Entity
@Table(name = "app_user",
        schema = "public"
)
public class User implements Serializable{

    @Id
    private BigInteger user_id;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    public User() {
    }

    public User(BigInteger user_id, String email, String password, String username) {
        this.user_id = user_id;
        this.email =  email;
        this.username = username;
        this.password = password;
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
}
