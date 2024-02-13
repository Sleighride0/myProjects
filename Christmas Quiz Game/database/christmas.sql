BEGIN TRANSACTION;

DROP TABLE IF EXISTS quiz, question, quiz_question, game_user, user_quiz; 
DROP SEQUENCE IF EXISTS seq_user_id, seq_quiz_id;
--trial new connection


CREATE TABLE quiz (
	quiz_id serial NOT NULL, 
	quiz_name varchar(50) NOT NULL,
	CONSTRAINT PK_quiz PRIMARY KEY (quiz_id)
);

CREATE TABLE question (
	question_id serial NOT NULL,
	question_posed varchar(100) NOT NULL,
	option_a varchar (50) NOT NULL,
	option_b varchar (50) NOT NULL,
	option_c varchar (50) NOT NULL,
	option_d varchar (50) NOT NULL,
	correct_answer varchar(10) NOT NULL,
	CONSTRAINT PK_question_id PRIMARY KEY (question_id)
);
INSERT INTO quiz (quiz_name) VALUES ('Normal Quiz');


CREATE SEQUENCE seq_quiz_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE;
  
CREATE TABLE game_user (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200) NOT NULL,
	normal_quiz_high_score int DEFAULT 0,
	hard_quiz_high_score int DEFAULT 0,
	CONSTRAINT PK_game_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE TABLE user_quiz (
	user_id int NOT NULL, 
	quiz_id int NOT NULL,
	quiz_high_score int DEFAULT 0,
	CONSTRAINT PK_user_id PRIMARY KEY (user_id),
	CONSTRAINT FK_user_quiz_user_id FOREIGN KEY (user_id) REFERENCES game_user (user_id),
	CONSTRAINT FK_user_quiz_quiz_id FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id)
);

CREATE TABLE quiz_question (
   quiz_id int NOT NULL, 
   question_id int NOT NULL,
   CONSTRAINT FK_quiz_question_quiz_id FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id),
   CONSTRAINT FK_quiz_question_question_id FOREIGN KEY (question_id) REFERENCES question (question_id),
   CONSTRAINT PK_quiz_question PRIMARY KEY (quiz_id, question_id)  -- Use a composite primary key
);

INSERT INTO question (question_posed, option_a, option_b, option_c, option_d, correct_answer) VALUES ('What gift was given on the fifth day of Christmas: ', 'turtle doves','swans', 'golden rings', 'coal', 'C');
INSERT INTO question (question_posed, option_a, option_b, option_c, option_d, correct_answer) VALUES ('Who did Michael Jackson say he saw mommy kissing?: ', 'The Grinch','Her cat', 'Santa Claus', 'Rudolph', 'C');
INSERT INTO question (question_posed, option_a, option_b, option_c, option_d, correct_answer) VALUES ('In the song Sleigh Ride, who hosted a christmas party: ', 'Preacher John','Tiny Tim', 'Parson Brown', 'Farmer Gray', 'D');
INSERT INTO question (question_posed, option_a, option_b, option_c, option_d, correct_answer) VALUES ('White Christmas stars Bing Crosby as: ', 'Benny Hanes','Phil Davis', 'John Cherry', 'Bob Wallace', 'D');
INSERT INTO question (question_posed, option_a, option_b, option_c, option_d, correct_answer) VALUES ('What are the first words Frosty the Snowman says: ', 'Am I Alive?','Happy Birthday', 'Merry Christmas', 'Thank you little girl', 'B');
INSERT INTO question (question_posed, option_a, option_b, option_c, option_d, correct_answer) VALUES ('What event wouldnt the other reindeer let Rudolph join: ', 'Santas sled race','Reindeer Games', 'Christmas Dinner', 'Reindeer race', 'B');




INSERT INTO quiz_question (quiz_id, question_id) VALUES (1,1);
INSERT INTO quiz_question (quiz_id, question_id) VALUES (1,2);
INSERT INTO quiz_question (quiz_id, question_id) VALUES (1,3);
INSERT INTO quiz_question (quiz_id, question_id) VALUES (1,4);
INSERT INTO quiz_question (quiz_id, question_id) VALUES (1,5);
INSERT INTO quiz_question (quiz_id, question_id) VALUES (1,6);




-- CREATE TABLE transfer (
-- 	transfer_id int NOT NULL DEFAULT nextval('seq_transfer_id'),
-- 	transfer_type_id int NOT NULL,
-- 	transfer_status_id int NOT NULL,
-- 	account_from int NOT NULL,
-- 	account_to int NOT NULL,
-- 	amount decimal(13, 2) NOT NULL,
-- 	CONSTRAINT PK_transfer PRIMARY KEY (transfer_id),
-- 	CONSTRAINT FK_transfer_account_from FOREIGN KEY (account_from) REFERENCES account (account_id),
-- 	CONSTRAINT FK_transfer_account_to FOREIGN KEY (account_to) REFERENCES account (account_id),
-- 	CONSTRAINT FK_transfer_transfer_status FOREIGN KEY (transfer_status_id) REFERENCES transfer_status (transfer_status_id),
-- 	CONSTRAINT FK_transfer_transfer_type FOREIGN KEY (transfer_type_id) REFERENCES transfer_type (transfer_type_id),
-- 	CONSTRAINT CK_transfer_not_same_account CHECK (account_from <> account_to),
-- 	CONSTRAINT CK_transfer_amount_gt_0 CHECK (amount > 0)
-- );

-- INSERT INTO transfer_status (transfer_status_desc) VALUES ('Pending');
-- INSERT INTO transfer_status (transfer_status_desc) VALUES ('Approved');
-- INSERT INTO transfer_status (transfer_status_desc) VALUES ('Rejected');

-- INSERT INTO transfer_type (transfer_type_desc) VALUES ('Request');
-- INSERT INTO transfer_type (transfer_type_desc) VALUES ('Send');

COMMIT;
