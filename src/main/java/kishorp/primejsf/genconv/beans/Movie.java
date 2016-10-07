package kishorp.primejsf.genconv.beans;

import java.io.Serializable;

public class Movie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5383363279842049673L;
	
	private String uniqueId;
	private String name;
	private String year;
	private float rating;
	
	public Movie(){}
	
	public Movie(String uniqueId, String name, String year, float rating) {
		super();
		this.uniqueId = uniqueId;
		this.name = name;
		this.year = year;
		this.rating = rating;
	}
	
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [uniqueId=" + uniqueId + ", name=" + name + ", year="
				+ year + ", rating=" + rating + "]";
	}
	
	
	

}
