ALTER TABLE patient_record DROP FOREIGN KEY `patient_record_ibfk_1`;
ALTER TABLE patient_record DROP COLUMN patient_id;

ALTER TABLE patient_record ADD COLUMN patient_history_id BIGINT NOT NULL;

DELETE FROM patient_record;
ALTER TABLE patient_record ADD CONSTRAINT `fk_patient_history_patient_record_id` FOREIGN KEY (patient_history_id) REFERENCES patient_history(id);