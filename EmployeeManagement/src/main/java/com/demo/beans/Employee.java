package com.demo.beans;

import java.time.LocalDate;

public class Employee {
  private int empno;
  private String ename;
  private String job;
  private LocalDate hiredate;
  private int sal;
  private int deptno;

public Employee() {
	super();
}
public Employee(int empno, String ename, String job, LocalDate hiredate, int sal,int deptno) {
	super();
	this.empno = empno;
	this.ename = ename;
	this.job = job;
	this.hiredate = hiredate;
	this.sal = sal;
	this.deptno=deptno;
}
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public LocalDate getHiredate() {
	return hiredate;
}
public void setHiredate(LocalDate hiredate) {
	this.hiredate = hiredate;
}
public int getSal() {
	return sal;
}
public void setSal(int sal) {
	this.sal = sal;
}
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}
@Override
public String toString() {
	return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job + ", hiredate=" + hiredate + ", sal=" + sal
			+ "]";
}
  
}
