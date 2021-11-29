package com.kochmann.moviecatalogservice.models;

public class Movie {

	private String movieId;
	private String name;

	// Aqui indica como esta classe poderá ser acessada
	public Movie(String movieId, String name) {
		super();
		this.movieId = movieId;
		this.name = name;
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
