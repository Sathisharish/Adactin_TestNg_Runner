package com.rest_assured;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.BaseClass.Base_Class;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest_API extends Base_Class {

	@Test

	public void Rest_Assured() throws IOException {
		
		String url = dataDriven("C:\\Users\\heman\\Desktop\\Sathish\\Project batch\\Test cases\\Postman Test case.xlsx", "particulardata", "Adactin", 4, 3);
		System.out.println(url);

		RestAssured.baseURI = url;

		RequestSpecification given = RestAssured.given();
		
		String parameter = dataDriven("C:\\Users\\heman\\Desktop\\Sathish\\Project batch\\Test cases\\Postman Test case.xlsx", "particulardata", "Adactin", 4, 4);
		System.out.println(parameter);
		
		Response response = given.get(parameter);
		
		String asString = response.asString();
		System.out.println(asString);

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		String status = dataDriven("C:\\Users\\heman\\Desktop\\Sathish\\Project batch\\Test cases\\Postman Test case.xlsx", "particulardata", "Adactin", 4, 6);
		
		int parseInt = Integer.parseInt(status);
		System.out.println(parseInt);

		Assert.assertEquals(parseInt, statusCode);
		System.out.println("Status sucesses");
		
		

	}

}
