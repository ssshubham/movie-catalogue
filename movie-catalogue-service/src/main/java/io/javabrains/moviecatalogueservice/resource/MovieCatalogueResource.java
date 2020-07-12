package io.javabrains.moviecatalogueservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogueservice.models.CatalogueItem;
import io.javabrains.moviecatalogueservice.models.Movie;
import io.javabrains.moviecatalogueservice.models.Rating;
import io.javabrains.moviecatalogueservice.models.UserRating;

@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogueItem> getCatalogue(@PathParam("userId") String userId) {
		
		UserRating ratings = restTemplate.getForObject("http://ratings-service/ratingsdata/users/" + userId, UserRating.class);
		return ratings.getUserRating().stream().map(rating ->	{
			// For each movieId call movie info service and get details
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+ rating.getMovieId(), Movie.class);
			// Put all info received together
			return new CatalogueItem(movie.getMovieId(), "Testtsing", rating.getRating()); 
		}).collect(Collectors.toList());
		
		/*
		Movie movie = webClientBuilder.build()
						.get()	
						.uri("http://localhost:8083/movies/"+ rating.getMovieId())
						.retrieve()
						.bodyToMono(Movie.class)
						.block();
		*/
	}
}
