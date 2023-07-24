package com.hello2chandan.awslambdacurd;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hello2chandan.awslambdacurd.repo.StudentRepository;

@Component
public class DeleteStudentFunction implements Consumer<Integer> {

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void accept(Integer id) {
		studentRepository.delete(id);
	}
}
