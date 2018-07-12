package com.stackroute.keepnote.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * The class "Category" will be acting as the data model for the Category Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */
@Entity
public class Category {
	/*
	 * This class should have six fields
	 * (categoryId,categoryName,categoryDescription,
	 * categoryCreatedBy,categoryCreationDate,notes). Out of these six fields, the
	 * field categoryId should be primary key and auto-generated. This class should
	 * also contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method. The value of
	 * categoryCreationDate should not be accepted from the user but should be
	 * always initialized with the system date. annotate notes field with @OneToMany
	 * and @JsonIgnore
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int categoryId;
	private String categoryName;
	private String categoryDescription;
	private String categoryCreatedBy;
	private Date categoryCreationDate;
	@OneToMany
	@JsonIgnore
	private List<Note> notes;
	

	public Category() {

	}
	public Category(int categoryId, String categoryName, String categoryDescription,Date categoryCreationDate, String categoryCreatedBy,
			 List<Note> notes) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryCreatedBy = categoryCreatedBy;
		this.categoryCreationDate = categoryCreationDate;
		this.notes = notes;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryCreatedBy() {
		return categoryCreatedBy;
	}

	public void setCategoryCreatedBy(String categoryCreatedBy) {
		this.categoryCreatedBy = categoryCreatedBy;
	}

	public Date getCategoryCreationDate() {
		return categoryCreationDate;
	}

	public void setCategoryCreationDate(Date categoryCreationDate) {
		this.categoryCreationDate = categoryCreationDate;
	}

	

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryCreatedBy == null) ? 0 : categoryCreatedBy.hashCode());
		result = prime * result + ((categoryCreationDate == null) ? 0 : categoryCreationDate.hashCode());
		result = prime * result + ((categoryDescription == null) ? 0 : categoryDescription.hashCode());
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryCreatedBy == null) {
			if (other.categoryCreatedBy != null)
				return false;
		} else if (!categoryCreatedBy.equals(other.categoryCreatedBy))
			return false;
		if (categoryCreationDate == null) {
			if (other.categoryCreationDate != null)
				return false;
		} else if (!categoryCreationDate.equals(other.categoryCreationDate))
			return false;
		if (categoryDescription == null) {
			if (other.categoryDescription != null)
				return false;
		} else if (!categoryDescription.equals(other.categoryDescription))
			return false;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", categoryCreatedBy=" + categoryCreatedBy + ", categoryCreationDate="
				+ categoryCreationDate + ", notes=" + notes + "]";
	}

	

}