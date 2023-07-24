package com.hello2chandan.awslambdacurd;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hello2chandan.awslambdacurd.model.Student;
import com.hello2chandan.awslambdacurd.repo.StudentRepository;

@Component
public class GetAllStudentFunction implements Supplier<List<Student>> {

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public List<Student> get() {
		return studentRepo.getAll();
	}

}
