-- src/main/resources/schema.sql

CREATE TABLE IF NOT EXISTS write_posts (
    post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS write_comments (
    comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    comment VARCHAR(255) NOT NULL,
    post_id BIGINT,
    FOREIGN KEY (post_id) REFERENCES write_posts(post_id)
);


CREATE TABLE IF NOT EXISTS read_posts (
    post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    comment_count int NOT NULL default 0
);

CREATE TABLE IF NOT EXISTS read_comments (
    comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    comment VARCHAR(255) NOT NULL,
    post_id BIGINT,
    FOREIGN KEY (post_id) REFERENCES read_posts(post_id)
);
