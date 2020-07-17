package com.stayhome.demo.data;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;

@Embeddable
public class    Dbi implements Serializable {

    @Column
    @NotNull
    private BigInteger articleid;


    @Column
    @NotNull
    private BigInteger userid;


    public Dbi(){

    }


    public Dbi(BigInteger articleid, BigInteger userid) {
        this.articleid=articleid;
        this.userid=userid;
    }

    public BigInteger getArticleid() {
        return articleid;
    }

    public void setArticleid(BigInteger articleid) {
        this.articleid = articleid;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }


}