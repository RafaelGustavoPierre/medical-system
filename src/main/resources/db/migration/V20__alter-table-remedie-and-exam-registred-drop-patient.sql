ALTER TABLE remedie_registred DROP FOREIGN KEY `fk_remedie_registred_patient_id`;
ALTER TABLE remedie_registred DROP COLUMN patient_id;

ALTER TABLE exam_registred DROP FOREIGN KEY `fk_exam_registred_patient_id`;
ALTER TABLE exam_registred DROP COLUMN patient_id;
