--liquibase formatted sql

--changeset anagornaia:1 comment: blog domain definition
CREATE SEQUENCE seq_user
	INCREMENT BY 10
	MINVALUE 1
	MAXVALUE 9223372036854775807
	CACHE 1
	NO CYCLE;

CREATE TABLE t_user
(
    id              BIGINT             DEFAULT nextval('seq_user') PRIMARY KEY
,   uuid            VARCHAR(36)        NOT NULL
,   username        VARCHAR(150)       CHECK (char_length(username) >= 4)
,   password        VARCHAR(64)        CHECK (char_length(password) >= 8)
,   email           VARCHAR(100)       NOT NULL
);

CREATE SEQUENCE seq_blog_post
	INCREMENT BY 10
	MINVALUE 1
	MAXVALUE 9223372036854775807
	CACHE 1
	NO CYCLE;

CREATE TABLE t_blog_post
(
    id              BIGINT            DEFAULT nextval('seq_blog_post') PRIMARY KEY
,   uuid            VARCHAR(36)       NOT NULL
,   title           VARCHAR(50)       NOT NULL
,   content         VARCHAR(40000)    NOT NULL
,   author_id       BIGINT
,   img_path        VARCHAR(150)

,   CONSTRAINT fk_blog_post_user   FOREIGN KEY (author_id)    REFERENCES t_user (id)
);

CREATE SEQUENCE seq_comment
	INCREMENT BY 10
	MINVALUE 1
	MAXVALUE 9223372036854775807
	CACHE 1
	NO CYCLE;

CREATE TABLE t_comment
(
    id              BIGINT            DEFAULT nextval('seq_comment') PRIMARY KEY
,   uuid            VARCHAR(36)       NOT NULL
,   content         VARCHAR(300)      NOT NULL
,   author_name     VARCHAR(36)       NOT NULL
,   email           VARCHAR(100)      NOT NULL
,   blog_post_id    BIGINT            NOT NULL

,   CONSTRAINT fk_blog_post_comment   FOREIGN KEY (blog_post_id)    REFERENCES t_blog_post (id)
);

CREATE SEQUENCE seq_tag
    INCREMENT BY 10
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

CREATE TABLE t_tag
(
    id           BIGINT           DEFAULT nextval('seq_tag') PRIMARY KEY
,   name         VARCHAR(16)      NOT NULL
);

CREATE TABLE t_blog_post_tag
(
    blog_post_id           BIGINT           NOT NULL
,   tag_id                 BIGINT           NOT NULL

,   CONSTRAINT fk_blog_post_id    FOREIGN KEY (blog_post_id)    REFERENCES t_blog_post (id)
,   CONSTRAINT fk_tag_id          FOREIGN KEY (tag_id)          REFERENCES t_tag (id)
);