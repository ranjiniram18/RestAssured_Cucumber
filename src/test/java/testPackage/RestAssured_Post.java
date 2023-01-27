package testPackage;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestAssured_Post {
	public static void main(String[] args) {
		{
			// Post method
			// Get the base URL

			String jsonString = "{\"username\":\"admin\",\"password\":\"password123\"}";
			RequestSpecification newRequest = RestAssured.given().relaxedHTTPSValidation();
			newRequest.contentType(ContentType.JSON);
			newRequest.baseUri("https://restful-booker.herokuapp.com/auth");
			newRequest.body(jsonString);
			Response resp = newRequest.post();
			System.out.println(resp.asString());
			ValidatableResponse vResp = resp.then();
			vResp.statusCode(200);
			vResp.body("Tocken", Matchers.notNullValue());// Validation of tocken not null value
			vResp.body("Tocken", Matchers.matchesRegex("^[a-z0-9]+$"));

		}
	}

}
//400 series is client error