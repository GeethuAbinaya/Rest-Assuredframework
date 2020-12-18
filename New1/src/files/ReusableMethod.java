package files;

import io.restassured.path.json.JsonPath;

public  class ReusableMethod {
	
	public static  JsonPath rawtoJson( String response)
	{
	
	JsonPath js1 = new JsonPath(response);
	//String actualAddress =js1.getString("address");
return js1;
	}
}
