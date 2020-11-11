package com.atmecs.apitesting.testscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginTest {
	@Test
	public void LoginApiTest() throws MalformedURLException {
	String requestUrl="https://reqres.in/api/users/7";
	RequestSpecification request = RestAssured.given();

	Response response = request
	.auth()
	.preemptive()
	.basic("", "")


	.get(new URL(requestUrl))
	.then()
	.extract()
	.response();


	int statusCode = response.getStatusCode();
	String responseBody = response.getBody().asString();

	System.out.println("Status Code: " + statusCode);
	System.out.println("responseBody: " + responseBody);


	Assert.assertEquals(statusCode, 200);
	}
}

