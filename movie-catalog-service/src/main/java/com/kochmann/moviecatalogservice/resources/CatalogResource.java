package com.kochmann.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kochmann.moviecatalogservice.models.CatalogItem;
import com.kochmann.moviecatalogservice.models.Movie;
import com.kochmann.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
				
		RestTemplate restTemplate = new RestTemplate();
		
		// 1) Obter todos os movies IDs
		
		List<Rating> ratingList = Arrays.asList(new Rating("12", 5), new Rating("15", 2));

		return ratingList.stream().map(rating -> {
		// 2) Para cada movie Id, chamar movie info service e get details
		Movie movie = restTemplate.getForObject("http://localhost:8082/movies/ " + rating.getMovieId(), Movie.class);

		return new CatalogItem(movie.getName(), "filmao", rating.getRating());
		})
				
		// 3) Colocar tudo junto
				.collect(Collectors.toList());

		// retorno inicial, para teste

		// return Collections.singletonList(
		// new CatalogItem("Transformers","Filme de Robô", 4));

	}
}
