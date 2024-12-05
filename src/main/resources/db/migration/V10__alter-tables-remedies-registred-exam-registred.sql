ALTER TABLE remedie_registred CHANGE patient_historic_id patient_id bigint NOT NULL;
ALTER TABLE exam_registred CHANGE patient_historic_id patient_id bigint NOT NULL;

ALTER TABLE remedie_registred DROP FOREIGN KEY remedie_registred_ibfk_2;
ALTER TABLE remedie_registred ADD CONSTRAINT fk_remedie_registred_patient_id  FOREIGN KEY (patient_id) REFERENCES patient(id);

ALTER TABLE exam_registred  DROP FOREIGN KEY exam_registred_ibfk_2;
ALTER TABLE exam_registred ADD CONSTRAINT fk_exam_registred_patient_id FOREIGN KEY (patient_id) REFERENCES patient(id);

DROP TABLE patient_historic ;