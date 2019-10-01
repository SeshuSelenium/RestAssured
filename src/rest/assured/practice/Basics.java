package rest.assured.practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Basics {
	@Test
	public void testGetValaidation() {
		// base url
		RestAssured.baseURI = "https://maps.googleapis.com";
		// inside the given we need to give parameters
		given().param("location", "-33.8670522,151.1957362").param("radius", "1500")
				.param("key", "AIzaSyDFBogTX6Qn46XxzF87DYGWOjslO-Bpbng").
				// inside when we need to pass resource
				when().get("/maps/api/place/nearbysearch/json").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().body("results[0].name", equalTo("Sydney")).and().
				body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
				header("Server", "scaffolding on HTTPServer2");
			
		// in assertion
		// validate status code of the response
		// validate content type
		// validate body by using result namfire and place id using equalTo function 
		// validate header values
		// this is for get request validation
	}

}
