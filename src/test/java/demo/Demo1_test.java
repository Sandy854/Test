package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class Demo1_test {
	public static final String ANSI_PURPLE = "\033[0;35m";
	public static final String ANSI_RESET = "\033[0m";
  @Test
   void getWeatherDetails() {
	  	RestAssured.baseURI="https://reqres.in/api/users/";
		
		RequestSpecification httpRequest=RestAssured.given();
		Response response= httpRequest.request(Method.GET,"2");
		
		String responseBody=response.getBody().asString();
		System.out.println(ANSI_PURPLE + "Response Body is: " + ANSI_RESET+responseBody );
		
		int statusCode=response.getStatusCode();
		System.out.println(ANSI_PURPLE +"Status Code is: "+ ANSI_RESET+statusCode);
		
		JsonPath jsonpath=response.jsonPath();
		
		System.out.println(jsonpath.get("data.id"));
		System.out.println(jsonpath.get("data.email"));
		System.out.println(jsonpath.get("data.first_name"));
		System.out.println(jsonpath.get("data.last_name"));
		System.out.println(jsonpath.get("data.avatar"));
		System.out.println(jsonpath.get("ad.company"));
		System.out.println(jsonpath.get("ad.url"));
		System.out.println(jsonpath.get("ad.text"));
		
		Assert.assertEquals(statusCode, 200);
  }

}
