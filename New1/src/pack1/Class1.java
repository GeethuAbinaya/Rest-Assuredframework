package pack1;
import io.restassured.*;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;
import files.ReusableMethod;

public class Class1 {

	public static void main(String[] args) {

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response =given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.AddPlace()).when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();
		System.out.println(response);
		// JsonPath helps to parse Json It takes string as input

		JsonPath js = ReusableMethod.rawtoJson(response);

		String placeId =js.getString("place_id");
		System.out.println(placeId);

		//update API

		String newAdress= "Ot friends street";

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+newAdress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
		.body("msg",equalTo ("Address successfully updated"));


		//get api
		String newresponse =given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
				.when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
				.extract().asString();

		JsonPath js1 = ReusableMethod.rawtoJson(newresponse);
		String actualAddress =js1.getString("address");

		System.out.println("actualAddress"+actualAddress);
		Assert.assertEquals(actualAddress, newAdress);

		
		
	}

}
