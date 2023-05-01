DROP TABLE IF EXISTS PRODUCT_CATEGORY;
DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS CATEGORY;
DROP TABLE IF EXISTS CUSTOMER;
DROP TABLE IF EXISTS CART;

CREATE TABLE PRODUCT
(
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL,
    image_url   TEXT        NOT NULL,
    price       INT         NOT NULL,
    description VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE CATEGORY
(
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE PRODUCT_CATEGORY
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    product_id  BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES PRODUCT (id),
    FOREIGN KEY (category_id) REFERENCES CATEGORY (id)
);

CREATE TABLE CUSTOMER
(
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE CART
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    customer_id BIGINT NOT NULL,
    product_id  BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER (id),
    FOREIGN KEY (product_id) REFERENCES PRODUCT (id)
);

INSERT INTO CATEGORY (id, name)
VALUES (1, '카페');
INSERT INTO CATEGORY (id, name)
VALUES (2, '한식');
INSERT INTO CATEGORY (id, name)
VALUES (3, '양식');
INSERT INTO CATEGORY (id, name)
VALUES (4, '일식');
INSERT INTO CATEGORY (id, name)
VALUES (5, '중식');
INSERT INTO CATEGORY (id, name)
VALUES (6, '치킨');
INSERT INTO CATEGORY (id, name)
VALUES (7, '분식');
INSERT INTO CATEGORY (id, name)
VALUES (8, '해산물');
INSERT INTO CATEGORY (id, name)
VALUES (9, '샐러드');
INSERT INTO CATEGORY (id, name)
VALUES (10, '없음');
INSERT INTO CUSTOMER (password, email)
VALUES (HASH('SHA-256', 'password', 2), 'voicesplit@daum.net');
