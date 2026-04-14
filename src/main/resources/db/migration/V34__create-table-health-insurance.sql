CREATE TABLE health_insurance (
	id bigint NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	PRIMARY KEY(id),
	UNIQUE KEY(name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO health_insurance VALUES (1, 'Particular');
INSERT INTO health_insurance VALUES (2, 'Unimed');
INSERT INTO health_insurance VALUES (3, 'Amil');
INSERT INTO health_insurance VALUES (4, 'Bradesco Saúde');
INSERT INTO health_insurance VALUES (5, 'NotreDame');