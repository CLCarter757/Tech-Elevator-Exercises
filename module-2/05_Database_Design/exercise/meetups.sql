
DROP TABLE event_member, interest_group_members, "member", email, phone_number, "event", interest_group;

CREATE TABLE interest_group
(
	group_id SERIAL PRIMARY KEY,
	group_name VARCHAR(100) UNIQUE
);

CREATE TABLE "event"
(
	event_id SERIAL PRIMARY KEY,
	group_id INTEGER,
	event_name VARCHAR(100),
	description TEXT,
	start_date DATE,
	start_time TIME,
	duration_minutes INTEGER CHECK (duration_minutes > 30),
	
	CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES interest_group(group_id)
);

CREATE TABLE phone_number
(
	phone_id SERIAL PRIMARY KEY,
	phone_number VARCHAR(10) NULL,
	
	CONSTRAINT uq_phone_number UNIQUE (phone_number),
	CONSTRAINT chk_phone_number CHECK (phone_number ~ '[0-9]{10}')
);

CREATE TABLE email
(
	email_id SERIAL PRIMARY KEY,
	email_address VARCHAR(30) UNIQUE,
	reminder_email BOOLEAN
);

CREATE TABLE "member"
(
	member_id SERIAL PRIMARY KEY,
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	email_id INTEGER,
	phone_id INTEGER,
	date_of_birth DATE,
	
	CONSTRAINT fk_phone_id FOREIGN KEY (phone_id) REFERENCES phone_number (phone_id),
	CONSTRAINT fk_email_id FOREIGN KEY (email_id) REFERENCES email(email_id)
);

CREATE TABLE interest_group_members
(
	group_id INTEGER,
	member_id INTEGER,
	
	CONSTRAINT pk_group_id_member_id PRIMARY KEY (group_id, member_id),
	CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES interest_group(group_id),
	CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES "member"(member_id)
);

CREATE TABLE event_member
(
	event_id INTEGER,
	member_id INTEGER,
	
	CONSTRAINT pk_event_id_member_id PRIMARY KEY (event_id, member_id),
	CONSTRAINT fk_event_id FOREIGN KEY (event_id) REFERENCES "event"(Event_id),
	CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES "member"(member_id)
);

		
INSERT INTO interest_group (group_name)
VALUES ('NFL'), ('Coding'), ('Weddings')
;

INSERT INTO "event" (group_id, event_name, description, start_date, start_time, duration_minutes)
VALUES ((SELECT group_id FROM interest_group WHERE group_name = 'NFL'), 'Super Bowl LV', 
			'Kansas City Chiefs vs. Tampa Bay Buccaneers', '2021-02-17', '18:30:00', '200'),
		((SELECT group_id FROM interest_group WHERE group_name = 'NFL'), 'Super Bowl LVI', 
		 	'Los Angeles Rams vs. Cincinnati Bengals', '2022-02-13', '18:30:00', '240'),
		((SELECT group_id FROM interest_group WHERE group_name = 'Coding'), 'CoderCon', 
		 	'Software developer networking event', '2022-03-01', '19:00:00', '90'),
		((SELECT group_id FROM interest_group WHERE group_name = 'Weddings'), 'Clint & Sarah''s Wedding', 
		 	'Join Clint & Sarah in Belize for their wedding!', '2020-02-29', '16:00:00', '60')
;


INSERT INTO phone_number (phone_number)
VALUES ('7571111111'), ('7752222222'), ('7573333333'), ('7274444444'), 
		('6171212121'), ('2259999999'), ('2065555555'), ('6507777777')
;
		
INSERT INTO email (email_address, reminder_email)
VALUES ('clint@gmail.com', TRUE), ('sarah@yahoo.com', FALSE), ('patrick@hotmail.com', FALSE), ('david@aol.com', TRUE), 
		('goat@google.com', TRUE), ('joecool@yahoo.com', FALSE), ('notthatgosling@java.com', TRUE), ('downseteich@aol.com', FALSE)
;

INSERT INTO "member" (first_name, last_name, email_id, phone_id, date_of_birth)
VALUES ('Clint', 'Carter', (SELECT email_id FROM email WHERE email_address = 'clint@gmail.com'), 
				(SELECT phone_id FROM phone_number WHERE phone_number = '7571111111'), '1989-11-03'),
				
		('Sarah', 'Thom', (SELECT email_id FROM email WHERE email_address = 'sarah@yahoo.com'), 
		 		(SELECT phone_id FROM phone_number WHERE phone_number = '7571111111'), '1989-09-20'),
				
		('Patrick', 'Carney', (SELECT email_id FROM email WHERE email_address = 'patrick@hotmail.com'), 
		 		(SELECT phone_id FROM phone_number WHERE phone_number = '7274444444'),  '1994-10-24'),
				
		('David', 'Ainley', (SELECT email_id FROM email WHERE email_address = 'david@aol.com'), 
		 		(SELECT phone_id FROM phone_number WHERE phone_number = '7573333333'), '1989-10-13'),
				
		('Tom', 'Brady', (SELECT email_id FROM email WHERE email_address = 'goat@google.com'), 
		 		(SELECT phone_id FROM phone_number WHERE phone_number = '6171212121'), '1977-08-03'),
				
		('Joe', 'Burrow', (SELECT email_id FROM email WHERE email_address = 'joecool@yahoo.com'), 
		 		(SELECT phone_id FROM phone_number WHERE phone_number = '2259999999'), '1996-12-10'),
				
		('James', 'Gosling', (SELECT email_id FROM email WHERE email_address = 'notthatgosling@java.com'), 
		 		(SELECT phone_id FROM phone_number WHERE phone_number = '2065555555'), '1955-05-19'),
				
		('Brendan', 'Eich', (SELECT email_id FROM email WHERE email_address = 'downseteich@aol.com'), 
		 		(SELECT phone_id FROM phone_number WHERE phone_number = '6507777777'), '1961-07-04')
;

INSERT INTO interest_group_members (group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE group_name = 'NFL'), 
			(SELECT member_id FROM "member" WHERE first_name = 'Clint' AND last_name = 'Carter')),
			
		((SELECT group_id FROM interest_group WHERE group_name = 'NFL'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Patrick' AND last_name = 'Carney')),
			
		((SELECT group_id FROM interest_group WHERE group_name = 'NFL'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Tom' AND last_name = 'Brady')),
			
		((SELECT group_id FROM interest_group WHERE group_name = 'NFL'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Joe' AND last_name = 'Burrow'))
;
		
INSERT INTO interest_group_members (group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE group_name = 'Coding'), 
			(SELECT member_id FROM "member" WHERE first_name = 'Clint' AND last_name = 'Carter')),

		((SELECT group_id FROM interest_group WHERE group_name = 'Coding'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'David' AND last_name = 'Ainley')),

		((SELECT group_id FROM interest_group WHERE group_name = 'Coding'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'James' AND last_name = 'Gosling')),
		
		((SELECT group_id FROM interest_group WHERE group_name = 'Coding'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Brendan' AND last_name = 'Eich'))
;
		
INSERT INTO interest_group_members (group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE group_name = 'Weddings'), 
			(SELECT member_id FROM "member" WHERE first_name = 'Clint' AND last_name = 'Carter')),

		((SELECT group_id FROM interest_group WHERE group_name = 'Weddings'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Sarah' AND last_name = 'Thom')),
		
		((SELECT group_id FROM interest_group WHERE group_name = 'Weddings'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'David' AND last_name = 'Ainley')),
		
		((SELECT group_id FROM interest_group WHERE group_name = 'Weddings'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Patrick' AND last_name = 'Carney'))
;
		
INSERT INTO event_member (event_id, member_id)
VALUES ((SELECT event_id FROM "event" WHERE event_name = 'Super Bowl LV'), 
			(SELECT member_id FROM "member" WHERE first_name = 'Clint' AND last_name = 'Carter')),
			
		((SELECT event_id FROM "event" WHERE event_name = 'Super Bowl LV'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Tom' AND last_name = 'Brady')),
			
		((SELECT event_id FROM "event" WHERE event_name = 'Super Bowl LV'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Patrick' AND last_name = 'Carney'))
;
		
INSERT INTO event_member (event_id, member_id)
VALUES ((SELECT event_id FROM "event" WHERE event_name = 'Super Bowl LVI'), 
			(SELECT member_id FROM "member" WHERE first_name = 'Sarah' AND last_name = 'Thom')),
			
		((SELECT event_id FROM "event" WHERE event_name = 'Super Bowl LVI'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Joe' AND last_name = 'Burrow'))
;
		
INSERT INTO event_member (event_id, member_id)
VALUES ((SELECT event_id FROM "event" WHERE event_name = 'CoderCon'), 
			(SELECT member_id FROM "member" WHERE first_name = 'Clint' AND last_name = 'Carter')),

		((SELECT event_id FROM "event" WHERE event_name = 'CoderCon'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'David' AND last_name = 'Ainley')),
		
		((SELECT event_id FROM "event" WHERE event_name = 'CoderCon'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'James' AND last_name = 'Gosling')),
		
		((SELECT event_id FROM "event" WHERE event_name = 'CoderCon'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Brendan' AND last_name = 'Eich'))
;
		
INSERT INTO event_member (event_id, member_id)
VALUES ((SELECT event_id FROM "event" WHERE event_name = 'Clint & Sarah''s Wedding'), 
			(SELECT member_id FROM "member" WHERE first_name = 'Clint' AND last_name = 'Carter')),

		((SELECT event_id FROM "event" WHERE event_name = 'Clint & Sarah''s Wedding'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Sarah' AND last_name = 'Thom')),
		
		((SELECT event_id FROM "event" WHERE event_name = 'Clint & Sarah''s Wedding'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'David' AND last_name = 'Ainley')),
		
		((SELECT event_id FROM "event" WHERE event_name = 'Clint & Sarah''s Wedding'), 
		 	(SELECT member_id FROM "member" WHERE first_name = 'Patrick' AND last_name = 'Carney'))
;
		
