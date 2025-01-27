ALTER TABLE patient ADD COLUMN email varchar(50);
UPDATE patient SET email = "rafaelrestapi+joao@gmail.com" WHERE id = 1;
UPDATE patient SET email = "rafaelrestapi+maria@gmail.com" WHERE id = 2;
ALTER TABLE patient MODIFY COLUMN email varchar(50) NOT NULL;