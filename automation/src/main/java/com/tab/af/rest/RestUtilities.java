package com.tab.af.rest;
//TODO Implmentation Pending for 
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response; 
public class RestUtilities {

  public  String path;
  public  String jsonPathTerm;

  //Sets Base URI
  public  void setBaseURI() {
      RestAssured.baseURI = "";
  }

  //Sets base path
  public  void setBasePath(String basePathTerm) {
      RestAssured.basePath = basePathTerm;
  }

  //Reset Base URI (after test)
  public  void resetBaseURI() {
      RestAssured.baseURI = null;
  }

  //Reset base path
  public  void resetBasePath() {
      RestAssured.basePath = null;
  }

  //Sets ContentType
  public  void setContentType(ContentType Type) {
     

  }

  //Sets Json path term
  public  void setJsonPathTerm(String jsonPath) {
      jsonPathTerm = jsonPath;
  }

  //Created search query path
  public  void createSearchQueryPath(String searchTerm, String param, String paramValue) {
      path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
  }

  //Returns response
  public  Response getResponse() {
    return null;
      //System.out.print("path: " + path +"\n");
      //return get(path);
  }

  //Returns JsonPath object
  public  JsonPath getJsonPath(Response res) {
      String json = res.asString();
      //System.out.print("returned json: " + json +"\n");
      return new JsonPath(json);
  }
}
