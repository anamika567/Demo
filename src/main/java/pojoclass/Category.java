package pojoclass;

public class Category {

	int id;
	String name;
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Category()
	{
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
