package pack1;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import googleApi.Location;
import googleApi.Post;

public class SerializeTest {
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
		
		RestAssured.baseURI="https://rahulshettyacademy.com"  ;
		String res =given().log().all().queryParam("key", "qaclick123").body(p)
		.when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(res);
	}

}
