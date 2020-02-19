package com.tab.af.api.steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import java.io.IOException;

import com.tab.af.testbase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinition {

	@Given("load base components")
	public void load_base_components() throws IOException {

		RestAssured.baseURI = (String) TestBase.apiProp.get("base.URI");
	}

	@When("user sends request for get customer types")
	public void user_sends_request_for_get_customer_types() throws IOException {
		RestAssured.basePath = "customer-types";

	}

	
	@Then("type of customers should be Returned as {string} and {string}")
	public void type_of_customers_should_be_Returned_as_and(String string, String string2) {
		Response res = RestAssured.get();
		res.then().body("displayName", hasItems(string, string2));
		res.then().statusCode(200);
	}
	  
	
	@When("user sends request for get Occupation types")
	public void user_sends_request_for_get_Occupation_types() {
		RestAssured.basePath = "occupation-types";
	}
 
 
	@Then("type of Occupation should be Returned as {string} and {string}")
	public void type_of_Occupation_should_be_Returned_as_and(String string, String string2) {
		Response res = RestAssured.get();
		res.then().body("name", hasItems(string, string2));
		res.then().statusCode(200);
	}
	

	
	
	
	@When("user sends request for get Income Range types")
	public void user_sends_request_for_get_Income_Range_types() {
		RestAssured.basePath = "income-range-types";
	}
	@Then("type of Income Range should be Returned as {string} and {string}")
	public void type_of_Income_Range_should_be_Returned_as_and(String string, String string2) {
		Response res = RestAssured.get();
		res.then().body("rangeValue", hasItems(string, string2));
		res.then().statusCode(200);
	}

	 
	
	@When("user sends request for get Nature of Business types")
	public void user_sends_request_for_get_Nature_of_Business_types() {
		RestAssured.basePath = "nature-of-business-types";
	}

	@Then("type of Nature of Business should be Returned as {string} and {string}")
	public void type_of_Nature_of_Business_should_be_Returned_as_and(String string, String string2) {
		Response res = RestAssured.get();
		res.then().body("name", hasItems(string, string2));
		res.then().statusCode(200);
	}
	@When("user sends request for get Product types")
	public void user_sends_request_for_get_Product_types() {
		RestAssured.basePath = "product-types";
	}

	@Then("type of Product should be Returned according to the Query Params productLine as {string}  and custType as {string}")
	public void type_of_Product_should_be_Returned_according_to_the_Query_Params_productLine_as_and_custType_as(String productLine, String custType) {
		Response res = given().queryParams("productLine", productLine).queryParam("custType", custType).get();
		System.out.print(productLine);
		System.out.print(custType);
		res.then().body("", hasSize(5));
	}
	 

	@When("user sends request for get Products")
	public void user_sends_request_for_get_Products() {
		RestAssured.basePath = "products";
	}

	@Then("type of Product should be Returned according to the Query Params custType as {string}")
	public void type_of_Product_should_be_Returned_according_to_the_Query_Params_custType_as(String custType) {
		Response res = given() .queryParam("cust_type", custType).get();
		res.then().statusCode(200);
	}

	 

}
