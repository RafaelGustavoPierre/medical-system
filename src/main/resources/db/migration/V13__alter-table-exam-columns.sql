INSERT INTO department (id, name) VALUES (3, "Pathology");
ALTER TABLE exam ADD COLUMN department_id BIGINT NOT NULL;

UPDATE exam SET department_id = 3 WHERE id = 1;
UPDATE exam SET department_id = 3 WHERE id = 2;
UPDATE exam SET department_id = 2 WHERE id = 3;
UPDATE exam SET department_id = 2 WHERE id = 4;

ALTER TABLE exam
ADD CONSTRAINT fk_exam_department_id
FOREIGN KEY (department_id) REFERENCES department(id);