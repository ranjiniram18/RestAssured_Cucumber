package testPackage;

//import io.restassured.specification.RequestSpecification; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestfullWithAnnotations {

	String topass;

	@Test
	public void UpdateBooking() {
		String jsonString1 = "{\n" + "    \"firstname\" : \"Ranjini\",\n" + "    \"lastname\" : \"Ram\",\n"
				+ "    \"totalprice\" : 111,\n" + "    \"depositpaid\" : true,\n" + "    \"bookingdates\" : {\n"
				+ "        \"checkin\" : \"2023-01-27\",\n" + "        \"checkout\" : \"2023-01-28\"\n" + "    },\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\n" + "}";
		RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
		newReq.contentType(ContentType.JSON);
		newReq.cookie("token", topass);
		newReq.baseUri("https://restful-booker.herokuapp.com/booking/10");
		newReq.body(jsonString1);
		Response res = newReq.put();
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		String Fname = res.getBody().jsonPath().getString("firstname");
		System.out.println(Fname);
	}

	@BeforeTest
	public void beforeTest() {
		String jsonString = "{\"username\": \"admin\",\"password\": \"password123\"}";
		RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
		newReq.contentType(ContentType.JSON);
		newReq.baseUri("https://restful-booker.herokuapp.com/auth");
		newReq.body(jsonString);
		Response res = newReq.post();
		System.out.println(res.asString());
		topass = res.getBody().jsonPath().getString("token");
		System.out.println(topass);

	}
}
