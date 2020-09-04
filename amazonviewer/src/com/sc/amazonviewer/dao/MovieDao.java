package com.sc.amazonviewer.dao;

import java.util.ArrayList;

import com.sc.amazonviewer.model.Movie;

public interface MovieDao {
	
	default Movie setMovieViewed(Movie movie) {
		return movie;
	}

	default ArrayList<Movie> read(){
		ArrayList <Movie> movies = new ArrayList<Movie>();
		return movies;
	}
	
	default boolean getMovieViewed() {
		return false;
	}
}
