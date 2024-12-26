ALTER TABLE patient_record ADD COLUMN observation VARCHAR(255);
INSERT INTO patient_record (patient_id, worker_id, observation) VALUES (1, 1, "Reclamação de dor no no pâncreas");