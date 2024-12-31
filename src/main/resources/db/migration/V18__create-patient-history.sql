CREATE TABLE patient_history (
	id BIGINT AUTO_INCREMENT NOT NULL,
	patient_id BIGINT NOT NULL,
	worker_id BIGINT NOT NULL,
	date_admission DATETIME NOT NULL,
	date_discharge DATETIME,
	status VARCHAR(12) NOT NULL,

	PRIMARY KEY (id),
	CONSTRAINT `fk_patient_history_patient_id` FOREIGN KEY (patient_id) REFERENCES patient(id),
	CONSTRAINT `fk_patient_history_worker_id` FOREIGN KEY (worker_id) REFERENCES worker(id)
);
