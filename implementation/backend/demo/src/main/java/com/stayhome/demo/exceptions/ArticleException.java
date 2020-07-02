package com.stayhome.demo.exceptions;

public class ArticleException extends RuntimeException {
    public ArticleException(String message) {
        super(message);
    }

    public ArticleException(String message, Throwable cause) {
        super(message, cause);
    }
}