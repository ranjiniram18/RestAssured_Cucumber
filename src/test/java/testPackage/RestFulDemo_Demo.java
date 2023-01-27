package testPackage;

import static org.testng.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestFulDemo_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		RequestSpecification httpRequest = RestAssured.given().relaxedHTTPSValidation();
		Response res = httpRequest.request(Method.GET, "");
		System.out.println(res.getStatusLine());// to print the whole status line
		System.out.println(res.getStatusCode());// to print the status code
		System.out.println(res.prettyPrint());

		int StatCode = res.getStatusCode();
		assertEquals(200, StatCode);// output:PASSED: test.RestAssuredApiTest.getUsers
	}

}
