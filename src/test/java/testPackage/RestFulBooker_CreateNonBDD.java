package testPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestFulBooker_CreateNonBDD {
	@Test
	public void CreateBooking() {
		String jsonString1 = "{\n" + "    \"firstname\" : \"Ranjini\",\n" + "    \"lastname\" : \"Ram\",\n"
				+ "    \"totalprice\" : 111,\n" + "    \"depositpaid\" : true,\n" + "    \"bookingdates\" : {\n"
				+ "        \"checkin\" : \"2023-01-27\",\n" + "        \"checkout\" : \"2023-01-28\"\n" + "    },\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\n" + "}";

		RestAssured.baseURI = "https://gorest.co.in/public/v2/users/";
		RequestSpecification httpRequest = RestAssured.given().relaxedHTTPSValidation();
		httpRequest.body(jsonString1);
		httpRequest.cookie("token", "38cee7c0f4ab77c");
		httpRequest.contentType(ContentType.JSON);
		Response res = httpRequest.post();
		System.out.println(res.getStatusLine());
		System.out.println(res.getStatusCode());// to print the status code
		System.out.println(res.prettyPrint());
	}
}
