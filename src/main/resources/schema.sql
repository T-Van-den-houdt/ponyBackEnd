DROP TABLE IF EXISTS TOYS_OWNED_BY;
DROP TABLE IF EXISTS MY_ANIMALS;
DROP TABLE IF EXISTS MY_STABLES;
DROP TABLE IF EXISTS MY_ADDRESSES;
DROP TABLE IF EXISTS MY_TOYS;

CREATE TABLE MY_ADDRESSES(
    ID LONG AUTO_INCREMENT PRIMARY KEY,
    STREET VARCHAR(255),
    NUMBER INT,
    PLACE VARCHAR(255)
);

CREATE TABLE MY_STABLES(
    ID LONG AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255),
    MAX_ANIMALS INT,
    MY_ADDRESSES_ID LONG,
    FOREIGN KEY (MY_ADDRESSES_ID) REFERENCES MY_ADDRESSES
);

CREATE TABLE MY_TOYS(
    ID LONG AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255)
);

CREATE TABLE MY_ANIMALS(
    ID LONG AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255),
    AGE INT,
    MY_STABLES_ID LONG,
    FOREIGN KEY (MY_STABLES_ID) REFERENCES MY_STABLES
);

CREATE TABLE TOYS_OWNED_BY(
    MY_TOYS_ID LONG,
    MY_ANIMALS_ID LONG,
    PRIMARY KEY(MY_TOYS_ID, MY_ANIMALS_ID),
    FOREIGN KEY(MY_TOYS_ID) REFERENCES MY_TOYS,
    FOREIGN KEY(MY_ANIMALS_ID) REFERENCES MY_ANIMALS
);

