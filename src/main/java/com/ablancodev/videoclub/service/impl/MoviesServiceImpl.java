package com.ablancodev.videoclub.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ablancodev.videoclub.model.Movie;
import com.ablancodev.videoclub.service.MoviesService;

@Service( "moviesService" )
public class MoviesServiceImpl implements MoviesService {

	@Override
	public List<Movie> getListMovies() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add( new Movie( "La momia", "Una película de una momia", "/images/momia.jpg" ) );
		movies.add( new Movie( "Misión Imposible", "La primera de la saga de Tom.", "/images/mision.jpg" ) );
		return movies;
	}

	

}
