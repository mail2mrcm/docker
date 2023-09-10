package com.hello2chandan.helloworld.repository;

import org.springframework.stereotype.Component;
import com.hello2chandan.helloworld.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

@Component
public interface StudentRepo extends JpaRepository<Student, Integer> {
    
}
