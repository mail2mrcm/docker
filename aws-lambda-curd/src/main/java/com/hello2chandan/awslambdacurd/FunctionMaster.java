package com.hello2chandan.awslambdacurd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FunctionMaster {
	
	@Autowired
	private AddStudentFunction addStudentFunction;

	@Autowired
	private GetAllStudentFunction getAllStudentFunction;

	@Autowired
	private GetStudentFunction getStudentFunction;

	@Autowired
	private DeleteStudentFunction deleteStudentFunction;
	
	@Autowired
	private AddDepartmentFunction addDepartmentFunction;

	@Bean
	public AddStudentFunction add() {
		return addStudentFunction;

	}

	@Bean
	public DeleteStudentFunction delete() {
		return deleteStudentFunction;
	}

	@Bean
	public GetStudentFunction get() {
		return getStudentFunction;
	}

	@Bean
	public GetAllStudentFunction getAll() {
		return getAllStudentFunction;
	}
	
	@Bean
	public AddDepartmentFunction addDept() {
		return addDepartmentFunction;
	}
	 
	

}
