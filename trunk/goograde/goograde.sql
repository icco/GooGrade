-- BluGoo's Awesome DataBase

-- Drop Tables & Views
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Courses;
DROP TABLE IF EXISTS Files;
DROP TABLE IF EXISTS Assignments;
DROP TABLE IF EXISTS Permissions;
DROP TABLE IF EXISTS Announcements;
DROP TABLE IF EXISTS GradingRules;
DROP TABLE IF EXISTS Grades;
DROP TABLE IF EXISTS hasGrade;
DROP TABLE IF EXISTS teaches;
DROP TABLE IF EXISTS submitted;
DROP TABLE IF EXISTS hasPermission;
DROP TABLE IF EXISTS enrolled;
DROP TABLE IF EXISTS assists; 
DROP VIEW IF EXISTS Teachers;
DROP VIEW IF EXISTS TAs;
DROP VIEW IF EXISTS Students;

/* entity table for Account class */
CREATE TABLE Accounts (
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		username STRING UNIQUE ON CONFLICT ROLLBACK,
		name STRING,
		email STRING,
		password STRING,

		CONSTRAINT unique_username UNIQUE (username) ON 
			CONFLICT ROLLBACK
);

/* entity table for Course class */
CREATE TABLE Courses (      
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		title STRING,
		department STRING,
		number INTEGER,
		section INTEGER,
		gradingRulesId INTEGER,

		CONSTRAINT fk_gradingRules FOREIGN KEY (gradingRulesID) REFERENCES 
		GradingRules (id) ON DELETE RESTRICT
);

/* entity table for File class */
CREATE TABLE Files (        
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

/* entity table for Assignment class */
CREATE TABLE Assignments (  
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		name text,
		userId Integer
);

/* 
 * entity table for Permission class 
 * ... This needs some other stuff...
 */
CREATE TABLE Permissions (  
		id INTEGER PRIMARY KEY AUTOINCREMENT

);

/* entity table for Announcement class */
CREATE TABLE Announcements (   
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		courseId INTEGER,
		title TEXT,
		post TEXT,
		datetime INTEGER
);

/* entity table for GradingRules class */
CREATE TABLE GradingRules (    
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

/* TODO, how to store Grades in database <<---------------!!!!!*/
CREATE TABLE Grades (
                id INTEGER PRIMARY KEY AUTOINCREMENT
);

/* relation table between Accounts & Grades */
Create Table hasGrade (        
		account INTEGER,
		grade INTEGER,
		CONSTRAINT pk_hasGrade PRIMARY KEY (account, grade),
		CONSTRAINT fk_account FOREIGN KEY (account) REFERENCES Accounts
			(id) ON DELETE CASCADE,
		CONSTRAINT fk_grade FOREIGN KEY (grade) REFERENCES Grades
			(id) ON DELETE CASCADE
);

/* relation table between Accounts & Files */
CREATE TABLE submitted (       
		account INTEGER,
		file INTEGER,
		CONSTRAINT pk_submitted PRIMARY KEY (account, file),
		CONSTRAINT fk_account FOREIGN KEY (account) REFERENCES Accounts
			(id) ON DELETE CASCADE,
		CONSTRAINT fk_file FOREIGN KEY (file) REFERENCES Files
			(id) ON DELETE CASCADE
);

/* relation table between Accounts & Permissions */
Create Table hasPermission (   
		account INTEGER,
		permissions INTEGER,
		CONSTRAINT pk_hasPermission PRIMARY KEY (account, permissions),
		CONSTRAINT fk_account FOREIGN KEY (account) REFERENCES Accounts
			(id) ON DELETE CASCADE,
		CONSTRAINT fk_permissions FOREIGN KEY (permissions) REFERENCES Permissions
			(id) ON DELETE CASCADE
);

/* relation table between Accounts (teachers) & Courses */
CREATE TABLE teaches (         
		course INTEGER,
		teacher INTEGER,
		CONSTRAINT pk_teaches PRIMARY KEY (course, teacher),
		CONSTRAINT fk_course FOREIGN KEY (course) REFERENCES Courses
			(id) ON DELETE CASCADE,
		CONSTRAINT fk_teacher FOREIGN KEY (teacher) REFERENCES Accounts
			(id) ON DELETE CASCADE
);

/* relation table between Accounts (students) & Courses */
CREATE TABLE enrolled (
		course INTEGER,
		student INTEGER,
		CONSTRAINT pk_enrolled PRIMARY KEY (course, student),
		CONSTRAINT fk_course FOREIGN KEY (course) REFERENCES Courses
			(id) ON DELETE CASCADE,
		CONSTRAINT fk_student FOREIGN KEY (student) REFERENCES Accounts
			(id) ON DELETE CASCADE
);

/* relation table between Account (tas) & Courses */
CREATE TABLE assists (
		course INTEGER,
		ta INTEGER,
		CONSTRAINT pk_enrolled PRIMARY KEY (course, ta),
		CONSTRAINT fk_course FOREIGN KEY (course) REFERENCES Courses
			(id) ON DELETE CASCADE,
		CONSTRAINT fk_tas FOREIGN KEY (ta) REFERENCES Accounts
			(id) ON DELETE CASCADE
);

/* View of all teacher ids*/
CREATE VIEW Teachers AS
    SELECT DISTINCT teacher as id FROM teaches;

/* View of all ta ids*/
CREATE VIEW TAs AS
    SELECT DISTINCT ta as id FROM assists;

/* View of all student ids*/
CREATE VIEW Students AS
    SELECT DISTINCT student as id FROM enrolled;

