package subject;



public class Subject {

	private String title ; 
	private String category ; 
	private String description ;
	private int code ;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Subject [code=" + code + ", title=" + title + ", category=" + category + ", description=" + description
				+ "]";
	}
	
}
