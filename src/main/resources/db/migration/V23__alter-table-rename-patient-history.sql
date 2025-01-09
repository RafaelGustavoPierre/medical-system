ALTER TABLE patient_history RENAME TO patient_historic;

ALTER TABLE exam_registred CHANGE COLUMN patient_history_id patient_historic_id bigint NOT NULL;
ALTER TABLE remedie_registred CHANGE COLUMN patient_history_id patient_historic_id bigint NOT NULL;
ALTER TABLE patient_record CHANGE COLUMN patient_history_id patient_historic_id bigint NOT NULL;