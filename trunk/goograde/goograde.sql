-- BluGoo's Awesome DataBase

-- Drop Tables 
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Courses;
DROP TABLE IF EXISTS Files;
DROP TABLE IF EXISTS Assignments;
DROP TABLE IF EXISTS Permissions;
DROP TABLE IF EXISTS Announcements;
DROP TABLE IF EXISTS GradingRules;
DROP TABLE IF EXISTS hasGrade;
DROP TABLE IF EXISTS teaches;
DROP TABLE IF EXISTS submitted;
DROP TABLE IF EXISTS hasPermission;
DROP TABLE IF EXISTS enrolled;
DROP TABLE IF EXISTS assists; 
DROP VIEW IF EXISTS Teachers;
DROP VIEW IF EXISTS TAs;
DROP VIEW IF EXISTS Students;

CREATE TABLE Accounts (
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		teachID integer,  /*VG wants to delete*/
		taId integer,     /*VG wants to delete*/
		studentId Integer, /*VG wants to delete*/
		
		username STRING UNIQUE ON CONFLICT ROLLBACK,
		name STRING,
		email STRING,
		password STRING,

		CONSTRAINT unique_username UNIQUE (username) ON 
			CONFLICT ROLLBACK
);

CREATE TABLE Courses (      
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		title STRING,
		department STRING,
		number INTEGER,
		section INTEGER,
		gradingRulesID INTEGER,

		CONSTRAINT fk_gradingRules FOREIGN KEY (gradingRulesID) REFERENCES 
		GradingRules (id) ON DELETE RESTRICT
);

CREATE TABLE Files (        
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

CREATE TABLE Assignments (  
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		name text,
		userId Integer
);


CREATE TABLE Permissions (  
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

CREATE TABLE Announcements (   
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		courseId INTEGER,
		title TEXT,
		post TEXT,
		datetime INTEGER
);

CREATE TABLE GradingRules (    
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		courseId INTEGER -- VG wants to delete, store in course
);

/*VG want to delete - unnecessary*/
Create Table hasGrade (        
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		userId INTEGER
);

CREATE TABLE teaches (         
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		courseId INTEGER
);

CREATE TABLE submitted (       
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		assignmentID integer,
		datetime integer
);

/*VG want to delete - unnecessary*/
Create Table hasPermission (   
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		userId INTEGER
);

CREATE TABLE enrolled (
		course INTEGER,
		student INTEGER,
		CONSTRAINT pk_enrolled PRIMARY KEY (course, student) 
			ON CONFLICT ROLLBACK,
		CONSTRAINT fk_course FOREIGN KEY (course) REFERENCES Courses
			(id) ON DELETE CASCADE,
		CONSTRAINT fk_student FOREIGN KEY (student) REFERENCES Accounts
			(id) ON DELETE CASCADE
);

CREATE TABLE assists (
		course INTEGER,
		ta INTEGER,
		CONSTRAINT pk_enrolled PRIMARY KEY (course, ta) 
			ON CONFLICT ROLLBACK,
		CONSTRAINT fk_course FOREIGN KEY (course) REFERENCES Courses
			(id) ON DELETE CASCADE,
		CONSTRAINT fk_tas FOREIGN KEY (ta) REFERENCES Accounts
			(id) ON DELETE CASCADE
);

CREATE VIEW Teachers AS
    SELECT DISTINCT teacher FROM teaches;

CREATE VIEW TAs AS
    SELECT DISTINCT ta FROM assists;

CREATE VIEW Teachers AS
    SELECT DISTINCT student FROM enrolled;

INSERT INTO Courses (title, department, number, section) 
    VALUES("Systems Programming", "CSC", "357","01");
INSERT INTO Courses (title, department, number, section) 
    VALUES("Software Engineering I", "CPE", "308","01");
INSERT INTO Courses (title, department, number, section) 
    VALUES("Software Engineering II", "CPE", "309","01");
INSERT INTO Courses (title, department, number, section) 
    VALUES("Professional responsabilities", "CSC", "300","01");
INSERT INTO Courses (title, department, number, section) 
    VALUES("Graduate Thesis", "CSC", "500","01");