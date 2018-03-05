package com.ablancodev.videoclub.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ablancodev.videoclub.entity.Movie;
import com.ablancodev.videoclub.repository.MovieJpaRepository;
import com.ablancodev.videoclub.service.MoviesService;

@Service( "moviesService" )
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	@Qualifier("movieJpaRepository")
	MovieJpaRepository movieJpaRepository;

	@Override
	public List<Movie> listAllMovies() {
		return movieJpaRepository.findAll();
	}

	@Override
	public Movie addMovie(Movie movie) {
		return movieJpaRepository.save( movie );
	}

	@Override
	public int removeMovie(int id) {
		movieJpaRepository.delete( id );
		return 0;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return movieJpaRepository.save( movie );
	}

	

}
