package com.demo.testOne;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class Prac {
	
	@Test
	public void prac() {
		
		RestAssured.baseURI="https://reqres.in";
		given().header("Content-Type","application/json").when().get("/api/users").then().
		assertThat().statusCode(200).and().body("data[2].first_name", equalTo("Emma2"));
		
		
		
	}
	

}
