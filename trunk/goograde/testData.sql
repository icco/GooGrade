-- 
-- Test Data for Development. 
--
INSERT INTO "Assignments" VALUES(1,'ArrayList Object',20,'Fri Apr 10 00:00:00 PDT 2009','Homework',5.0,3.0,4.0,1);
INSERT INTO "Assignments" VALUES(2,'JSP Sample',10,'Thu Apr 16 00:00:00 PDT 2009','Other',8.97,10.0,0.0,1);
INSERT INTO "Assignments" VALUES(3,'Midterm 1',122,'Wed May 13 00:00:00 PDT 2009','Test',0.0,0.0,0.0,2);
INSERT INTO "Assignments" VALUES(4,'Midterm 2',100,'Sun May 10 00:00:00 PDT 2009','Test',0.0,0.0,0.0,2);
INSERT INTO "Assignments" VALUES(5,'Vision and Scope Review',23,'Mon May 11 00:00:00 PDT 2009','Homework',0.0,0.0,0.0,3);
INSERT INTO "Assignments" VALUES(6,'SRS',40,'Mon May 11 00:00:00 PDT 2009','Homework',0.0,0.0,0.0,1);
INSERT INTO "Assignments" VALUES(7,'Preliminary Design',25,'Mon May 11 00:00:00 PDT 2009','Homework',0.0,0.0,0.0,5);
INSERT INTO "Assignments" VALUES(8,'Pseudo Code',10,'Mon May 11 00:00:00 PDT 2009','Homework',0.0,0.0,0.0,5);
INSERT INTO "Assignments" VALUES(9,'Wiki',15,'Mon May 11 00:00:00 PDT 2009','Homework',0.0,0.0,0.0,3);
INSERT INTO "Assignments" VALUES(10,'Test Cases',10,'Tue May 12 00:00:00 PDT 2009','Homework',0.0,0.0,0.0,5);
INSERT INTO "Assignments" VALUES(11,'Journal',5,'Wed May 13 00:00:00 PDT 2009','Homework',0.0,0.0,0.0,5);

INSERT INTO "Courses" VALUES(1,'Systems Programming','CSC',357,1,1);
INSERT INTO "Courses" VALUES(2,'Software Engineering I','CPE',308,1,2);
INSERT INTO "Courses" VALUES(3,'Software Engineering II','CPE',309,1,3);
INSERT INTO "Courses" VALUES(4,'Professional responsabilities','CSC',300,1,4);
INSERT INTO "Courses" VALUES(5,'Graduate Thesis','CSC',500,1,5);

INSERT INTO "GradingRules" VALUES(1,90,80,70,60);
INSERT INTO "GradingRules" VALUES(2,90,80,70,60);
INSERT INTO "GradingRules" VALUES(3,90,80,70,60);
INSERT INTO "GradingRules" VALUES(4,90,80,70,60);
INSERT INTO "GradingRules" VALUES(5,90,80,70,60);


-- Nat's account needs to stay first, since we test that the teacher is first in the db.
INSERT INTO Accounts (username, name, email, password) VALUES("nwelch","Nathaniel Welch","nat@natwelch.com","123456a");
INSERT INTO Accounts (username, name, email, password) VALUES("pphu","Paul Phu","pphu@calpoly.edu","123456a");
INSERT INTO Accounts (username, name, email, password) VALUES("vgerdin","Viktor Gerdin","vgerdin@calpoly.edu","123456a");
INSERT INTO Accounts (username, name, email, password) VALUES("kblizard","Katherine Blizard","kblizard@calpoly.edu","123456a");
INSERT INTO Accounts (username, name, email, password) VALUES("mduder","Matt Duder","mduder@calpoly.edu","123456a");
INSERT INTO Accounts (username, name, email, password) VALUES("kvu","Kalvin Vu","kvu@calpoly.edu","123456a");
INSERT INTO Accounts (username, name, email, password) VALUES("mquan","Michael Quan","mquan@calpoly.edu","123456a");
INSERT INTO Accounts (username, name, email, password) VALUES("hmendez","Hermyn Mendez","hmendez@calpoly.edu","123456a");

INSERT INTO teaches (course, teacher) VALUES (1,1);
INSERT INTO teaches (course, teacher) VALUES (2,1);
INSERT INTO teaches (course, teacher) VALUES (3,1);
INSERT INTO teaches (course, teacher) VALUES (4,1);
INSERT INTO teaches (course, teacher) VALUES (5,1);

INSERT INTO enrolled (course, student) VALUES (1, 3);
INSERT INTO enrolled (course, student) VALUES (2, 3);
INSERT INTO enrolled (course, student) VALUES (3, 3);
INSERT INTO enrolled (course, student) VALUES (4, 3);
INSERT INTO enrolled (course, student) VALUES (5, 3);

INSERT INTO enrolled (course, student) VALUES (1, 4);
INSERT INTO enrolled (course, student) VALUES (2, 4);
INSERT INTO enrolled (course, student) VALUES (3, 4);
INSERT INTO enrolled (course, student) VALUES (5, 4);

INSERT INTO enrolled (course, student) VALUES (2, 5);
INSERT INTO enrolled (course, student) VALUES (3, 5);
INSERT INTO enrolled (course, student) VALUES (5, 5);

INSERT INTO enrolled (course, student) VALUES (2, 6);
INSERT INTO enrolled (course, student) VALUES (3, 6);
INSERT INTO enrolled (course, student) VALUES (5, 6);
INSERT INTO enrolled (course, student) VALUES (4, 6);
INSERT INTO enrolled (course, student) VALUES (1, 6);

INSERT INTO enrolled (course, student) VALUES (2, 7);
INSERT INTO enrolled (course, student) VALUES (3, 7);
INSERT INTO enrolled (course, student) VALUES (4, 7);
INSERT INTO enrolled (course, student) VALUES (5, 7);


INSERT INTO Grades (accountId, assignId, grade) VALUES (4,2,87.8);
INSERT INTO Grades (accountId, assignId, grade) VALUES (3,2,47.2);

INSERT INTO Grades (accountId, assignId, grade) VALUES (3,9,80.0);
INSERT INTO Grades (accountId, assignId, grade) VALUES (4,9,7.6);

INSERT INTO Grades (accountId, assignId, grade) VALUES (3,7,17.0);
INSERT INTO Grades (accountId, assignId, grade) VALUES (3,8,10.0);
-- Word to your Database. 
-- Peace, I'm Out.

