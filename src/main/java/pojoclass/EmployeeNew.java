package pojoclass;

public class EmployeeNew {

	public String name;
	public String id;
	public int[] phno;
	
	public EmployeeNew(String name, String id, int[] phno) {
		
		this.name = name;
		this.id = id;
		this.phno = phno;
	}
	
	public EmployeeNew() 
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int[] getPhno() {
		return phno;
	}

	public void setPhno(int[] phno) {
		this.phno = phno;
	}

	
	

}
