package com.hello2chandan.awslambdacurd;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hello2chandan.awslambdacurd.model.Student;
import com.hello2chandan.awslambdacurd.repo.StudentRepository;

@Component
public class GetStudentFunction implements Function<Integer, Student> {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student apply(Integer id) {
		return studentRepository.get(id);
	}
}
