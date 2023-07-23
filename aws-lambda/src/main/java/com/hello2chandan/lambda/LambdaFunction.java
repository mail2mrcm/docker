package com.hello2chandan.lambda;

import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class LambdaFunction implements Function<Student, Student> {

	@Override
	public Student apply(Student student) {
		return student;
	}	

}
