package com.ablancodev.videoclub.service;

import java.util.List;

import com.ablancodev.videoclub.entity.Movie;

public interface MoviesService {

	public abstract List<Movie> listAllMovies();
	public abstract Movie addMovie(Movie movie);
	public abstract int removeMovie( int id );
	public abstract Movie updateMovie( Movie movie );

}
