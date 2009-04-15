DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS does;

CREATE TABLE tasks (
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		startDate INTEGER NOT NULL,
		dueDate INTEGER,
		what STRING NOT NULL
		);

CREATE TABLE users (
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		name STRING NOT NULL,
		email STRING
		);

CREATE TABLE does (
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		tasks_id INTEGER NOT NULL,
	        users_id INTEGER NOT NULL
		);	

INSERT INTO users (name, email) VALUES ("Nat Welch", "nwelch@calpoly.edu");
INSERT INTO users (name, email) VALUES ("Viktor Gerdin", "vgerdin@calpoly.edu");
INSERT INTO users (name, email) VALUES ("Matt Duder", "mduder@calpoly.edu");
INSERT INTO users (name, email) VALUES ("Kat Blizard", "kblizard@calpoly.edu");
INSERT INTO users (name, email) VALUES ("Paul Phu", "pphu@calpoly.edu");

INSERT INTO tasks (startDate, dueDate, what) VALUES (date('now'), NULL, "Eat shit and compile");
INSERT INTO tasks (startDate, dueDate, what) VALUES (date('now'), date('now','+1 month'), "Beat up Paul");

INSERT INTO does (tasks_id, users_id) VALUES (5,1);
INSERT INTO does (tasks_id, users_id) VALUES (1,2);
INSERT INTO does (tasks_id, users_id) VALUES (2,2);
INSERT INTO does (tasks_id, users_id) VALUES (3,2);
INSERT INTO does (tasks_id, users_id) VALUES (4,2);
INSERT INTO does (tasks_id, users_id) VALUES (5,2);
