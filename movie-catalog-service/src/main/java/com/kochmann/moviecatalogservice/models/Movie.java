package com.kochmann.moviecatalogservice.models;

public class Movie {

	private String movieId;
	private String name;
	private String description;

	// Aqui indica como esta classe poderá ser acessada
	public Movie(String movieId, String name, String description) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// obj vazio, acessado depois populado
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
