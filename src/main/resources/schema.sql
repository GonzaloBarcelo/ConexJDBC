create table USER (
	id integer identity primary key,
	USER_NAME VARCHAR(45) NOT NULL,
	PASSWORD VARCHAR(45) NOT NULL,
	EMAIL VARCHAR(100)

);

CREATE TABLE CONTACT(
    id integer identity primary key,
    USER_NAME varchar(30),
    NAME varchar(45),
    NUMBER INTEGER
);
