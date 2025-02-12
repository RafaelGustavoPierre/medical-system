SET time_zone = '-03:00';

set FOREIGN_KEY_CHECKS = 0;
DELETE FROM exam_registred;
DELETE FROM remedie_registred;
DELETE FROM patient_historic;

set FOREIGN_KEY_CHECKS = 1;
ALTER TABLE exam_registred AUTO_INCREMENT = 1;
ALTER TABLE remedie_registred  AUTO_INCREMENT = 1;
ALTER TABLE patient_historic AUTO_INCREMENT = 1;