package com.hello2chandan.aws.lambda;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hello2chandan.aws.lambda.model.Student;
import com.hello2chandan.aws.lambda.repo.StudentRepo;

@Component
public class CreateOperation implements Function<Integer, Student> {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student apply(Integer id) {
		return studentRepo.get(id);
	}
	
}
