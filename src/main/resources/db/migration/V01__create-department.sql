CREATE TABLE department(
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(35) NOT NULL,
	PRIMARY KEY(id),
	UNIQUE(name)
);
INSERT INTO department (name) VALUES ("Emergency");
INSERT INTO department (name) VALUES ("Radiology");