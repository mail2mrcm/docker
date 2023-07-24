package com.hello2chandan.awslambdacurd.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private int id;
	private String fName;
	private String lName;
	//private Date dob; 
	private Department dept;	 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	/*
	 * public Date getDob() { return dob; }
	 */
	
	/*
	 * public void setDob(Date dob) { this.dob = dob; }
	 */

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

}
