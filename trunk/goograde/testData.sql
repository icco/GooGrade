-- 
-- Test Data for Development. 
--

INSERT INTO Courses (title, department, number, section, gradingRulesId) 
    VALUES("Systems Programming", "CSC", "357","01","1");
INSERT INTO Courses (title, department, number, section, gradingRulesId) 
    VALUES("Software Engineering I", "CPE", "308","01","1");
INSERT INTO Courses (title, department, number, section, gradingRulesId) 
    VALUES("Software Engineering II", "CPE", "309","01","1");
INSERT INTO Courses (title, department, number, section, gradingRulesId) 
    VALUES("Professional responsabilities", "CSC", "300","01","1");
INSERT INTO Courses (title, department, number, section, gradingRulesId) 
    VALUES("Graduate Thesis", "CSC", "500","01","1");

-- Nat's account needs to stay first, since we test that the teacher is first in the db.
INSERT INTO Accounts (username, name, email, password) VALUES("nwelch","Nathaniel Welch","nat@natwelch.com","123456");
INSERT INTO Accounts (username, name, email, password) VALUES("pphu","Paul Phu","pphu@calpoly.edu","123456");
INSERT INTO Accounts (username, name, email, password) VALUES("vgerdin","Viktor Gerdin","vgerdin@calpoly.edu","123456");
INSERT INTO Accounts (username, name, email, password) VALUES("kblizard","Katherine Blizard","kblizard@calpoly.edu","123456");
INSERT INTO Accounts (username, name, email, password) VALUES("mduder","Matt Duder","mduder@calpoly.edu","123456");
INSERT INTO Accounts (username, name, email, password) VALUES("kvu","Kalvin Vu","kvu@calpoly.edu","123456");
INSERT INTO Accounts (username, name, email, password) VALUES("mquan","Michael Quan","mquan@calpoly.edu","123456");
INSERT INTO Accounts (username, name, email, password) VALUES("hmendez","Hermyn Mendez","hmendez@calpoly.edu","123456");

INSERT INTO teaches (course, teacher) VALUES (1,1);
INSERT INTO teaches (course, teacher) VALUES (2,1);
INSERT INTO teaches (course, teacher) VALUES (3,1);
INSERT INTO teaches (course, teacher) VALUES (4,1);
INSERT INTO teaches (course, teacher) VALUES (5,1);

INSERT INTO assists (course, ta) VALUES (1,2);

INSERT INTO enrolled (course, student) VALUES (1, 3);
INSERT INTO enrolled (course, student) VALUES (2, 3);
INSERT INTO enrolled (course, student) VALUES (3, 3);
INSERT INTO enrolled (course, student) VALUES (4, 3);

INSERT INTO enrolled (course, student) VALUES (1, 4);
INSERT INTO enrolled (course, student) VALUES (2, 4);
INSERT INTO enrolled (course, student) VALUES (3, 4);
INSERT INTO enrolled (course, student) VALUES (5, 4);

INSERT INTO enrolled (course, student) VALUES (2, 5);
INSERT INTO enrolled (course, student) VALUES (3, 5);
INSERT INTO enrolled (course, student) VALUES (5, 5);

-- Word to your Database. 
-- Peace, I'm Out.

