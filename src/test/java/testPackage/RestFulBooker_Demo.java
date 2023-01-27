package testPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestFulBooker_Demo {
	@Test
	public void createBooking() {
		String jsonStr = "{\n" + "    \"firstname\" : \"Ranjini\",\n" + "    \"lastname\" : \"Eam\",\n"
				+ "    \"totalprice\" : 111,\n" + "    \"depositpaid\" : true,\n" + "    \"bookingdates\" : {\n"
				+ "        \"checkin\" : \"2023-01-27\",\n" + "        \"checkout\" : \"2023-01-28\"\n" + "    },\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\n" + "}";
		RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking").post().then().assertThat()
				.statusCode(200); // assert status is 200 (success)
	}
}