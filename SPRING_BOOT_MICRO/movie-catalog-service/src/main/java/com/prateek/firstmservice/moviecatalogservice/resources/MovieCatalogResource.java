package com.prateek.firstmservice.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prateek.firstmservice.moviecatalogservice.models.Movie;
import com.prateek.firstmservice.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	  @Autowired
	    private RestTemplate restTemplate;
	
	 @RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")  String userid)
	{
		 
		 UserRating userRating = restTemplate.getForObject("http://localhost:8084/ratingsdata/" + userid, UserRating.class);
		 System.out.println(userRating);

    return userRating.getRatings().stream()
            .map(rating -> {
                Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                return new CatalogItem(movie.getName(), "Description", rating.getRating());
            })
            .collect(Collectors.toList());

		
	}

}
