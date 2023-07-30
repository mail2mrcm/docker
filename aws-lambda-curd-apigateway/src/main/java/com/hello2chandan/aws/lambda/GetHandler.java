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

public class GetHandler implements RequestStreamHandler {

	private JSONParser parser = new JSONParser();
	private StudentRepo studentRepo = new StudentRepo();

	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		// TODO Auto-generated method stub

	}

	public void handleGetByParam(InputStream input, OutputStream output, Context context) throws IOException {
		JSONParser parser = new JSONParser();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		JSONObject responseJson = new JSONObject();

		Student result = null;
		try {
			JSONObject event = (JSONObject) parser.parse(reader);
			System.out.println("Event: " + event.toString());

			JSONObject responseBody = new JSONObject();
			if (event.get("pathParameters") != null) {
				JSONObject pps = (JSONObject) event.get("pathParameters");
				if (pps.get("id") != null) {
					int id = Integer.parseInt((String) pps.get("id"));
					result = studentRepo.get(id);
				}
			} else if (event.get("queryStringParameters") != null) {
				JSONObject qps = (JSONObject) event.get("queryStringParameters");
				if (qps.get("id") != null) {
					int id = Integer.parseInt((String) qps.get("id"));
					result = studentRepo.get(id);
				}
			}
			if (result != null) {
				// JSONObject event = (JSONObject) parser.parse(result);
				responseBody.put("student", result);
				responseJson.put("statusCode", 200);
			} else {
				responseBody.put("message", "No item found");
				responseJson.put("statusCode", 404);
			}
			responseJson.put("body", responseBody);
			if (event.get("headers") != null) {
				System.out.println("Header: " + event.get("headers").toString());
				Gson gson = new Gson();
				Map<String, Object> responseHeader = gson.fromJson(event.get("headers").toString(), HashMap.class);
				responseJson.put("headers", responseHeader);
			}

		} catch (ParseException pex) {
			responseJson.put("statusCode", 400);
			responseJson.put("exception", pex);
		}

		OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
		writer.write(responseJson.toString());
		writer.close();
	}
}
