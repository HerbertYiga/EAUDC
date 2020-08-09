package com.eaudc.bean;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PersonBean {

	private Integer[] checkedIds;
	private String imageLink;
	private String sirName;
	private String otherName;
	private String country;
	private String category;
	private Integer personId;

	private String university;

	private List<MultipartFile> images;

	// sir name
	public String getSirName() {
		return sirName;
	}

	public void setSirName(String sirName) {
		this.sirName = sirName;
	}

	// other name
	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	// country
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	// category
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	// university
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	// person id
	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	// images
	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	// image link
	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	// checked ids
	public Integer[] getCheckedIds() {
		return checkedIds;
	}

	public void setCheckedIds(Integer[] checkedIds) {
		this.checkedIds = checkedIds;
	}

}
