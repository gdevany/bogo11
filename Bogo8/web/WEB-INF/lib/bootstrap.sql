ALTER TABLE Coupons DROP postersid;

DROP TABLE Users;
DROP TABLE Coupons;


CREATE TABLE Users (
    username VARCHAR(12) NOT NULL UNIQUE,
    password VARCHAR(15) NOT NULL,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    email VARCHAR(100) NOT NULL,
    bizname VARCHAR(40) NOT NULL,
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

CREATE TABLE Coupons (
    bizname VARCHAR(40) NOT NULL,
    bogodesc VARCHAR(80) NOT NULL,
    bizloc VARCHAR(80) NOT NULL,
    postersid INT NOT NULL,
    couponvalue NUMERIC(4,2) NOT NULL,
    coupondate DATE DEFAULT CURRENT_DATE,
    zip1 VARCHAR(5) NOT NULL,
    zip2 VARCHAR(5),
    zip3 VARCHAR(5),
    couponid INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

ALTER TABLE Coupons ADD FOREIGN KEY (postersid) REFERENCES Users (id);

INSERT INTO Users (username, password, firstname, lastname, email, bizname) VALUES
    ('joey', 'password', 'joey', 'joeys', 'joey@gmail.com', 'Joeys');

INSERT INTO Coupons (bizname, bogodesc, bizloc, postersid, couponvalue, coupondate, zip1, zip2, zip3) VALUES
    ('Joeys', 'xxsingle meat burger', 'Airport Blvd', 1, 4.99, '2015-12-07', '78701', '78702', '78703');


INSERT INTO Coupons (bizname, bogodesc, bizloc, postersid, couponvalue, coupondate, zip1, zip2, zip3) VALUES
    ('Bizzname', 'pizaa slice', 'YourStreet', 1, 5.99, '2015-12-07', '78701', '78702', '78704');


INSERT INTO Coupons (bizname, bogodesc, bizloc, postersid, couponvalue, coupondate, zip1, zip2, zip3) VALUES
    ('HamburgerShack', 'burger1', 'thisstreet', 1, 5.99, '2015-11-07', '78703', '78702', '78701');