package com.atmecs.apitesting.testscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DeleteRequestTest {
	@Test
	public void deleteApiTest() throws MalformedURLException {

		// specify base uri
		String requestUrl = "https://reqres.in/api/users/7";

		// request object
		RequestSpecification request = RestAssured.given();

		// Response object
		Response response = request.delete(new URL(requestUrl)).then().extract().response();

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}
}
