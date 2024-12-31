ALTER TABLE patient_record DROP FOREIGN KEY `patient_record_ibfk_1`;
ALTER TABLE patient_record DROP COLUMN patient_id;

ALTER TABLE patient_record ADD COLUMN patient_history_id BIGINT NOT NULL;

DELETE FROM patient_record;
INSERT INTO patient_record (worker_id, observation, patient_history_id) VALUES (3, "Reclamação de dor no pãncreas!", 1);
INSERT INTO patient_record (worker_id, observation, patient_history_id) VALUES (2, "Paciente reclamando de náusea e desequilíbrio!", 2);

ALTER TABLE patient_record ADD CONSTRAINT `fk_patient_history_patient_record_id` FOREIGN KEY (patient_history_id) REFERENCES patient_history(id);