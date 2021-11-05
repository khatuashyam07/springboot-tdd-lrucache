package com.shyam.lrucache.tddlrucachedemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import net.minidev.json.JSONObject;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TddLrucacheDemoApplication.class)
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class TddLrucacheDemoApplicationTests {

	@Value("${server.port}")
    int port;
	
	@Test
	void contextLoads() {
	}

	@Before
	public void setBaseUri () {

		 RestAssured.port = port;
		 RestAssured.baseURI = "http://localhost"; // replace as appropriate
	}
	@Test
	public void addToLRUCacheTest() {
		JSONObject requestBody = new JSONObject();
		requestBody.put("key", "key1"); 
		requestBody.put("value", "value1");
		Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/cache/addtocache")
                .then()
                .extract().response();
		
	    Assert.assertEquals(204, response.statusCode());
        
	}

	@Test
	public void getCacheTest() {
		
		Response response = RestAssured.given()
				.header("Content-type", "application/json")
                .pathParam("key", "key1")
                .when()
                .get("/cache/getcache/keys/{key}")
                .then()
                .extract().response();

		Assert.assertNotNull(response);
	    Assert.assertNotNull(response.getBody());
	    Assert.assertEquals(200, response.statusCode());
	}

	@Test
	public void getAllCacheTest() {
		
		Response response = RestAssured.given()
				.header("Content-type", "application/json")
                .when()
                .get("/cache/getallcache")
                .then()
                .extract().response();

		Assert.assertNotNull(response);
	    Assert.assertNotNull(response.getBody());
	    Assert.assertEquals(200, response.statusCode());
	}
}
