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
    ('joey', 'password', 'Joey', 'Joeys', 'joey@gmail.com', 'Joeys');

INSERT INTO Coupons (bizname, bogodesc, bizloc, postersid, couponvalue, coupondate, zip1, zip2, zip3) VALUES
    ('Joeys', 'No.1 Value meal', '130500 Airport Blvd, Austin, Tx', 1, 8.99, '2015-12-05', '78701', '78702', '78703');

INSERT INTO Coupons (bizname, bogodesc, bizloc, postersid, couponvalue, coupondate, zip1, zip2, zip3) VALUES
    ('Big Bobs Pizza Barn', 'pizza slice', '50000 South 1st St. Austin, Tx', 1, 5.99, '2015-12-05', '78701', '78702', '78704');

INSERT INTO Coupons (bizname, bogodesc, bizloc, postersid, couponvalue, coupondate, zip1, zip2, zip3) VALUES
    ('HamburgerShack', 'Any Value meal', '13509 East Main Street (next to Starbucks)', 1, 8.99, '2015-12-06', '78701', '78702', '78705');

INSERT INTO Coupons (bizname, bogodesc, bizloc, postersid, couponvalue, coupondate, zip1, zip2, zip3) VALUES
    ('Tacos And Spirits', 'Two Tacos (crunchy or soft)', '150 Allendale Blvd.', 1, 7.00, '2015-12-06', '78703', '78704', '78705');

INSERT INTO Coupons (bizname, bogodesc, bizloc, postersid, couponvalue, coupondate, zip1, zip2, zip3) VALUES
    ('Leroys Chicken Coupe', 'Bucket of chicken', '14441 Melrose Ave.', 1, 12.99, '2015-12-08', '78702', '78704', '78705');

INSERT INTO Coupons (bizname, bogodesc, bizloc, postersid, couponvalue, coupondate, zip1, zip2, zip3) VALUES
    ('N.Y. Subshop', 'Any small sub', '1616 Texas Ave.', 1, 6.99, '2015-11-09', '78701', '78703', '78704');