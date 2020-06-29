package com.stayhome.demo.data;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;


@Entity
@Table(name = "app_admin",
        schema = "public"
)
public class Admin implements Serializable{

    @Id
    private BigInteger admin_id;

    @Column
    private String email;

    @Column
    private String adminname;

    @Column
    private String password;

    public admin() {
    }

    public admin(BigInteger admin_id, String email, String password, String adminname) {
        this.admin_id = admin_id;
        this.email =  email;
        this.adminname = adminname;
        this.password = password;
    }


    public BigInteger getAdmin_id() {
        return admin_id;
    }

    public String getEmail() {
        return email;
    }

    public String getAdminname() { return adminname; }

    public String getPassword() {
        return password;
    }

    public void setAdmin_id(BigInteger admin_id) {
        this.admin_id = admin_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
