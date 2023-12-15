--do HW here
DROP TABLE IF EXISTS member, interestgroup, event, member_event, member_interestgroup, event_interestgroup;

CREATE TABLE member ( 
	member_number serial PRIMARY KEY,
	first_name VARCHAR (50) NOT NULL,
	last_name VARCHAR (100) NOT NULL,
 	email_address varchar (50) NOT NULL,
	phone_number bigint,
 	date_of_birth date NOT NULL,
 	reminder_email_flag boolean
);

CREATE TABLE interestgroup (
	group_number serial PRIMARY KEY,
	group_name varchar (80) UNIQUE NOT NULL
);

CREATE TABLE event (
	event_number serial PRIMARY KEY,
	event_name varchar (80) NOT NULL,
	description varchar (100) NOT NULL,
	start_date date NOT NULL,
	start_time time NOT NULL,
	duration_in_mins int CHECK (duration_in_mins > 29)
);

CREATE TABLE member_event (
	member_number int NOT NULL,
	event_number int NOT NULL,
	CONSTRAINT pk_member_event PRIMARY KEY (member_number, event_number),
	CONSTRAINT fk_member_number FOREIGN KEY (member_number) REFERENCES member (member_number),
	CONSTRAINT fk_event_number FOREIGN KEY (event_number) REFERENCES event(event_number)
);

CREATE TABLE member_interestgroup (
	member_number int NOT NULL,
	group_number int NOT NULL,
	CONSTRAINT pk_member_interestgroup PRIMARY KEY (member_number, group_number),
	CONSTRAINT fk_member_number FOREIGN KEY (member_number) REFERENCES member (member_number),
	CONSTRAINT fk_group_number FOREIGN KEY (group_number) REFERENCES interestgroup(group_number)
);

CREATE TABLE event_interestgroup (
	event_number int NOT NULL,
	group_number int NOT NULL,
	CONSTRAINT pk_event_interestgroup PRIMARY KEY (event_number, group_number),
	CONSTRAINT fk_event_number FOREIGN KEY (event_number) REFERENCES event(event_number),
	CONSTRAINT fk_group_number FOREIGN KEY (group_number) REFERENCES interestgroup(group_number)
);

--SELECT * FROM event
INSERT INTO event (event_name, description, start_date, start_time, duration_in_mins)
VALUES ('5k Race', 'Race that is 5k', '2023-10-20', '09:00:00', 30);
INSERT INTO event (event_name, description, start_date, start_time, duration_in_mins)
VALUES ('4k Race', 'Race that is 4k', '2023-10-21', '09:00:00', 30);
INSERT INTO event (event_name, description, start_date, start_time, duration_in_mins)
VALUES ('3k Race', 'Race that is 3k', '2023-10-22', '09:00:00', 30);
INSERT INTO event (event_name, description, start_date, start_time, duration_in_mins)
VALUES ('2k Race', 'Race that is 2k', '2023-10-23', '09:00:00', 30);

INSERT INTO interestgroup (group_name)
VALUES ('Running Sucks');
INSERT INTO interestgroup (group_name)
VALUES ('Run 4 Life');
INSERT INTO interestgroup (group_name)
VALUES ('Walkers Anonymous');

	

INSERT INTO member (first_name, last_name, email_address, date_of_birth, reminder_email_flag)
VALUES ('Bill', 'Smith', 'bsmith@gmail.com', '2000-01-01', True);
INSERT INTO member (first_name, last_name, email_address, date_of_birth, reminder_email_flag)
VALUES ('Will', 'Smith', 'wsmith@gmail.com', '2000-01-02', false);
INSERT INTO member (first_name, last_name, email_address, date_of_birth, reminder_email_flag)
VALUES ('Greg', 'Smith', 'gsmith@gmail.com', '2000-02-02', false);
INSERT INTO member (first_name, last_name, email_address, date_of_birth, reminder_email_flag)
VALUES ('Alice', 'Smith', 'asmith@gmail.com', '1932-02-02', false);
INSERT INTO member (first_name, last_name, email_address, date_of_birth, reminder_email_flag)
VALUES ('Dale', 'Smith', 'dsmith@gmail.com', '1952-02-12', false);
INSERT INTO member (first_name, last_name, email_address, date_of_birth, reminder_email_flag)
VALUES ('Heidi', 'Smith', 'hsmith@gmail.com', '1953-06-12', false);
INSERT INTO member (first_name, last_name, email_address, date_of_birth, reminder_email_flag)
VALUES ('Stacie', 'Smith', 'ssmith@gmail.com', '1975-01-12', false);
INSERT INTO member (first_name, last_name, email_address, date_of_birth, reminder_email_flag)
VALUES ('Zoey', 'Smith', 'zsmith@gmail.com', '1975-11-19', false);

INSERT INTO member_event (member_number, event_number)
VALUES (1,1);
INSERT INTO member_event (member_number, event_number)
VALUES (2,2);
INSERT INTO member_event (member_number, event_number)
VALUES (3,3);
INSERT INTO member_event (member_number, event_number)
VALUES (4,4);

INSERT INTO member_interestgroup (member_number, group_number)
VALUES (1,1);
INSERT INTO member_interestgroup (member_number, group_number)
VALUES (2,1);
INSERT INTO member_interestgroup (member_number, group_number)
VALUES (3,2);
INSERT INTO member_interestgroup (member_number, group_number)
VALUES (4,2);
INSERT INTO member_interestgroup (member_number, group_number)
VALUES (5,3);
INSERT INTO member_interestgroup (member_number, group_number)
VALUES (6,3);
	
INSERT INTO event_interestgroup (event_number, group_number)
VALUES (1,1);
INSERT INTO event_interestgroup (event_number, group_number)
VALUES (2,2);
INSERT INTO event_interestgroup (event_number, group_number)
VALUES (3,3);
INSERT INTO event_interestgroup (event_number, group_number)
VALUES (4,3);

-- SELECT member.first_name, interestgroup.group_name FROM member
-- JOIN member_interestgroup ON member.member_number = member_interestgroup.member_number
-- JOIN interestgroup ON interestgroup.group_number = member_interestgroup.group_number;