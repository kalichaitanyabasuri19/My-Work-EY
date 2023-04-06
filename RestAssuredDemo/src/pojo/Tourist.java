package pojo;

public class Tourist {
	
	private String tourist_name;
	private String tourist_email;
	private String tourist_location;
	
	public Tourist(String tourist_name, String tourist_email, String tourist_location) {
		this.tourist_name=tourist_name;
		this.tourist_email=tourist_email;
		this.tourist_location=tourist_location;
		
	}
	public void settourist_name(String name) {
		 this.tourist_name=name;
	}
	 
	public void settourist_email(String email) {
		this.tourist_email=email;
	}
	
	public void settourist_location(String location) {
		this.tourist_location=location;
	}
	
	public String gettourist_name() {
		return tourist_name;
	}
	public String gettourist_email() {
		return tourist_name;
	}
	public String gettourist_location() {
		return tourist_location;
	}
	

}
