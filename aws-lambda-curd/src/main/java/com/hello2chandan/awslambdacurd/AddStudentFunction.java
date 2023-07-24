package com.hello2chandan.awslambdacurd;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hello2chandan.awslambdacurd.model.Student;
import com.hello2chandan.awslambdacurd.repo.StudentRepository;

@Component
public class AddStudentFunction implements Function<Student, Integer> {
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public Integer apply(Student student) {
		System.out.println("student:" + student.getId());
		return studentRepo.add(student);
	}

}
