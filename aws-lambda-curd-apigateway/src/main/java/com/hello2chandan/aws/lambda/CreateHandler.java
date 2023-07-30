package com.hello2chandan.aws.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.google.gson.Gson;
import com.hello2chandan.aws.lambda.model.Student;
import com.hello2chandan.aws.lambda.repo.StudentRepo;

public class CreateHandler implements RequestStreamHandler{
	
	private JSONParser parser = new JSONParser();
	
	private StudentRepo studentRepo = new StudentRepo();
	
	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {

		    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		    JSONObject responseJson = new JSONObject();
		   

		    try {
		        JSONObject event = (JSONObject) parser.parse(reader);
		        System.out.println("Event: " + event.toString());

		        if (event.get("body") != null) {		        	
		            Student person = new Student(event.get("body").toString());
		            studentRepo.add(person);
		            Map<String, Object> responseMap = new HashMap<String, Object>();
		            responseMap.put("id", person.getId());
		            JSONObject responseBody = new JSONObject(responseMap);
		            responseJson.put("body", responseBody);
		        }
		        if(event.get("headers") != null) {
		        	System.out.println("Header: " + event.get("headers").toString());
		        	Gson gson = new Gson();
		        	Map responseHeader = gson.fromJson(event.get("headers").toString(), HashMap.class);	
					responseJson.put("headers", responseHeader);
		        }
		        responseJson.put("statusCode", 200);
		    } catch (ParseException pex) {
		        responseJson.put("statusCode", 400);
		        responseJson.put("exception", pex);
		    }

		    OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
		    writer.write(responseJson.toString());
		    writer.close();
	}
}