-- Table: User
CREATE TABLE user (
  id             INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_firstname VARCHAR(255) NOT NULL,
  user_lastname  VARCHAR(255) NOT NULL,
  user_login VARCHAR (255) NOT NULL ,
  user_password  VARCHAR(255) NOT NULL,
  user_email     VARCHAR(255) NOT NULL,
  user_role      INT(32)
)
  ENGINE = InnoDB;

-- Table: User Role
CREATE TABLE role (
  id        INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role_name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table: Artist
CREATE TABLE artist (
  id               INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  artist_firstname VARCHAR(255) NOT NULL,
  artist_second    VARCHAR(255) NOT NULL,
  artist_nickname  VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: Label
CREATE TABLE record_label (
  id               INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  label_name VARCHAR(255) NOT NULL,
  artist_connty    VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: Music Release
CREATE TABLE music_release (
  id            INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  artist        INT          NOT NULL,
  release_title VARCHAR(255) NOT NULL,
  record_label  INT          NOT NULL,
  release_date  DATE         NOT NULL,
  author_review INT,
  review        INT
)
  ENGINE = InnoDB;

-- Table: Review
CREATE TABLE review (
  id             INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  review_name    VARCHAR(255) NOT NULL,
  review_release INT          NOT NULL,
  review_text    VARCHAR(255) NOT NULL,
  review_rate    INT          NOT NULL,
  review_time    DATE
)
  ENGINE = InnoDB;

-- Data Insert to table: user
INSERT INTO user VALUE (1, 'Sergii', 'Gagauz', 'Gagauz25', 'admin', 'gsa@gmail.com', 'admin');
INSERT INTO user VALUE (2, 'Mixim', 'Reality', 'Maxim15','admin', 'mrv@gmail.com', 'reviewer');

-- Data Insert to table: role
INSERT INTO role VALUE (1, 'admin');
INSERT INTO role VALUE (2, 'regular');
INSERT INTO role VALUE (3, 'reviewer');

-- Data Insert to table: Artist
INSERT INTO artist VALUE (1, 'Markus', 'Schulz', 'Markus Schulz');
INSERT INTO artist VALUE (2, 'Armin', 'van Buuren', 'Armin van Buuren');
INSERT INTO artist VALUE (3, 'Sander', 'van Doorn', 'Sander van Doorn');

-- Data Insert to table: Record_Label
INSERT INTO record_label VALUE (1, 'Colharbour Recordings', 'USA');
INSERT INTO record_label VALUE (2, 'Armada Recordings', 'Netherlands');
INSERT INTO record_label VALUE (3, 'Doorn Records', 'Netherlands');

-- Data Insert to table: Music Release
INSERT INTO music_release VALUE (1, 1, 'Makus Schulz - Coldharbour (Original mix)', 1, '2017-10-29', 1, 1);
INSERT INTO music_release VALUE (2, 2, 'Armin van Buuren - From the Dark (Original mix)', 2, '2017-10-29', 2, 2);

-- Data Insert to table: Review
INSERT INTO review VALUE (1, 'Review on Makus Schulz - Coldharbour', 1, 'Good release!', 8, '2017-10-30')


