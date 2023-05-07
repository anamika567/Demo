package pojoclass;

public class Spouse {
	
	String name;
	int[] phone;
	
	public Spouse(String name, int[] phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public Spouse() 
	{
		
	}

	public String getName() {
		return name;
	}

	public int[] getPhone() {
		return phone;
	}

}
