INSERT INTO quiz(title,user_id)VALUES ('quiz 1', (SELECT user_id FROM quiz_user WHERE username = 'user1'));
INSERT INTO quiz(title,user_id)VALUES ('quiz 2', (SELECT user_id FROM quiz_user WHERE username = 'user2'));

INSERT INTO quiz_question(question_id, quiz_id) VALUES (2001,4001);
INSERT INTO quiz_question(question_id, quiz_id) VALUES (2002,4001);
INSERT INTO quiz_question(question_id, quiz_id) VALUES (2003,4001);

INSERT INTO quiz_question(question_id, quiz_id) VALUES (2001,4002);
INSERT INTO quiz_question(question_id, quiz_id) VALUES (2002,4002);
INSERT INTO quiz_question(question_id, quiz_id) VALUES (2003,4002);