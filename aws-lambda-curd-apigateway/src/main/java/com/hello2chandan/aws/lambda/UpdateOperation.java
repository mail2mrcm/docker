package com.hello2chandan.aws.lambda;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hello2chandan.aws.lambda.model.Student;
import com.hello2chandan.aws.lambda.repo.StudentRepo;

@Component
public class UpdateOperation implements Function<Student, Student> {

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Student apply(Student t) {
		return studentRepo.update(t);
	}
}
