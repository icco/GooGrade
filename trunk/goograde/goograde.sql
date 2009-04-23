-- BluGoo's Awesome DataBase

-- Drop Tables 
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Courses;
DROP TABLE IF EXISTS Teachers; --VG remove
DROP TABLE IF EXISTS TAs; --VG remove
DROP TABLE IF EXISTS Students;
DROP TABLE IF EXISTS Files;
DROP TABLE IF EXISTS Assignments;
DROP TABLE IF EXISTS Passwords; --VG remove
DROP TABLE IF EXISTS Permissions;
DROP TABLE IF EXISTS EmailAddresses; --VG remove
DROP TABLE IF EXISTS Announcements; --VG remove
DROP TABLE IF EXISTS GradingRules;
DROP TABLE IF EXISTS hasGrade; --VG remove
DROP TABLE IF EXISTS teaches;
DROP TABLE IF EXISTS submitted;
DROP TABLE IF EXISTS hasPermission; --VG remove
DROP TABLE IF EXISTS hasPW; --VG remove
DROP TABLE IF EXISTS hasEmailAddr; --VG remove
DROP TABLE IF EXISTS hasAddr; --VG remove
DROP TABLE IF EXISTS todo; --VG remove
DROP TABLE IF EXISTS enrolled;
DROP TABLE IF EXISTS assists; 

CREATE TABLE Accounts (
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		teachID integer,  /*VG wants to delete*/
		taId integer,     /*VG wants to delete*/
		studentId Integer, /*VG wants to delete*/
		
		username STRING UNIQUE ON CONFLICT ROLLBACK,
		name STRING,
		email STRING,
		password STRING,
		/*
		level STRING, --"teacher", "ta" or "student" so we can remove two tables
		*/
		/*
		CONSTRAINT pk_accounts PRIMARY KEY (id) ON CONFLICT ROLLBACK
			AUTOINCREMENT,
		*/
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
		/*
		CONSTRAINT pk_courses PRIMARY KEY (id) ON CONFLICT
			ROLLBACK AUTOINCREMENT,
		*/
		CONSTRAINT fk_gradingRules FOREIGN KEY (gradingRulesID) REFERENCES 
		GradingRules (id) ON DELETE RESTRICT
);

/*VG wants to delete - move into Accounts*/
Create Table Teachers (
		id INTEGER,
		CONSTRAINT pk_teachers PRIMARY KEY (id)
			ON CONFLICT ROLLBACK,
		CONSTRAINT fk_accounts FOREIGN KEY (id) REFERENCES
			Accounts (id) ON DELETE CASCADE
);

/*VG wants to delete - move into Accounts*/
CREATE TABLE TAs (          
		id INTEGER,
		CONSTRAINT pk_tas PRIMARY KEY (id)
			ON CONFLICT ROLLBACK,
		CONSTRAINT fk_accounts FOREIGN KEY (id) REFERENCES
			Accounts (id) ON DELETE CASCADE
);

CREATE TABLE Students (
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

CREATE TABLE Files (        
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

CREATE TABLE Assignments (  
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		name text,
		userId Integer
);

/*VG want to delete - put in Account*/
CREATE TABLE Passwords (    
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		passwd text
);

CREATE TABLE Permissions (  
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

/*VG want to delete - put in Account*/
CREATE TABLE EmailAddresses (  
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

/*VG want to delete - unnecessary*/
Create Table hasEmailAddr (         
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
