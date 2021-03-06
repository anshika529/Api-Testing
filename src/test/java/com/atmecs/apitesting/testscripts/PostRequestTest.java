package com.atmecs.apitesting.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestTest {
@Test
	public void PostApiTest(Object requestbody) throws MalformedURLException {
		System.out.println("Request body: " + requestbody);

		String requestUrl = "https://reqres.in/api/users";

		HashMap<String, Object> headers = new HashMap<String, Object>();
		headers.put("Content-Type", "application/json");

		RequestSpecification request = RestAssured.given().headers(headers);

		Response response = request.when().body(requestbody.toString()).post(new URL(requestUrl)).then().extract()
				.response();

		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		System.out.println("Status Code: " + statusCode);
		System.out.println("responseBody: " + responseBody);

		Assert.assertEquals(statusCode, 201);

		JsonPath jsonPath = response.jsonPath();

		String name = jsonPath.getString("name");
		System.out.println("Name : " + name);

		JSONObject jsonObject = (JSONObject) requestbody;
		Assert.assertEquals(name, jsonObject.get("name").toString());

		String id = jsonPath.getString("id");
		System.out.println("Id  : " + id);
	}

}
