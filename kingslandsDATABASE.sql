drop database if exists kingsland;

create database if not exists kingsland;

use kingsland;


//-------------------------TABLES-------------------------
create table student(
	id VARCHAR(10) NOT NULL,
	studentName VARCHAR(45),
	Address VARCHAR(45),
	Contact VARCHAR(45),
	dob Date,
	Gender VARCHAR(45),
	CONSTRAINT PRIMARY KEY(id)
);

create table course(
	code VARCHAR(20) NOT NULL,
	courseName VARCHAR(45),
	courseIntake VARCHAR(45),
	courseFee DECIMAL(10,2),
	duration VARCHAR(20),
	CONSTRAINT PRIMARY KEY(code)
);

create table registration(
	regNo INT NOT NULL AUTO_INCREMENT,
	regDate VARCHAR(45),
	regFee DOUBLE(10,2),
	duration VARCHAR(20),
	id VARCHAR(10) NOT NULL,
	code VARCHAR(20) NOT NULL,
	CONSTRAINT PRIMARY KEY(regNo),
	CONSTRAINT FOREIGN KEY(id) REFERENCES student(id) on update cascade on delete cascade, 
    	CONSTRAINT FOREIGN KEY(code) REFERENCES course(code) on update cascade on delete cascade
);

//-------------------------STUDENT TABLE RECORDS-------------------------

INSERT INTO student VALUES('S001','SANDUN','COLOMBO 15','0112524789','1999-01-09','MALE');

//-------------------------COURSE TABLE RECORDS-------------------------

INSERT INTO COURSE VALUES('C001','ANDROID','SPRING,SUMMER,FALL',30000.00,'1YEAR'),
			 			 ('C002','PYTHON','SUMMER',35000.00,'1YEAR'),
						 ('C003','JAVA','FALL',45000.00,'2YEAR'),
						 ('C004','DBMS','AUTHOM',45000.00,'2YEAR'),
						 ('C005','MONGO DB','FALL',40000.00,'2YEAR'),
						 ('C006','SPRING BOOT','AUTHOM',50000.00,'2YEAR');

//-------------------------REGISTRATION TABLE RECORDS-------------------------

INSERT INTO REGISTRATION VALUES(1,'2020-09-03',5000.00,'1YEAR','S001','C001');

-- JOIN QUERY FOR SERACH STUDENT HOW ENROLL WITH THE INDICATED COURSE --
SELECT course.code, 
       student.studentName 
FROM 
       course 
       INNER JOIN registration 
       ON course.code = registration.code 
       INNER JOIN student ON student.id = registration.id WHERE course.code='C005';





