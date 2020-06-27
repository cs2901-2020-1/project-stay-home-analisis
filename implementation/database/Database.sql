CREATE TABLE APP_USER(
    USER_ID  BIGINT not null,
    EMAIL    VARCHAR(128) not null UNIQUE,
    USERNAME VARCHAR(128) not null UNIQUE,
    PASSWORD VARCHAR(128) not null,
    PRIMARY KEY(USER_ID)
);

INSERT INTO APP_USER VALUES 
(1, 'test@gmail.com', 'username','password');
