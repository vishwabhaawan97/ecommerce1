package model;

public class category {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Category [name =" + name + ", description=" +description +"]";
	}
	private int id;
	private String name,description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
