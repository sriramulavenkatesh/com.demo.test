package com.demo.testOne;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostCallDemo {
	
	//@Test
	public void testPost() throws ClientProtocolException, IOException {
		
		HttpPost httpPost = new HttpPost("https://reqres.in/api/users");
		httpPost.addHeader("Content-Type", "application/json");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		Users userIn = new Users("cyprus","manager");
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("D:\\Start2019\\com.demo.test\\src\\test\\java\\com\\demo\\testOne\\usersList.json"),userIn);
		String usersInAsString = mapper.writeValueAsString(userIn);
		httpPost.setEntity(new StringEntity(usersInAsString));
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		HttpEntity responseAsEntity = httpResponse.getEntity();
		String responseAsString = EntityUtils.toString(responseAsEntity);
		Users usersOut = mapper.readValue(responseAsString, Users.class);
		System.out.println(statusCode);
		System.out.println(usersOut.getName());
		System.out.println(usersOut.getJob());
		
		
		
		
		
	}
	
	@Test
    public void testNew() throws ClientProtocolException, IOException {
    	
    	HttpPost httpPost = new HttpPost("https://reqres.in/api/users");
    	httpPost.addHeader("Content-Type", "application/json");
    	ObjectMapper mapper = new ObjectMapper();
    	Users usersIn = new Users("venkat","28");
    	String usersInString = mapper.writeValueAsString(usersIn);
    	httpPost.setEntity(new StringEntity(usersInString));
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
    	int statusCode = httpResponse.getStatusLine().getStatusCode();
    	HttpEntity responseAsEntity = httpResponse.getEntity();
    	String responseAsString = EntityUtils.toString(responseAsEntity); 
    	Users userOut = mapper.readValue(responseAsString, Users.class);
    	System.out.println(statusCode);
    	System.out.println(userOut.getName());
    	System.out.println(userOut.getJob());
    	
    	
    	
    	
     	
    }
	
	
}
