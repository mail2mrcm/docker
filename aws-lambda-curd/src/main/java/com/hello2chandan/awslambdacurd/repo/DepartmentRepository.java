package com.hello2chandan.awslambdacurd.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.hello2chandan.awslambdacurd.model.Department;

@Component
public class DepartmentRepository {
	private List<Department> depertments = new ArrayList<Department>();
	
	public void add(Department department) {
		depertments.add(department);
	}
	
	public Department get(int id) {
		if (id > 0) {
			Optional<Department> depeOptional = depertments.stream().filter(p -> p.getId() == id).findFirst();
			if (depeOptional.isPresent()) {
				return depeOptional.get();
			}
		}
		return new Department();
	}

	public List<Department> getAll() {
		return this.depertments;
	}
}
