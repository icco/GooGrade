-- BluGoo's Awesome DataBase

-- Drop Tables & Views
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Courses;
DROP TABLE IF EXISTS Assignments;
DROP TABLE IF EXISTS GradingRules;
DROP TABLE IF EXISTS Grades;
DROP TABLE IF EXISTS hasGrade;
DROP TABLE IF EXISTS teaches;
DROP TABLE IF EXISTS enrolled;
DROP TABLE IF EXISTS assists; 
DROP VIEW IF EXISTS Teachers;
DROP VIEW IF EXISTS Students;
DROP VIEW IF EXISTS TAs;

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


/* entity table for Assignment class */
CREATE TABLE Assignments (  
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		aName TEXT,
                aTotal INTEGER,  
                aDueDate DATE, 
                aType TEXT, 
                aAverage FLOAT, 
                aMax FLOAT, 
                aMin FLOAT,
                courseId INTEGER,

                CONSTRAINT fk_courseId FOREIGN KEY (courseId) REFERENCES
                Courses (id) ON DELETE CASCADE
);

-- entity table for GradingRules class
CREATE TABLE GradingRules (    
		id INTEGER PRIMARY KEY AUTOINCREMENT
                aFloor FLOAT,
                bFloor FLOAT,
                cFloor FLOAT,
                dFloor FLOAT
);


-- relation table between Accounts & Grades 
Create Table Grades (        
		accountId INTEGER,
		grade FLOAT,
                assignId INTEGER,
		CONSTRAINT pk_Grades PRIMARY KEY (accountId, assignId),
		CONSTRAINT fk_account FOREIGN KEY (accountId) REFERENCES Accounts
			(id) ON DELETE CASCADE,
		CONSTRAINT fk_assign FOREIGN KEY (assignId) REFERENCES Assignments
			(id) ON DELETE CASCADE
);

-- relation table between Accounts (teachers) & Courses 
CREATE TABLE teaches (         
		course INTEGER,
		teacher INTEGER,
		CONSTRAINT pk_teaches PRIMARY KEY (course, teacher),
		CONSTRAINT fk_course FOREIGN KEY (course) REFERENCES Courses
			(id) ON DELETE CASCADE,
		CONSTRAINT fk_teacher FOREIGN KEY (teacher) REFERENCES Accounts
			(id) ON DELETE CASCADE
);

-- relation table between Accounts (students) & Courses 
CREATE TABLE enrolled (
		course INTEGER,
		student INTEGER,
		CONSTRAINT pk_enrolled PRIMARY KEY (course, student),
		CONSTRAINT fk_course FOREIGN KEY (course) REFERENCES Courses
			(id) ON DELETE CASCADE,
		CONSTRAINT fk_student FOREIGN KEY (student) REFERENCES Accounts
			(id) ON DELETE CASCADE
);

-- relation table between Account (tas) & Courses
CREATE TABLE assists (
                course INTEGER,
                ta INTEGER,
                CONSTRAINT pk_enrolled PRIMARY KEY (course, ta),
                CONSTRAINT fk_course FOREIGN KEY (course) REFERENCES Courses
                        (id) ON DELETE CASCADE,
                CONSTRAINT fk_tas FOREIGN KEY (ta) REFERENCES Accounts
                        (id) ON DELETE CASCADE
);

-- View of all teacher ids
CREATE VIEW Teachers AS
    SELECT DISTINCT teacher as id FROM teaches;

-- View of all student ids
CREATE VIEW Students AS
    SELECT DISTINCT student as id FROM enrolled;

-- View of all ta ids
CREATE VIEW TAs AS
    SELECT DISTINCT ta as id FROM assists;

-- Thanks for visiting!
