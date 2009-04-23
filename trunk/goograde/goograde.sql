-- BluGoo's Awesome DataBase

-- Drop Tables 
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Courses;
DROP TABLE IF EXISTS Teachers;
DROP TABLE IF EXISTS TAs;
DROP TABLE IF EXISTS Students;
DROP TABLE IF EXISTS Files;
DROP TABLE IF EXISTS Assignments;
DROP TABLE IF EXISTS Passwords;
DROP TABLE IF EXISTS Permissions;
DROP TABLE IF EXISTS EmailAddresses;
DROP TABLE IF EXISTS Announcements;
DROP TABLE IF EXISTS GradingRules;
DROP TABLE IF EXISTS hasGrade;
DROP TABLE IF EXISTS teaches;
DROP TABLE IF EXISTS submitted;
DROP TABLE IF EXISTS hasPermission;
DROP TABLE IF EXISTS hasPW;
DROP TABLE IF EXISTS hasEmailAddr;
DROP TABLE IF EXISTS hasAddr;
DROP TABLE IF EXISTS todo;

Create Table Accounts (
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		teachID integer,
		taId integer,
		studentId Integer
);

 Create Table Courses (      
		id INTEGER PRIMARY KEY AUTOINCREMENT

);

 Create Table Teachers (     
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

 Create Table TAs (          
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

 Create Table Students (     
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

 Create Table Files (        
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

 Create Table Assignments (  
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		name text,
		userId Integer
);

 Create Table Passwords (    
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		userId Integer,
		passwd text
);

 Create Table Permissions (  
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

 Create Table EmailAddresses (  
		id INTEGER PRIMARY KEY AUTOINCREMENT
);

 Create Table Announcements (   
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		courseId INTEGER,
		title TEXT,
		post TEXT,
		datetime INTEGER
);

 Create Table GradingRules (    
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		courseId INTEGER
);

 Create Table hasGrade (        
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		userId INTEGER
);

 Create Table teaches (         
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		courseId INTEGER
);

 Create Table submitted (       
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		assignmentID integer,
		datetime integer
);

 Create Table hasPermission (   
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		userId INTEGER
);

 Create Table hasPW (           
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		userId INTEGER
);

 Create Table hasEmailAddr (         
		id INTEGER PRIMARY KEY AUTOINCREMENT,
		userId INTEGER
);



