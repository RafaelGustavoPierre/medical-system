CREATE TABLE patient_historic (
	id bigint NOT NULL AUTO_INCREMENT,
	patient_id bigint NOT NULL,
	worker_id bigint NOT NULL,

	PRIMARY KEY(id),
	FOREIGN KEY(patient_id) REFERENCES patient(id),
	FOREIGN KEY(worker_id) REFERENCES worker(id)
);
INSERT INTO patient_historic (patient_id, worker_id) VALUES (1, 1);
INSERT INTO patient_historic (patient_id, worker_id) VALUES (2, 1);