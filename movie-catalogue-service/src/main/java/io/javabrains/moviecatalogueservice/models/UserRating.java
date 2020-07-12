package io.javabrains.moviecatalogueservice.models;

import java.util.List;

public class UserRating {

	private List<Rating> userRating;
	
	public List<Rating> getUserRating() {
		return userRating;
	}
	public void setUserRating(List<Rating> rating) {
		this.userRating = rating;
	}
}
