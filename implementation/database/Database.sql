CREATE TABLE APP_USER(
    USER_ID  BIGINT not null,
    EMAIL    VARCHAR(128) not null UNIQUE,
    USERNAME VARCHAR(128) not null UNIQUE,
    PASSWORD VARCHAR(128) not null,
    PRIMARY KEY(USER_ID)
);

INSERT INTO APP_USER VALUES 
(1, 'test@gmail.com', 'username','password');



CREATE TABLE APP_ARTICLE(
    ARTICLE_ID  BIGINT not null,
    LINK    VARCHAR(128) not null UNIQUE,
    TITLE VARCHAR(128) not null UNIQUE,
    CURSO VARCHAR(128) not null,
	TEMA VARCHAR(128) not null,
	TIPO VARCHAR(128) not null,
	USER_ID BIGINT not null REFERENCES app_user(user_id),
    PRIMARY KEY(ARTICLE_ID)
);


CREATE TABLE app_likesbyarticle(
    articleid BIGINT not null REFERENCES app_article(article_id),
    userid BIGINT not null REFERENCES app_user(user_id),
    lik BOOLEAN not null,
    PRIMARY KEY(article_id,userid)
);
