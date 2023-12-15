BEGIN TRANSACTION;

DROP TABLE IF EXISTS question, student;
CREATE TABLE question(
	question_id SERIAL PRIMARY KEY,
	question text,
	asked boolean default false
);
CREATE TABLE student(
	student_id SERIAL,
	student_name varchar(100),
	asked boolean default false
);

INSERT INTO question(question) VALUE ('Q1'); --question_id = 1
INSERT INTO question(question,asked) VALUE ('Q2',true); --question_id = 2
INSERT INTO question(question) VALUE ('Q3'); --question_id = 3

INSERT INTO student(student_name,asked) VALUE ('AA', true)  --student_id = 1
INSERT INTO student(student_name) VALUE ('BB') --student_id = 2
INSERT INTO student(student_name) VALUE ('CC');  --student_id = 3

COMMIT;