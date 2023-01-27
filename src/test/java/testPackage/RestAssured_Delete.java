package testPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_Delete {

	public static void main(String[] args) {
		// DeleteMethod
		Response respDelete;
		int deleteStatusCode;
		String respToken;
		// DELETE Method
		RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
		newReq.cookie("token", "38cee7c0f4ab77c");

		newReq.baseUri("https://restful-booker.herokuapp.com/booking/15");

		respDelete = newReq.delete();
		deleteStatusCode = respDelete.getStatusCode();

		System.out.println(respDelete.getStatusCode());
	}
}