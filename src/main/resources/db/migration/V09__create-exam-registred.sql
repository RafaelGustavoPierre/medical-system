CREATE TABLE exam_registred (
	id bigint NOT NULL AUTO_INCREMENT,
	patient_historic_id bigint NOT NULL,
	exam_id bigint NOT NULL,
	price DECIMAL(18,2) NOT NULL,
	time_registred datetime NOT NULL,

	PRIMARY KEY(id),
	FOREIGN KEY(exam_id) REFERENCES exam(id),
	FOREIGN KEY(patient_historic_id) REFERENCES patient_historic(id)
);
INSERT INTO exam_registred (patient_historic_id, exam_id, price, time_registred) VALUES (1, 1, 189.99, CURRENT_TIMESTAMP());
INSERT INTO exam_registred (patient_historic_id, exam_id, price, time_registred) VALUES (2, 2, 249.98, CURRENT_TIMESTAMP());