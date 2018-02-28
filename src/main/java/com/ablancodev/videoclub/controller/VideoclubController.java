package com.ablancodev.videoclub.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ablancodev.videoclub.model.Movie;

@Controller
@RequestMapping( "/" )
public class VideoclubController {


	// Vamos a redireccionar / a /movies
	@GetMapping( "/" )
	public String redirect() {
		return "redirect:/movies";
	}

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

	@GetMapping( "/addMovie" )
	public String addMovie( Model model ) {
		model.addAttribute( "movie", new Movie() );
		return "addMovie";
	}

	@PostMapping( "/actionAddMovie")
	public ModelAndView actionAddMovie( @ModelAttribute( "movie" ) Movie movie ) {
		// Aqui procesaríamos al objeto movie que nos manda el formulario, lo añadiríamos a base de datos o lo que necesitemos con esos datos.
		ModelAndView mav = new ModelAndView( "result" );
		mav.addObject( "movie", movie );
		return mav;
	}

	private ArrayList<Movie> getRepositoryMovies() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add( new Movie( "La momia", "Una película de una momia", "/images/momia.jpg" ) );
		movies.add( new Movie( "Misión Imposible", "La primera de la saga de Tom.", "/images/mision.jpg" ) );
		return movies;
	}

}
