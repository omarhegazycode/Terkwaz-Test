/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    18/11/2020  - ApiTesting created.
 */
package testcases;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import utilities.Reporter;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;



public class ApiTesting
{
	@Test
	void TestAPI()
	{
		String APIURL = utilities.LoadProperties.userData.getProperty("APIURL");  //Getting the API URL from data file
		
		given()     //Making the API testing by sending the request with "animaltype Cat " parameters
		      .accept(ContentType.JSON)
		      .param("animal_type","cat")
		      .when()
		      .get(APIURL)
		      .then()
		      .assertThat()
		      .statusCode(200)
		      .and()
		      .assertThat()
		      .body("text", not(empty()))  //Assert that the response body is not empty by checking the text
		      .log()
		      .all();
		RequestSender httpRequest = RestAssured.given();  //Getting the Request
		Response response = httpRequest.get(APIURL);  //Getting the response
		String body = response.asString();  //Getting the body for printing
		Reporter.Log("Request " +"["+ httpRequest+"]");  //Print the request in the report 
		Reporter.Log("Response "+"["+response+"] ");   //Print the response in the report 
		Reporter.Log("Response body: "+"["+body+"] ");  //Print the body in the report 
		Reporter.Log("### API test case passed successfully ###");

		
	}


}
