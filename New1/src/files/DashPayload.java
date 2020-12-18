package files;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import pojo.Automation;
import pojo.Courses;
import pojo.GetCourse;
import pojo.WebAutomation;

public class DashPayload {
	
	@Test
	public static pojo()
	{
		GetCourse response = given().queryParam("access_token","asdsdsf").expect().defaultParser(Parser.JSON)
		.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class)
		
		//in the above 2 lines :expect().defaultParser(Parser.JSON)--this shows the type in which the response should be read
		//if content type in header is mentioned as application .JSON then we no need to give this
		//as(GetCourse.class)--- it is to read the response in GetCourse.class format
		
		//to use POJO class we need 4 jars
		//jackson- datamind,jackson core,jackson annotation,GSON
		//serialisation -setter (json to java object as payload)
		//deserialisation -getter(from payload)
		
		String[] title= {"Selenium","cypasaress","RPAghfgh"};
		
		int a=response.getCourses().getAutomation().get(0).getCopies();
		Courses b = response.getCourses();
		List<Automation> c = response.getCourses().getAutomation();
		
		for(int i=0;i<c.size();i++)
		{
			if(c.get(i).getTitle().equalsIgnoreCase("ui"))
			{
				c.get(i).getPrice();
			}
		}
		
		ArrayList<String> al = new ArrayList<String>();
		
		
		List<WebAutomation> d = response.getCourses().getWebAutomation();
		for(int i=0;i<d.size();i++)
		{
			al.add(d.get(i).getTitle());
			
		}
		//to compare 2 things they need to be same  so changing line 32 whih is in array into arraylist
		ArrayList<String>al1=(ArrayList<String>) Arrays.asList(title);
		Assert.assertTrue(al.equals(al1));
		
		
	}

}
