package com.hello2chandan.aws.lambda.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hello2chandan.aws.lambda.model.Student;

public class StudentRepo implements CurdRepo<Student, Integer> {
 
	private List<Student> students = new ArrayList<Student>();
	
	@Override
	public Integer add(Student item) {
		students.add(item);
		return item.getId();
	}	

	@Override
	public Student get(Integer id) {
		Optional<Student> student = students.stream().filter(e -> e.getId() == id).findFirst();
		if (student.isPresent())
			return student.get();
		Student temp = new Student();
		temp.setId(0);
		temp.setName("Dummy");
		return temp;
	}
	@Override
	public Student update(Student item) {
		Optional<Student> student = students.stream().filter(e -> e.getId() == item.getId()).findFirst();
		if (student.isPresent()) {
			 Student oldStudent = student.get();
			 oldStudent.setDeptId(item.getDeptId());
			 oldStudent.setGender(item.getGender());
			 oldStudent.setId(item.getId());
			 oldStudent.setName(item.getName());
			 return item;
		}		
		return new Student();
	}

	@Override
	public Integer delete(Integer id) {
		return students.removeIf(e -> e.getId() == id) ? 1 : 0;
	}

}
