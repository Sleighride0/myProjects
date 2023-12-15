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
	role varchar(20) DEFAULT 'USER',
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
	asked boolean DEFAULT false,
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

INSERT INTO question(question_text) VALUES ('What is the purpose of the public static void main(String[] args) method in a Java program, and why is it important?');
INSERT INTO answer(answer_text) VALUES ('It is used to declare variables in a Java program, allowing data to be stored and manipulated.'), (' It is responsible for input/output operations, such as reading from the keyboard and displaying information on the screen.'),
('It is the entry point of a Java program and is required for the program to run. It serves as the starting point for the execution of the program.'),
('It is a user-defined method that is called when specific conditions are met during program execution.');
INSERT INTO question_answer(question_id,answer_id) VALUES (2001,3003);

INSERT INTO question(question_text) VALUES ('In Java, what is the fundamental difference between primitive data types and reference data types, and can you provide examples of each?');
INSERT INTO answer(answer_text) VALUES ('Primitive data types store the actual data values, while reference data types store references or memory addresses to objects. For example, int is a primitive data type, and String is a reference data type.'),
('Primitive data types are used for objects and classes, while reference data types are used for fundamental data types like integers and floating-point numbers. For example, String is a primitive data type, and int is a reference data type.'),
('Primitive data types are used for both data values and references to objects, while reference data types are exclusively for objects. For example, int and String are both primitive data types.'),
('There is no difference between primitive and reference data types in Java, and the terms are used interchangeably.');
INSERT INTO question_answer(question_id,answer_id) VALUES (2002,3005);

INSERT INTO question(question_text) VALUES ('What is an array in Java, and how do you declare and initialize a one-dimensional array with five integer elements?');
INSERT INTO answer(answer_text) VALUES ('An array in Java is a collection of key-value pairs. To declare and initialize a one-dimensional array with five integer elements, you use the new Array(5) statement.'),
('An array in Java is an ordered collection of elements of the same data type. To declare and initialize a one-dimensional array with five integer elements, you use the following statement: int[] myArray = {1, 2, 3, 4, 5};.'),
('An array in Java is a data structure that can hold multiple data elements of different types. To declare and initialize a one-dimensional array with five integer elements, you use the ArrayList class.'),
('An array in Java is a special data type for storing characters. To declare and initialize a one-dimensional array with five integer elements, you use the charArray class.');
INSERT INTO question_answer(question_id,answer_id) VALUES(2003,3010);


COMMIT;
SELECT * FROM quiz_user;