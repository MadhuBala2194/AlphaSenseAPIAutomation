package APITest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ManifestTest {
	
	 @Test public void manifest() {
		  
		  RestAssured.baseURI = "https://rc.alpha-sense.com/document-viewer";
		  
		  given() .when() .get("/manifest-rc.json") .then() .assertThat()
		  .statusCode(200) .statusLine("HTTP/1.1 200 OK") .body("release",
		  equalTo("v2.16.2"));
		  
		  }
		 

}
