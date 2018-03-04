package com.ablancodev.videoclub.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Movie {

	@NotNull
	@Size(min=2, max=255)
	private String name;

	private String description;
	private String image;

	public Movie() {
		
	}

	public Movie(String name, String description, String image) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
