package pack1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider="BooksData")
	
	public void addBook(String isbn,String aisle)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		String Lib_res =given().header("Content-Type","application/json").body(Payload.Library(isbn,aisle)).when().post("Library/AddBook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=ReusableMethod.rawtoJson(Lib_res)	;
		String Id=js.get("Id");
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		//array-collection of elements :new obj[]{1,2,3}
		//multidim -collection of array : new obj[][]{arr1,arr2,arr3}  :new obj[][]{{},{},{}}
	
	return new Object[][] {{"fios","1234"},{"hgdghd","hfhf"},{"gfggf","hjgjh"}};

}
}