package com.kochmann.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

	/*
	 * Bean informa que tem algum dado disponível e o Autowired informa que precisa
	 * desse dado.
	 * 
	 * Autowired informa ao Spring que em algum lugar (MovieatalogServideApp) existe
	 * um BEAN desse RestTemplate e o inject precisa desse dados e é injetado aqui
	 */
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		// 1) Obter todos os movies IDs

		List<Rating> ratings = Arrays.asList(new Rating("12", 5), new Rating("15", 2));

	
		return ratings.stream().map(rating -> {
			
			// 2) Para cada movie Id, chamar movie info service e get details
			
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/ " + rating.getMovieId(),
					Movie.class);

			return new CatalogItem(movie.getName(), "filmao", rating.getRating());
		})

				// 3) Colocar tudo junto
				.collect(Collectors.toList());

		/*
		 * retorno inicial, para teste
		 * 
		 * return Collections.singletonList( // new
		 * CatalogItem("Transformers","Filme de Robô", 4));
		 */
	}
}
