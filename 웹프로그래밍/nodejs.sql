CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    age INT UNSIGNED NOT NULL,
     married TINYINT NOT NULL,
     comment TEXT NULL,
     created_at DATETIME NOT NULL DEFAULT now(),
     PRIMARY KEY(id),
    UNIQUE INDEX name_UNIQUE (name ASC))
     COMMENT = '사용자 정보'
     DEFAULT CHARACTER SET = utf8
    ENGINE = InnoDB;
)
CREATE TABLE nodejs.comments (
id INT NOT NULL AUTO_INCREMENT,
commenter INT NOT NULL,
comment VARCHAR(100) NOT NULL,
created_at DATETIME NOT NULL DEFAULT now(),
PRIMARY KEY (id),
INDEX commenter_idx (commenter ASC),
CONSTRAINT commenter
FOREIGN KEY (commenter) REFERENCES users (id)
ON DELETE CASCADE
ON UPDATE CASCADE
) COMMENT = '댓글' DEFAULT CHARSET=utf8mb4 ENGINE=InnoDB;

INSERT INTO users(name, age, married, comment) VALUES
('clara', 21 , 0, '대학생입니다'),
('andrew', 35 , 1, '데이터 사이언티스트입니다'),
('doo', 52 , 0, '중학생입니다'),
('cutty', 12 , 0, '웹개발자입니다');

INSERT INTO comments (commenter, comment) VALUES
(2,'반갑'),
(4, '유익'),
(3, '와우');