BEGIN TRANSACTION;

DROP TABLE IF EXISTS quiz_user, question, answer, question_answer, quiz, quiz_question;
DROP SEQUENCE IF EXISTS seq_user_id, seq_question_id, seq_answer_id, seq_quiz_id;


CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE quiz_user (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(20),
	CONSTRAINT PK_quiz_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE SEQUENCE seq_question_id
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE;

CREATE TABLE question (
	question_id int NOT NULL DEFAULT nextval('seq_question_id'),
	question_text text NOT NULL,
	CONSTRAINT PK_question PRIMARY KEY (question_id)
);

CREATE SEQUENCE seq_answer_id
  INCREMENT BY 1
  START WITH 3001
  NO MAXVALUE;

CREATE TABLE answer (
	answer_id int NOT NULL DEFAULT nextval('seq_answer_id'),
	answer_text text NOT NULL,
	CONSTRAINT PK_answer PRIMARY KEY (answer_id)
);

CREATE TABLE question_answer(
	question_id int NOT NULL,
	answer_id int NOT NULL,
	CONSTRAINT PK_question_answer PRIMARY KEY (question_id, answer_id),
	CONSTRAINT FK_question_id FOREIGN KEY (question_id) REFERENCES question(question_id),
	CONSTRAINT FK_answer_id FOREIGN KEY (answer_id) REFERENCES answer(answer_id)
);

CREATE SEQUENCE seq_quiz_id
  INCREMENT BY 1
  START WITH 4001
  NO MAXVALUE;

CREATE TABLE quiz (
	quiz_id int NOT NULL DEFAULT nextval('seq_quiz_id'),
	title varchar(255) NOT NULL,
	user_id int NOT NULL,
	is_public boolean DEFAULT true,
	CONSTRAINT PK_quiz PRIMARY KEY (quiz_id),
	CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES quiz_user(user_id)
);

CREATE TABLE quiz_question(
	question_id int NOT NULL,
	quiz_id int NOT NULL,
	CONSTRAINT FK_question_id FOREIGN KEY (question_id) REFERENCES question(question_id),
	CONSTRAINT FK_quiz_id FOREIGN KEY (quiz_id) REFERENCES quiz(quiz_id)
);
--need to add INSERTS for user
COMMIT;
