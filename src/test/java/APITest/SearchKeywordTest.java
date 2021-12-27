package APITest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SearchKeywordTest {
	RequestSpecification rspec;
	RequestSpecBuilder build;

	@BeforeClass
	public void requestSpec () {

	build = new RequestSpecBuilder();
	build.setBaseUri ("https://rc.alpha-sense.com/services/i/public-document-data/document/PR-386ea743f2a90399fb0e4300ddf37d0697abc743");
	build.setBasePath ("/keyword-search");
	build.addQueryParam("slop", "15")
	.addQueryParam("positiveOnly", "false")
	.addQueryParam("negativeOnly", "false").addQueryParam("released", "1633003200000");
	
	rspec = build.build ();

	}
	@Test
	public void searchWithValidKeyword () {
		
		Response response =
	     given()
	    .spec (rspec)
	    .queryParam("keyword", "Alpha")
	    .when ()
	    .get ("")
	    .then ()
	    .contentType (ContentType.JSON)
	    .assertThat()
	    .statusCode (200)
	    .statusLine("HTTP/1.1 200 OK") .extract().response(); 
	     String json = response.asString();
		  Assert.assertEquals(json.contains("www.alpha-sense.com"), true);  
	 }
	@Test
	public void searchWithInvalidKeyword () {
		
		Response response =
	     given()
	    .spec (rspec)
	    .queryParam("keyword", "...")
	    .when ()
	    .get ("")
	    .then ()
	    .contentType (ContentType.JSON)
	    .assertThat() 
	    .log().all()
		.statusCode(500)
		.statusLine("HTTP/1.1 500 Internal Server Error")
		.extract().response();
		String json = response.asString();
		 Assert.assertEquals(json.contains("Request failed with status code 400"),true);
	}
		
}
		
		  
		  
		 
