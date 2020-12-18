package pack1;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumofCourse()
	
	{
		JsonPath js1= new JsonPath(Payload.CoursePrice());
		int course_size= js1.getInt("courses.size()");
		
		for (int i=0;i<=course_size;i++)
		{
			int price= js1.get("courses["+i+"].price");
			int copies= js1.get("courses["+i+"].copies");
			int sum =price*copies;
			
			 System.out.println(sum);
			
			//if(i==course_size)
			//{
			//	System.out.println(sum);
			//}
			
		}
		
	}

}
