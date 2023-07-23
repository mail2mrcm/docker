package com.hello2chandan.awslambda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hello2chandan.lambda.LambdaConsumer;
import com.hello2chandan.lambda.LambdaFunction;

@Configuration
public class MyLambda {

	@Bean
	public LambdaFunction exampleFunction() {
		return new LambdaFunction();
	}
	
	@Bean
	public LambdaConsumer exampleConsumer() {
		return new LambdaConsumer();
	}
}
