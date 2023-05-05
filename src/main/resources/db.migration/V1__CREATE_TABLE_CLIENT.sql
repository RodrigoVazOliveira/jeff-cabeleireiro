CREATE TABLE clients (
    id BIGSERIAL NOT NULL,
    name_complete VARCHAR(150) NOT NULL,
    email VARCHAR(300) NOT NULL,
    number_telephone VARCHAR(30) NOT NULL,
    gender VARCHAR(70),
    CONSTRAINT PK_CLIENTS PRIMARY KEY (id)
);