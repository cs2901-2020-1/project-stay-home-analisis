package com.stayhome.demo.data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class    Dbi implements Serializable {

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article articleid;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userid;


    public Dbi(){

    }

    public Dbi(Article articleid, User userid) {
        this.articleid=articleid;
        this.userid=userid;
    }


    public Article getArticleid() {
        return articleid;
    }

    public void setArticleid(Article articleid) {
        this.articleid = articleid;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }


}