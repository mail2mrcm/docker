package com.hello2chandan.awslambdacurd.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Department {
	
	private List<Student> students;
	private int id;
	private String name;
	private String deptHead;
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptHead() {
		return deptHead;
	}
	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}
}
