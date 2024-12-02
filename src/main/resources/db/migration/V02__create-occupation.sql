CREATE TABLE occupation (
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(35) NOT NULL,
	department_id bigint NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (department_id) REFERENCES department(id)
);
INSERT INTO occupation (name, department_id) VALUES ("Doctor", 1);
INSERT INTO occupation (name, department_id) VALUES ("Nurse", 1);
INSERT INTO occupation (name, department_id) VALUES ("Technologist", 2);