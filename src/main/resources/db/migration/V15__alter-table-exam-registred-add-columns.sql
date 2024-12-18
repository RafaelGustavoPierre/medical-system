ALTER TABLE exam_registred ADD COLUMN worker_id BIGINT NOT NULL;

UPDATE exam_registred SET worker_id = 4 WHERE id = 1;
UPDATE exam_registred SET worker_id = 4 WHERE id = 2;

ALTER TABLE exam_registred ADD CONSTRAINT fk_exam_registred_worker_id FOREIGN KEY (worker_id) REFERENCES worker(id);