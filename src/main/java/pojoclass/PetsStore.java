package pojoclass;

public class PetsStore {

	 int id;
	 Category category;
	 String name;
	 String[] photourl;
	 Tags[] tags;
	 String status;
	public PetsStore(int id, Category category, String name, String[] photourl, Tags[] tags, String status) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.photourl = photourl;
		this.tags = tags;
		this.status = status;
	}
	
	public PetsStore()
	{
		
	}

	public int getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String[] getPhotourl() {
		return photourl;
	}

	public Tags[] getTags() {
		return tags;
	}

	public String getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhotourl(String[] photourl) {
		this.photourl = photourl;
	}

	public void setTags(Tags[] tags) {
		this.tags = tags;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
