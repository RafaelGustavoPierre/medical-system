CREATE TABLE patient_record(
	id bigint NOT NULL AUTO_INCREMENT,
	patient_id bigint NOT NULL,
	worker_id bigint NOT NULL,

	PRIMARY KEY(id),
	FOREIGN KEY (patient_id) REFERENCES patient(id),
	FOREIGN KEY (worker_id) REFERENCES worker(id)
);