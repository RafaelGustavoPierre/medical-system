CREATE TABLE patient (
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(60) NOT NULL,

	PRIMARY KEY(id)
);
INSERT INTO patient (name) VALUES ("João Laranja Fina");
INSERT INTO patient (name) VALUES ("Maria Joana");