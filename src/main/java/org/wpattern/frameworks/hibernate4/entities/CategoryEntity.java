package org.wpattern.frameworks.hibernate4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.wpattern.frameworks.hibernate4.utils.BaseBean;

@Entity
@Table(name = "Categories")
public class CategoryEntity extends BaseBean {

	private static final long serialVersionUID = -16240817663243274L;

	@Id
	@GeneratedValue
	@Column(name = "categoryID")
	private Long id;

	private String categoryName;

	private String description;

	private Byte[] picture;

	public CategoryEntity() {
	}

	public CategoryEntity(String categoryName, String description, Byte[] picture) {
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}

}
