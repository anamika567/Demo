package pojoclass;

public class Employee {
	
	// step1: declare variables globally
	
	String name;
	String id;
	int phone;
	
	
	// step2: create constructor
	
	public Employee(String name, String id, int phone) {
		
		this.name = name;
		this.id = id;
		this.phone = phone;
	}
	
	// step3: create empty constructor
	
	public Employee()
	{
		
	}

	//step4: provide getters and setters
	
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public int getPhone() {
		return phone;
	}

	
}
