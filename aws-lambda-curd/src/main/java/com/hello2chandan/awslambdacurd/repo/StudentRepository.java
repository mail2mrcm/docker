package com.hello2chandan.awslambdacurd.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hello2chandan.awslambdacurd.model.Department;
import com.hello2chandan.awslambdacurd.model.Student;

@Component
public class StudentRepository {
	private List<Student> students = new ArrayList<Student>();
	
	@Autowired
	private DepartmentRepository depRepo;
	
	public int add(Student student) {
		System.out.println(student.getId());
		if(null != student) {
			Department dept = depRepo.get(student.getDept().getId());
			if (dept.getId() > 0) {
				student.setDept(dept);
				this.students.add(student);
				return student.getId();
			}
		}
		return 0;
	}

	public Student get(int id) {
		if (id > 0) {
			Optional<Student> stdBucket = students.stream().filter(p -> p.getId() == id).findFirst();
			if(stdBucket.isPresent())
			 return stdBucket.get();			
		}
		return new Student();
	}
	
	public int update(Student student) {
		if(null != student) {
			Optional<Student> stdBucket = students.stream().filter(p -> p.getId() == student.getId()).findFirst();
			if(stdBucket.isPresent()) {
				Student searchedStudent = stdBucket.get();
				searchedStudent = student;
				return student.getId();
			}
		}
		return 0;
	}
	public Boolean delete(int id) {
		if(id>0) {
			return students.removeIf(p-> p.getId()== id);			
		}
		return false;
	}
	public List<Student> getAll(){
		return this.students;
	}
}
