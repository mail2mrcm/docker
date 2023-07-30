package com.hello2chandan.aws.lambda.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Student {

	private int id;
	private String name;
	private String gender;
	private int deptId;

	public Student() {
	}

	public Student(String json) {
		Gson gson = new Gson();
		Student request = gson.fromJson(json, Student.class);
		this.id = request.id;
		this.gender = request.gender;
		this.deptId = request.deptId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String toString() {
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
