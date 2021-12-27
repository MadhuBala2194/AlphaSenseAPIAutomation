package APITest;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Test
public class LoginTest {
	
	public void loginRequestpositiveResult() throws IOException {
		
	byte[] file=Files.readAllBytes(Paths.get("src/test/resources/AuthPayload.json"));
	String filein = new String(file);
	RestAssured.baseURI="https://rc.alpha-sense.com/services/auth-ws-v3";

    given()
		
		.contentType(ContentType.JSON)
		
		.header("Content-Type","application/json")
		.body(filein)
	.when()
		.post("/oauth/token")
	.then()
		.assertThat()
		.statusCode(401).log().all()
		.statusLine("HTTP/1.1 401 ")
		.body("error", Matchers.is("Unauthorized"));
		
}
	@Test
	public void loginRequestNegativeResult() throws IOException {
		
		byte[] file=Files.readAllBytes(Paths.get("src/test/resources/AuthPayload.json"));
		String filein = new String(file);
		RestAssured.baseURI="https://rc.alpha-sense.com/services/auth-ws-v3";

	    given()
			
			.contentType(ContentType.JSON)
			
			.header("Content-Type","application/json")
			.body(filein)
		.when()
			.post("/oauth/token")
		.then()
			.assertThat()
			.statusCode(201).log().all()
			.statusLine("HTTP/1.1 200 OK");
			
			
	}

}
