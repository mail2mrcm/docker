package com.hello2chandan.awslambdacurd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsLambdaCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsLambdaCurdApplication.class, args);
		System.out.println("******Create Department*******");
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("curl localhost:8080/addDept -H \"Accept: application/json\" \"Content-Type: application/json\" -d {\"id\":1, \"name\":\"Engineering\", \"deptHead\":\"N N J\"}");
		System.out.println("***");
		System.out.println("**");
		System.out.println("*");		
		System.out.println("******Add Student*******");
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("curl localhost:8080/add -H \"Accept: application/json\" \"Content-Type: application/json\" -d {\"id\":123, \"fName\": \"chandan\", \"lName\":\"maity\", \"dept\":{\"id\":1,\"name\": \"Engineering\", \"deptHead\": \"N N J\"}}");
		System.out.println("******Get Student*******");
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("curl localhost:8080/get -H \"Content-Type: html/text\" -d 123");
		System.out.println("***");
		System.out.println("**");
		System.out.println("*");	
		System.out.println("******Get All Students*******");
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("curl localhost:8080/getAll -H \"Content-Type: html/text\" -d 123");
		System.out.println("***");
		System.out.println("**");
		System.out.println("*");	
		System.out.println("******Delete Students*******");
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("curl localhost:8080/delete -H \"Content-Type: html/text\" -d 123");
		System.out.println("***");
		System.out.println("**");
		System.out.println("*");	
	
	}
	

}
