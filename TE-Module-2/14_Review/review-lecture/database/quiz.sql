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
INSERT INTO question(question)
VALUES('What are the 3 pillar principles of OOP and give an example of their usage.'),
('What is Mutability?'),('Why is String immutable?'),
('What is the difference between Primitive types vs Reference types?'),
('Explain the difference in how they use the Stack and Heap memory spaces.'),
('Explain == vs .equals'),
('Class vs Objects?'),
('Explain why Getters and Setters are important'),
('What is an Interface vs Superclasses and why you would use each?'),
('Abstract classes - define what they are and when to use them, also why might you choose an abstract class over an interface/superclass combination?'),
('Talk about Abstract methods'),
('Write one and discuss each of the 4 parts of a method signature.'), 
('null - what it is and why it is different than empty'),
('What is scope, and when it is appropriate to use each scope?'),
('Private vs Public vs Protected'),
('What is the default scope for a method, if not defined? Why is it different than protected?'),
('What is a Package?'),
('Explain the difference and when each occurs and how you can handle each for compile time errors and runtime vs checked exceptions .'),
('try...catch...finally - explain'),
('Parts of a for statement.'),
('What is the difference between break and continue in a for loop?'),
('What is a constructor?'),
('Explain what static methods are, how to use them, and why you would make a method static.'),
('Explain static variables and why you would use them.'),
('Explain final methods, classes, and variable what it means for each and why you would use it.'),
('SQL Joins - talk about each type both with a Venn diagram and with tables.'),
('Explain and model SQL relationships (one-to-one, one-to-many, many-to-many)'),
('What is The SQL GROUP BY clause and how does it work?'),
('Describe each part of the SQL syntax (DML, DDL, and DCL), what each does, and give a few examples of commands from each.'),
('Dependency Injection - explain it and why you would use it.'),
('Loose Coupling - what it is and why it is important.'),
('String - what is special about it? why? Is it a value or reference type?'),
('Arrays vs Collections'), 
('How to use a Map (Java)'),
('The difference between a Framework and a library'),
('Software Development Life-cycle (especially Agile workflow)'),
('Unit testing - be able to describe it, why it is important, what advantages it gives, why it speeds up development time, and the differences between it and integration testing.'),
('What is pair programming, how is it done and why is it used?'), ('Test Driven Development -what is the workflow?'),  
('Stack vs Queue - be prepared to describe the order of each and give examples of when you might use them.');

INSERT INTO student (student_name) VALUES ('Aaron');
INSERT INTO student (student_name) VALUES ('Abdulkadir');
INSERT INTO student (student_name) VALUES ('Aidan');
INSERT INTO student (student_name) VALUES ('Anisa');
INSERT INTO student (student_name) VALUES ('Benjamin');
INSERT INTO student (student_name) VALUES ('Christian');
INSERT INTO student (student_name) VALUES ('David');
INSERT INTO student (student_name) VALUES ('Jack');
INSERT INTO student (student_name) VALUES ('Kayla');
INSERT INTO student (student_name) VALUES ('Leul');
INSERT INTO student (student_name) VALUES ('Max');
INSERT INTO student (student_name) VALUES ('Niko');
INSERT INTO student (student_name) VALUES ('Rafael');
INSERT INTO student (student_name) VALUES ('Roland');
INSERT INTO student (student_name) VALUES ('Salahdin');
INSERT INTO student (student_name) VALUES ('Stephen F');
INSERT INTO student (student_name) VALUES ('Steven R');