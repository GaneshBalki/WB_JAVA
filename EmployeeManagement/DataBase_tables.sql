CREATE TABLE emp_p (
  empno INT PRIMARY KEY,
  ename VARCHAR(10),
  job VARCHAR(9),
  hiredate DATE,
  sal int,
  dept INT
);

INSERT INTO EMP_p VALUES
  (7369, 'SMITH', 'CLERK', '1990-08-12', 800, 20);
INSERT INTO EMP_P VALUES
  (7499, 'ALLEN', 'SALESMAN', '1990-05-02', 1600, 30);
INSERT INTO EMP_p VALUES
  (7521, 'WARD', 'SALESMAN',  '1990-08-12', 1250,  30);
INSERT INTO EMP_p VALUES
  (7566, 'JONES', 'MANAGER', '1900-04-12', 2975,  20);
INSERT INTO EMP_p VALUES
  (7654, 'MARTIN', 'SALESMAN', '1989-11-11', 1250,30);


create table admin_login(uname varchar(30) primary key,password varchar(30),role varchar(10));
insert into admin_login values('ganesh@123','12345','admin');