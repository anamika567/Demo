package pojoclass;

public class EmployeeWithObject {

	String name;
	Spouse spouse;
	
	
	public EmployeeWithObject(String name, Spouse spouse) {
		this.name = name;
		this.spouse = spouse;
	}
	public EmployeeWithObject()
	{
		
	}
	public String getName() {
		return name;
	}
	public Spouse getSpouse() {
		return spouse;
	}
	
	
	
	
	
}
