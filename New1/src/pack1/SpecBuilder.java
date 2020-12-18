package pack1;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import googleApi.Location;
import googleApi.Post;

public class SpecBuilder {
	public static void main(String[] args) {
		Post p = new Post();
		Location l= new Location();
		List<String> ls= new ArrayList<String>();
		ls.add("geethu");
		ls.add("abinaya");
		l.setLat(500);
		l.setLng(-567);
		
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setLocation(l);
		p.setName("Frontline house");
		p.setPhone_number("asd12345");
		p.setTypes(ls);
		p.setWebsite("http://google.com");
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification respSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
				.expectStatusCode(200).build();
		
		
		//RestAssured.baseURI="https://rahulshettyacademy.com"  ;
		
		RequestSpecification req1 =given().spec(req).body(p);
	
		String response = req1.when().post("/maps/api/place/add/json").then().spec(respSpec).extract().response().asString();
	
		
		
		System.out.println(response);
		
	}

}
