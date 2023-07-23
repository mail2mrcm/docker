package com.hello2chandan.lambda;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

@Component
public class LambdaConsumer implements Consumer<String> {

	@Override
	 public void accept(String name) {
		 System.out.println(name); 
		 System.out.println("name:" + name); 
	 }
}
