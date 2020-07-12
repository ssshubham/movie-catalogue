package io.javabrains.ratingsinfoservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingsinfoservice.models.Rating;
import io.javabrains.ratingsinfoservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		// return new Rating(movieId, 4);
		List<Rating> rating = Arrays.asList(
				new Rating("1234", 4),
				new Rating("5678", 3)
				);
		
		UserRating userRating = new UserRating();
		userRating.setUserRating(rating);
		return userRating;
	}
	
	
}
