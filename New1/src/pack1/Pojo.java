package pack1;

public class Pojo {
	
	// Serialisation - to use java object as payload . we use pojo class to convert given json into java object 
	

	//Example JSON
	//{"message":"Hello","Greet":"Hi"}
	
	//POJO class is as below
	//declare all variable as private and method as public 
	
	private String message;
	private String Greet;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getGreet() {
		return Greet;
	}
	public void setGreet(String greet) {
		Greet = greet;
	}
	
	//then create a oblect for this class where you need to send as payload 
	// Pojo pj = new Pojo();
	//pj.setMessage("Hello")
	//pj.setGreet("Hi")
	//can pass pj in body ...body(pj)
	
	
	
	
}
