package com.hello2chandan.helloworld;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello2chandan.helloworld.model.Student;
import com.hello2chandan.helloworld.repository.StudentRepo;

@RestController
public class HomeController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/")
    public String getHome() {
        List<Student> students = studentRepo.findAll();
        if(students.size()>0){
            return " Hello "+ students.get(0).getName();
        }
        return "Hello World !!!";
    }

}
