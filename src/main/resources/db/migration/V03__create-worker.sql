CREATE TABLE worker (
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(35) NOT NULL,
	occupation_id bigint NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (occupation_id) REFERENCES occupation(id)
);
INSERT INTO worker (name, occupation_id) VALUES ("Renato Faisca", 1);
INSERT INTO worker (name, occupation_id) VALUES ("João Embaixadinha", 1);
INSERT INTO worker (name, occupation_id) VALUES ("Maria Rabiscada", 2);
INSERT INTO worker (name, occupation_id) VALUES ("Victória Coockie", 3);