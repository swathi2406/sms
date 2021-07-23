package com.accenture.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int sid;

	private String name;
	private int age;
	private Date dob;
	private int grade;
	private String number;
	public int getSid() {
		return sid;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Date getDob() {
		return dob;
	}
	public int getGrade() {
		return grade;
	}
	public String getNumber() {
		return number;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", age=" + age + ", dob=" + dob + ", grade=" + grade
				+ ", number=" + number + "]";
	}
	public Student(int sid, String name, int age, Date dob, int grade, String number) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.grade = grade;
		this.number = number;
	}
	public Student() {
	}
	
}
