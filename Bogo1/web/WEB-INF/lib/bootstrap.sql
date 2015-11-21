DROP TABLE Users;
DROP TABLE Coupons;


CREATE TABLE Users (
    username VARCHAR(12) NOT NULL UNIQUE,
    password VARCHAR(15) NOT NULL,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    email VARCHAR(100) NOT NULL,
    bizip INT NOT NULL,
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

CREATE TABLE Coupons (
    bizname VARCHAR(40) NOT NULL,
    bogodesc VARCHAR(80) NOT NULL,
    bizloc VARCHAR(80) NOT NULL,
    postersid INT NOT NULL,
    couponvalue NUMERIC(4,2) NOT NULL,
    coupondate DATE DEFAULT CURRENT_DATE,
    zip1 INT NOT NULL,
    zip2 INT,
    zip3 INT,
    couponid INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

ALTER TABLE Coupons ADD FOREIGN KEY (postersid) REFERENCES Users (id);

INSERT INTO Users (username, password, firstname, lastname, email, bizip) VALUES
    ('joey', 'password', 'joey', 'joeys', 'joey@gmail.com', 78701);

INSERT INTO Coupons (bizname, bogodesc, bizloc, postersid, couponvalue, coupondate, zip1, zip2, zip3) VALUES
    ('Joeys', 'sEWERWERTingle meat burger', 'Airport Blvd', 1, 4.99, '2015-11-01', 78701, 78702, 78703);

