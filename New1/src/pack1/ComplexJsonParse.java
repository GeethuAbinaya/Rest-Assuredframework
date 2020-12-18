package pack1;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
		JsonPath js= new JsonPath(Payload.CoursePrice());
		int course_size=js.getInt("courses.size()");
		System.out.println("course_size"+course_size);
		
		String title_1 =js.getString("courses[0].title");
		System.out.println("title"+title_1);
		
		String title_2 =js.getString("courses[1].title");
		System.out.println("title"+title_2);
		
		String title_3 =js.getString("courses[2].title");
		System.out.println("title"+title_3);
		
		int Pr_1 =js.getInt("courses[0].price");
		System.out.println("title"+Pr_1);
		
		int Pr_2 =js.getInt("courses[1].price");
		System.out.println("title"+Pr_2);
		
		int Pr_3 =js.getInt("courses[2].price");
		System.out.println("title"+Pr_3);
		
		int co_1 =js.getInt("courses[0].copies");
		System.out.println("title"+co_1);
		
		int co_2 =js.getInt("courses[1].copies");
		System.out.println("title"+co_2);
		
		int co_3 =js.getInt("courses[2].copies");
		System.out.println("title"+co_3);
		System.out.println("Title of first course  :  "+title_1+ "and its price is:  "+Pr_1);
		System.out.println("Title of second course  :  "+title_2+ "and its price is:  "+Pr_2);
		System.out.println("Title of third course  :  "+title_3+ "and its price is:  "+Pr_3);
		
		

		int sum = (Pr_1*co_1)+(Pr_2*co_2)+(Pr_3*co_3);
		System.out.println( sum);

		for (int i=0;i<=course_size;i++)
		{
			String title= js.get("courses["+i+"].title");
			
			if(title.equalsIgnoreCase("RPA"))
			{
	int copi=js.getInt("courses["+i+"].copies");
	System.out.println( copi);
	break;
			}
		}
		
		
		
		int purchase=js.getInt("dashboard.purchaseAmount");
		System.out.println("PA"+purchase);
		
		
		
		
	}

}
