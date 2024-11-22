CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE questions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) NOT NULL
);

CREATE TABLE answer_options (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    question_id BIGINT NOT NULL,
    FOREIGN KEY (question_id) REFERENCES questions(id)
);

CREATE TABLE scores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    question_id BIGINT NOT NULL,
    option_id BIGINT NOT NULL,
    is_correct BOOLEAN NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (question_id) REFERENCES questions(id),
    FOREIGN KEY (option_id) REFERENCES answer_options(id)
);