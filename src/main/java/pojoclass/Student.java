package pojoclass;

public class Student {
	
	String name;
	int id;
	int contact;
	
	public Student(String name, int id, int contact) {
		this.name = name;
		this.id = id;
		this.contact = contact;
	}
	
	public Student()
	{
		
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getContact() {
		return contact;
	}
	

}
