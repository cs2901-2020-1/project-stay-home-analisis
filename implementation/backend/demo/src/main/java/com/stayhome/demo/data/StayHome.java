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
public class StayHome implements Serializable{

    @Id
    private BigInteger user_id;

    @Column
    private String email;

    @Column
    private String password;

    public StayHome() {
    }

    public StayHome(BigInteger user_id, String email, String password) {
        this.user_id = user_id;
        this.email =  email;
        this.password = password;
    }


    public BigInteger getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
