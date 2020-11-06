package com.atmecs.apitesting.testscripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetRequestTest {

	@Test
	public void getApiTest() {

		// specify base uri
		RestAssured.baseURI = "https://reqres.in/api/users";

		// request object
		RequestSpecification httprequest = RestAssured.given();

		// Response object
		Response response = httprequest.request(Method.GET, "/7");
		
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		JsonPath jsonpath = response.jsonPath();


		int id = jsonpath.get("data.id");
		String firstName = jsonpath.get("data.first_name");
		String lastName = jsonpath.get("data.last_name");
		String email = jsonpath.get("data.email");

		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(id, 7);
		Assert.assertEquals(firstName, "Michael");
		Assert.assertEquals(lastName, "Lawson");
		Assert.assertEquals(email, "michael.lawson@reqres.in");

		System.out.println("Status code is:" + statusCode);
		System.out.println("Response Body is:" + responseBody);
		System.out.println("Id is:" + id);
		System.out.println("First Name is:" + firstName);
		System.out.println("Last Name is:" + lastName);
		System.out.println("Email is:" + email);
	}
}