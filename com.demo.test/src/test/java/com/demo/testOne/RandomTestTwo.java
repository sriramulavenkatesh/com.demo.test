package com.demo.testOne;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RandomTestTwo {
	
	public void getCall() throws IOException {
		
		RestAssured.baseURI="https://reqres.in";
		Response response = given().header("Content-Type","application/json").when().get("/api/users").then().
		assertThat().statusCode(200).and().body("data.id[0]", equalTo(1)).extract().response();
		InputStream is = response.asInputStream();
		byte[] buffer = new byte[is.available()];
		is.read(buffer);
		File targetFile = new File("D:\\Start2019\\com.demo.test\\src\\test\\java\\com\\demo\\testOne\\file.json");
	    OutputStream outStream = new FileOutputStream(targetFile);
	    outStream.write(buffer);
	    /*JsonPath responseAsJson = new JsonPath(response.asString());
		String name = responseAsJson.and().get("data[0].first_name");
		System.out.println(name);*/
	}
	
	@Test
	public void test() throws IOException {
		
		String inputBody ="{\r\n" + 
				"    \"name\": \"venkat\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}";
		RestAssured.baseURI="https://reqres.in";
		Response response = given().header("Content-Type","application/json").when().body(inputBody).post("/api/users").then().assertThat().
		statusCode(201).extract().response();
		String responseAsString = response.asString();
		JsonPath responseAsJson = new JsonPath(responseAsString);
		String name = responseAsJson.get("name");
		Assert.assertEquals(name, "venkat4","not matched");
		
		
		
		
		
		
	}

	
	
	
	
}
