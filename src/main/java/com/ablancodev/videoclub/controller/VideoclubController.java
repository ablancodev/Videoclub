package com.ablancodev.videoclub.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ablancodev.videoclub.model.Movie;

@Controller
@RequestMapping( "/" )
public class VideoclubController {

	@GetMapping( "/movies" )
	public ModelAndView getMovies() {
		ModelAndView mav = new ModelAndView( "movies" );
		ArrayList<Movie> listado = getRepositoryMovies();
		mav.addObject( "movies", listado);
		return mav;
	}

	/*
	// .../movie?id=xx
	@GetMapping( "/movie" )
	public ModelAndView getMovie( @RequestParam( name="id", required=false, defaultValue="NULL" ) String id ) {
		ModelAndView mav = new ModelAndView( "movie" );
		mav.addObject( "idMovie", id );
		return mav;
	}
	*/

	// .../movie/xx
	@GetMapping( "/movie/{id}" )
	public ModelAndView getMovie( @PathVariable( "id" ) String id ) {
		ModelAndView mav = new ModelAndView( "movie" );
		mav.addObject( "idMovie", id );
		return mav;
	}

	private ArrayList<Movie> getRepositoryMovies() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add( new Movie( "La momia", "Una película de una momia", "/images/momia.jpg" ) );
		movies.add( new Movie( "Misión Imposible", "La primera de la saga de Tom.", "/images/mision.jpg" ) );
		return movies;
	}
}
