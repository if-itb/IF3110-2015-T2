/* Query for create table 'user' */

CREATE TABLE user
(
	UserID int NOT NULL AUTO_INCREMENT,
	Name varchar(255),
	Email varchar(255),
	Password varchar(255),
	PRIMARY KEY(UserID)
);
