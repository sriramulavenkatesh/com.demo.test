package com.demo.testOne;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RandomTestOne {
	
	
	public void getCall() throws ClientProtocolException, IOException {
		
	 RestAssured.baseURI="https://reqres.in";
     Response response = given().when().get("/api/users").then().assertThat().statusCode(200).extract().response();
     System.out.println(response.asString());	
	}
	
	
	public void postCall() {
		
		RestAssured.baseURI="https://reqres.in";
		Response response = given().header("Content-Type","application/json").when().body("{\r\n    \"name\": \"morpheus\",\r\n    \"job\": \"leader\"\r\n}").
		post("/api/users").then().extract().response();
		String responseAsString = response.asString();
		JsonPath responseAsJson = new JsonPath(responseAsString);
		String name = responseAsJson.get("name");
		Assert.assertEquals(name, "morpheus");
		
		
	}
	
	@Test
	public void putCall() {
		
		RestAssured.baseURI="https://reqres.in";
		Response response = given().header("Content-Type","application/json").when().body("{\r\n    \"id\": 199,\r\n    \"name\": \"cerulean\",\r\n    \"updatedAt\": \"2019-03-01T12:23:56.664Z\"\r\n}").
		post("/api/users2").then().assertThat().statusCode(201).extract().response();
		String responseAsString = response.asString();
		JsonPath responseAsJson = new JsonPath(responseAsString);
		int idValue = responseAsJson.get("id");
		System.out.println(idValue+" 199");
	}
	

}
