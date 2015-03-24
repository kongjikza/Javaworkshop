DROP TABLE IF EXISTS basic_product;

CREATE TABLE basic_product (
	productid INT NOT NULL,
	productname VARCHAR(255)
);


ALTER TABLE IF EXISTS product DROP CONSTRAINT "product_fk1";
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_category;

CREATE TABLE product_category (
	id INT NOT NULL,
	categoryname VARCHAR(255),
	CONSTRAINT "category_pk" PRIMARY KEY (id)
);
CREATE TABLE product (
	productid INT NOT NULL,
	productname VARCHAR(255),
	categoryid INT,
	CONSTRAINT "product_pk" PRIMARY KEY (productid)
);
ALTER TABLE product
  ADD CONSTRAINT product_fk1 FOREIGN KEY (categoryid) REFERENCES product_category (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

  

ALTER TABLE IF EXISTS userprofile DROP CONSTRAINT "userprofile_fk1";
ALTER TABLE IF EXISTS userprofile DROP CONSTRAINT "userprofile_fk2";
ALTER TABLE IF EXISTS education DROP CONSTRAINT "education_fk1";
ALTER TABLE IF EXISTS education DROP CONSTRAINT "education_fk2";
ALTER TABLE IF EXISTS job DROP CONSTRAINT "job_fk1";
ALTER TABLE IF EXISTS homeaddress DROP CONSTRAINT "homeaddress_fk1";
ALTER TABLE IF EXISTS homeaddress DROP CONSTRAINT "homeaddress_fk2";

DROP TABLE IF EXISTS useraccount;
DROP TABLE IF EXISTS education_institute;
DROP TABLE IF EXISTS province;
DROP TABLE IF EXISTS homeaddress;
DROP TABLE IF EXISTS userprofile;
DROP TABLE IF EXISTS education;
DROP TABLE IF EXISTS job;

CREATE TABLE useraccount (
	id INT NOT NULL,
	username VARCHAR(10) NOT NULL,
	password VARCHAR(255) NOT NULL,
	CONSTRAINT "useraccount_pk" PRIMARY KEY (id)
);
CREATE TABLE education_institute (
	id INT NOT NULL,
	institutename VARCHAR(255) NOT NULL,
	CONSTRAINT "education_institute_pk" PRIMARY KEY (id)
);
CREATE TABLE province (
	id INT NOT NULL,
	provincename VARCHAR(255) NOT NULL,
	CONSTRAINT "province_pk" PRIMARY KEY (id)
);
CREATE TABLE userprofile (
	id INT NOT NULL,
	firstname VARCHAR(255),
	lastname VARCHAR(255),
	email VARCHAR(255),
	homeaddressid INT,
	useraccountid INT,
	CONSTRAINT "userprofile_pk" PRIMARY KEY (id)
);
CREATE TABLE homeaddress (
	id INT NOT NULL,
	street1 VARCHAR(255),
	street2 VARCHAR(255),
	provinceid int,
	zipcode int,
	userprofileid INT,
	CONSTRAINT "homeaddress_pk" PRIMARY KEY (id)
);
CREATE TABLE education (
	id INT NOT NULL,
	userprofileid INT,
	educationinstituteid INT,
	qualification VARCHAR(255) NOT NULL,
	fromyear INT,
	toyear INT,
	CONSTRAINT "education_pk" PRIMARY KEY (id)
);
CREATE TABLE job (
	id INT NOT NULL,
	userprofileid INT,
	position VARCHAR(255) NOT NULL,
	fromyear INT,
	toyear INT,
	CONSTRAINT "job_pk" PRIMARY KEY (id)
);

ALTER TABLE homeaddress
  ADD CONSTRAINT homeaddress_fk1 FOREIGN KEY (provinceid) REFERENCES province (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE homeaddress
  ADD CONSTRAINT homeaddress_fk2 FOREIGN KEY (userprofileid) REFERENCES userprofile (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE education
  ADD CONSTRAINT education_fk1 FOREIGN KEY (userprofileid) REFERENCES userprofile (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE education
  ADD CONSTRAINT education_fk2 FOREIGN KEY (educationinstituteid) REFERENCES education_institute (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE job
  ADD CONSTRAINT job_fk1 FOREIGN KEY (userprofileid) REFERENCES userprofile (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE userprofile
  ADD CONSTRAINT userprofile_fk1 FOREIGN KEY (homeaddressid) REFERENCES homeaddress (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE userprofile
  ADD CONSTRAINT userprofile_fk2 FOREIGN KEY (useraccountid) REFERENCES useraccount (id) ON UPDATE NO ACTION ON DELETE NO ACTION;


INSERT INTO province VALUES(1, 'Bangkok');
INSERT INTO province VALUES(2, 'Petchburi');
INSERT INTO province VALUES(3, 'Chiangmai');
INSERT INTO province VALUES(4, 'Phuket');
INSERT INTO province VALUES(5, 'Chumporn');
INSERT INTO province VALUES(6, 'Udornthani');

INSERT INTO education_institute VALUES(1, 'Little Panda University');
INSERT INTO education_institute VALUES(2, 'Puchalaymahavitchalai');
INSERT INTO education_institute VALUES(3, 'Chill Chill College');