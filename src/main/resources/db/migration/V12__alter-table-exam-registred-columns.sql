ALTER TABLE exam_registred RENAME COLUMN time_registred TO start_time;
ALTER TABLE exam_registred ADD COLUMN end_time datetime;