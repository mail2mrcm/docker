package com.hello2chandan.awslambdacurd;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hello2chandan.awslambdacurd.model.Department;
import com.hello2chandan.awslambdacurd.repo.DepartmentRepository;

@Component
public class AddDepartmentFunction implements Consumer<Department> {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public void accept(Department department) {
		System.out.println("Department:"+department.getId());
		departmentRepository.add(department);
	}
}
