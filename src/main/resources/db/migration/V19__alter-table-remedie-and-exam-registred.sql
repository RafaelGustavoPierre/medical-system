ALTER TABLE remedie_registred ADD COLUMN patient_history_id BIGINT;
ALTER TABLE exam_registred ADD COLUMN patient_history_id BIGINT;

ALTER TABLE remedie_registred ADD CONSTRAINT `fk_patient_history_remedie_registred_id` FOREIGN KEY (patient_history_id) REFERENCES patient_history(id);
ALTER TABLE exam_registred ADD CONSTRAINT `fk_patient_history_exam_registred_id` FOREIGN KEY (patient_history_id) REFERENCES patient_history(id);